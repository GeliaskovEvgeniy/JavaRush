package com.javarush.test.level19.lesson05.task03;

/* Выделяем числа
Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки. Не использовать try-with-resources

Пример тела файла:
12 text var2 14 8v 1

Результат:
12 14 1
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        Scanner sc1 = new Scanner(System.in);
        BufferedReader scanner = new BufferedReader(new FileReader(sc1.nextLine()));
        BufferedWriter writer = new BufferedWriter(new FileWriter(sc1.nextLine()));
        sc1.close();

            String i = scanner.readLine();
            String[] str = i.split(" ");
            for (String s : str)
            {
                try

                {
                    int a = Integer.parseInt(s);
                    String q = String.valueOf(a);
                    writer.write(q);
                    writer.append(" ");
                    writer.flush();
                }
                catch (Exception e)
                {
                }
            }

        scanner.close();
        writer.close();

    }
}
