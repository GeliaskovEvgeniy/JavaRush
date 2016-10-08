package com.javarush.test.level18.lesson10.home03;

/* Два в одном
Считать с консоли 3 имени файла
Записать в первый файл содержимого второго файла, а потом дописать в первый файл содержимое третьего файла
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException
    {

        Scanner scanner = new Scanner(System.in);
        String file1 = scanner.nextLine();
        String file2 = scanner.nextLine();
        String file3 = scanner.nextLine();
        scanner.close();

        InputStream inputStream = new FileInputStream(file2);
        InputStream inputStream1 = new FileInputStream(file3);

        OutputStream outputStream = new FileOutputStream(file1);

        byte[] b1 = new byte[inputStream.available()];
        byte[] b2 = new byte[inputStream1.available()];

        outputStream.write(b1, 0, inputStream.read(b1));
        outputStream.write(b2, inputStream.available(), inputStream1.read(b2));

        inputStream.close();
        inputStream1.close();
        outputStream.close();

    }
}
