package com.javarush.test.level19.lesson10.home02;

/* Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Вывести в консоль имена, у которых максимальная сумма
Имена разделять пробелом либо выводить с новой строки
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        Map<String, Double> map = new HashMap<>();

        while (reader.ready()) {
            String[] result = reader.readLine().split(" ");
            String name = result[0];
            double d = Double.parseDouble(result[1]);
            if (map.containsKey(name))
                map.put(name, map.get(name) + d);
            else
                map.put(name, d);
        }
        double a = 0.0;
        String str = "";
        for (Map.Entry<String, Double> s : map.entrySet()) {
            if (a < s.getValue())
            {
                a = s.getValue();
                str = s.getKey();
            }
        }
        for (Map.Entry<String, Double> s : map.entrySet()) {
            if (s.getValue() == a)
                System.out.println(s.getKey());
        }
        reader.close();
    }
}
