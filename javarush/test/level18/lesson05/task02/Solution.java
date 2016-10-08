package com.javarush.test.level18.lesson05.task02;

/* Подсчет запятых
С консоли считать имя файла
Посчитать в файле количество символов ',', количество вывести на консоль
Закрыть потоки. Не использовать try-with-resources

Подсказка: нужно сравнивать с ascii-кодом символа ','
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException
    {

        ArrayList<String> list = read();

        int caunt = 0;
        for (String s : list) {
            caunt += parset(s);
        }

        System.out.println(caunt);

    }

    static ArrayList read() throws IOException {
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        ArrayList<String> list = new ArrayList<>();

        while (reader.read() != -1) {
            list.add(reader.readLine());
        }
        scanner.close();
        reader.close();
        return list;
    }

    static int parset(String str) {
        char[] chars = str.toCharArray();
        int caunt = 0;
        for (Character c : chars) {
            if (c == ',')
                caunt++;
        }
        return caunt;
    }

}
