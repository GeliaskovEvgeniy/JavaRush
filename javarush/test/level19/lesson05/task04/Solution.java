package com.javarush.test.level19.lesson05.task04;

/* Замена знаков
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Заменить все точки "." на знак "!", вывести во второй файл.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        Scanner scanner = new Scanner(System.in);
        BufferedReader reader = new BufferedReader(new FileReader(scanner.nextLine()));
        BufferedWriter writer = new BufferedWriter(new FileWriter(scanner.nextLine()));
        String s = reader.readLine();
        String a = s.replace('.', '!');
        writer.write(a);
        writer.flush();
        scanner.close();
        reader.close();
        writer.close();
    }
}
