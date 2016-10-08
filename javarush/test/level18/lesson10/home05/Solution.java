package com.javarush.test.level18.lesson10.home05;

/* Округление чисел
Считать с консоли 2 имени файла
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415
Округлить числа до целых и записать через пробел во второй файл
Закрыть потоки. Не использовать try-with-resources
Принцип округления:
3.49 - 3
3.50 - 4
3.51 - 4
-3.49 - -3
-3.50 - -3
-3.51 - -4
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException
    {

        Scanner scanner = new Scanner(System.in);
        String file1 = scanner.nextLine();
        String file2 = scanner.nextLine();
        scanner.close();
        Scanner ss = new Scanner(new FileReader(file1));
        FileWriter writer = new FileWriter(file2);
        StringBuilder builder = new StringBuilder();

        while (ss.hasNextDouble()) {
            double d = ss.nextDouble();
            int i = (int) Math.round(d);
            writer.append(i + " ");
        }
        writer.flush();
        writer.close();
        ss.close();
    }
}
