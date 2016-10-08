package com.javarush.test.level18.lesson05.task04;

/* Реверс файла
Считать с консоли 2 имени файла: файл1, файл2.
Записать в файл2 все байты из файл1, но в обратном порядке
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        Scanner scanner = new Scanner(System.in);

        String file1 = scanner.nextLine();
        String file2 = scanner.nextLine();

        FileInputStream inputStream = new FileInputStream(file1);

        byte[] bytes = new byte[inputStream.available()];

        inputStream.read(bytes, 0, inputStream.available());

        byte[] bytes1 = new byte[bytes.length];

        for (int i = bytes.length-1, j = 0; i >= 0; i--, j++) {
            byte a = bytes[i];
            bytes1[j] = a;
        }

        FileOutputStream outputStream = new FileOutputStream(file2);

        outputStream.write(bytes1);

        scanner.close();
        inputStream.close();
        outputStream.close();
    }
}
