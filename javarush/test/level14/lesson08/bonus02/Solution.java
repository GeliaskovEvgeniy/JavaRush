package com.javarush.test.level14.lesson08.bonus02;

/* НОД
Наибольший общий делитель (НОД).
Ввести с клавиатуры 2 целых положительных числа.
Вывести в консоль наибольший общий делитель.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());


        System.out.println(maxObgDel(a, b));

    }

    public static int maxObgDel(int a, int b) {
        int fin = 0;

        int max = 0;
        int min = 0;

        if (a > b) {
            max = a;
            min = b;
        }
        else {
            max = b;
            min = a;
        }
        int x = min;
        while (true)
        {

            if (max % x == 0 && min % x == 0) {
                fin = x;
                break;
            } else {
                x = x - 1;
            }

        }
        return fin;
    }
}
