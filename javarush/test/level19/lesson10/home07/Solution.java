package com.javarush.test.level19.lesson10.home07;

/* Длинные слова
В метод main первым параметром приходит имя файла1, вторым - файла2
Файл1 содержит слова, разделенные пробелом.
Записать через запятую в Файл2 слова, длина которых строго больше 6
Закрыть потоки. Не использовать try-with-resources

Пример выходных данных:
длинное,короткое,аббревиатура
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        Writer writern = new BufferedWriter(new FileWriter(args[1]));
        ArrayList<String> result = new ArrayList<>();
        while (reader.ready()) {
            String[] s = (reader.readLine().split(" "));
            for (String s1 : s) {
                result.add(s1);
            }

        }
        String str = "";
        for (String s : result) {
            if (s.length() > 6)
                str += s + " ";
        }
        String fin = str.trim().replaceAll(" ", ",");
        writern.write(fin);

        writern.close();
        reader.close();
    }
}
