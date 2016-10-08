package com.javarush.test.level07.lesson06.task03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* Самая короткая строка
1. Создай список строк.
2. Считай с клавиатуры 5 строк и добавь в список.
3. Используя цикл, найди самую короткую строку в списке.
4. Выведи найденную строку на экран.
5. Если таких строк несколько, выведи каждую с новой строки.
*/
public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        Scanner scanner = new Scanner(System.in);
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            String s = scanner.nextLine();
            list.add(s);
        }
        scanner.close();
        List<String> list1 = new ArrayList<>();
        String s = list.get(0);
        for (String a : list) {
            if (s.length() > a.length()) {
                s = a;
            }
        }
        for (String a : list) {
            if (s.length() == a.length()) {
                list1.add(a);
            }
        }
        for (String a : list1) {
            System.out.println(a);
        }
    }
}
