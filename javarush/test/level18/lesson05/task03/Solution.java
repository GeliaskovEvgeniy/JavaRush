package com.javarush.test.level18.lesson05.task03;

/* Разделение файла
Считать с консоли три имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:
Первую половину байт записать в файл2, вторую половину байт записать в файл3.
Если в файл1 количество байт нечетное, то файл2 должен содержать бОльшую часть.
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

        String file3 = scanner.nextLine();

        scanner.close();

        FileInputStream inputStream = new FileInputStream(file1);

        FileOutputStream outputStream = new FileOutputStream(file2);

        FileOutputStream outputStream1 = new FileOutputStream(file3);



        byte[] buff = new byte[inputStream.available()];

        for (int i = 0; inputStream.available() > 0; i++) {
            buff[i] = (byte) inputStream.read();
        }

        byte[] f1;
        byte[] f2;

        if (buff.length%2 == 0) {

            f1 = new byte[buff.length/2];
            f2 = new byte[buff.length/2];

            for (int i = 0, j =0; i < buff.length; i++) {
                if (i < f1.length)
                    f1[i] = buff[i];
                else
                    f2[j] = buff[i];
            }
        } else {

            f1 = new byte[(buff.length/2)+1];
            f2 = new byte[buff.length/2];

            for (int i = 0, j = 0; i < buff.length; i++)
            {
                if (i < (f1.length))
                    f1[i] = buff[i];
                else
                {
                    f2[j] = buff[i];
                }
            }
        }

        outputStream.write(f1);
        outputStream1.write(f2);

        inputStream.close();
        outputStream.close();
        outputStream1.close();
    }

}
