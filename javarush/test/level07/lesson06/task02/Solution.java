package com.javarush.test.level07.lesson06.task02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* Самая длинная строка
1. Создай список строк.
2. Считай с клавиатуры 5 строк и добавь в список.
3. Используя цикл, найди самую длинную строку в списке.
4. Выведи найденную строку на экран.
5. Если таких строк несколько, выведи каждую с новой строки.
*/
public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        List<String> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            String s = scanner.nextLine();
            list.add(s);
        }
        List<String> list1 = new ArrayList<>();
        String s = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (s.length() < list.get(i).length()) {
                s = list.get(i);
            }
        }
        for (String s1 : list) {
            if (s.length() == s1.length()) {
                list1.add(s1);
            }
        }
        for (String a : list1) {
            System.out.println(a);
        }

    }
}
