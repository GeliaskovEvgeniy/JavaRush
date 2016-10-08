package com.javarush.test.level04.lesson06.task02;

/* Максимум четырех чисел
Ввести с клавиатуры четыре числа, и вывести максимальное из них.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        int c = Integer.parseInt(reader.readLine());
        int d = Integer.parseInt(reader.readLine());

        int m = max(c, d);

        if ((a > b) && (a > m)) {
            System.out.println(a);
        } else if (b > a && b > m) {
            System.out.println(b);
        } else {
            System.out.println(m);
        }

    }

    public static int max(int a, int b) {
        int m = 0;
        if (a > b) {
            m = a;
        } else {
            m = b;
        }
        return m;
    }
}
