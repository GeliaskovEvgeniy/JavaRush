package com.javarush.test.level05.lesson12.bonus03;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* Задача по алгоритмам
Написать программу, которая:
1. вводит с консоли число N > 0
2. потом вводит N чисел с консоли
3. выводит на экран максимальное из введенных N чисел.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int maximum = 0;

        //напишите тут ваш код
        List<Integer> list = new ArrayList<>();
        int N = Integer.parseInt(reader.readLine());
        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(reader.readLine()));
        }
        maximum = list.get(0);
        for (Integer i : list) {
            if (maximum < i) {
                maximum = i;
            }
        }
        System.out.println(maximum);
    }
}
