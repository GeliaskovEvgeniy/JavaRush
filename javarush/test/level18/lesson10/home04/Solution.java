package com.javarush.test.level18.lesson10.home04;

/* Объединение файлов
Считать с консоли 2 имени файла
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов
Закрыть потоки. Не использовать try-with-resources
*/


import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException
    {BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();

        FileInputStream fis1 = new FileInputStream(file1);
        FileInputStream fis2 = new FileInputStream(file2);

        byte[] buffer1 = new byte[fis1.available()];
        byte[] buffer2 = new byte[fis2.available()];

        fis1.read(buffer1);
        fis2.read(buffer2);

        FileOutputStream fos1 = new FileOutputStream(file1, false);
        fos1.write(buffer2);

        FileOutputStream fos2 = new FileOutputStream(file1, true);
        fos2.write(buffer1);

        reader.close();
        fis1.close();
        fis2.close();
        fos2.close();
        fos1.close();

    }
}
