package com.javarush.test.level18.lesson10.home06;

/* Встречаемость символов
Программа запускается с одним параметром - именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете). Пример: ','=44, 's'=115, 't'=116
Вывести на консоль отсортированный результат:
[символ1]  частота1
[символ2]  частота2
Закрыть потоки. Не использовать try-with-resources

Пример вывода:
, 19
- 7
f 361
*/

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        String file = args[0];
        Map<Integer, Integer> map = new TreeMap<>();
        InputStream inp = new BufferedInputStream(new FileInputStream(file));

        while (inp.available() > 0) {
            int i = inp.read();
            if (map.containsKey(i)){
                map.put(i, map.get(i) + 1);
            }else {
                map.put(i, 1);
            }
        }
        inp.close();
        for (Map.Entry<Integer, Integer> m : map.entrySet()) {
            int key = m.getKey();
            System.out.println((char)key + " " + m.getValue());
        }

    }
}
