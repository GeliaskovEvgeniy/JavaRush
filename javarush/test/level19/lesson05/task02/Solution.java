package com.javarush.test.level19.lesson05.task02;

/* Считаем слово
Считать с консоли имя файла.
Файл содержит слова, разделенные знаками препинания.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        Scanner scanner = new Scanner(System.in);
        BufferedReader reader = new BufferedReader(new FileReader(scanner.nextLine()));
        String s = "";
        while (reader.ready()){
            s += reader.readLine();
        }
        String s1 = s.toLowerCase();
        String[] arr = s1.split("world");
        System.out.println(arr.length - 1);
        scanner.close();
        reader.close();
    }
}
