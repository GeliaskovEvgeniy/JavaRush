package com.javarush.test.level19.lesson10.home05;

/* Слова с цифрами
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит строки со слов, разделенные пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        Writer writer = new BufferedWriter(new FileWriter(args[1]));
        while (reader.ready()) {
            String[] result = reader.readLine().split(" ");
            for (String s : result) {
                if (s.matches("^\\D*$")) {
                    continue;
                } else {
                    writer.write(s);
                    writer.append(" ");
                }
            }
        }
        writer.close();
        reader.close();
    }
}
