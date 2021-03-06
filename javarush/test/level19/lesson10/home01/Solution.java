package com.javarush.test.level19.lesson10.home01;

/* Считаем зарплаты
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Все данные вывести в консоль, предварительно отсортировав в возрастающем порядке по имени
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 2
Сидоров 6
Иванов 1.35
Петров 3.1

Пример вывода:
Иванов 1.35
Петров 5.1
Сидоров 6.0
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader bf = new BufferedReader(new FileReader(args[0]));
        TreeMap<String, Double> map = new TreeMap<>();
        while (bf.ready()){
            String[] arr = bf.readLine().split(" ");
            double d = Double.parseDouble(arr[1]);
            if (map.containsKey(arr[0])) {
                for (Map.Entry<String, Double> m : map.entrySet())
                {
                    if (m.getKey().equals(arr[0]))
                    {
                        map.put(arr[0], d + m.getValue());
                    }
                }
            } else {
                map.put(arr[0], d);
            }
        }
        for (Map.Entry<String, Double> m : map.entrySet()){
            System.out.println(m.getKey() + " " + m.getValue());
        }

        bf.close();
    }
}
