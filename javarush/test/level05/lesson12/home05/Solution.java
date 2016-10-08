package com.javarush.test.level05.lesson12.home05;

/* Вводить с клавиатуры числа и считать их сумму
Вводить с клавиатуры числа и считать их сумму, пока пользователь не введёт слово «сумма». Вывести на экран полученную сумму.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;
        while (true) {

            String text = reader.readLine();


            if (text.equals("сумма")) {

                break;
            } else {
                int a = Integer.parseInt(text);
                sum += a;
            }
        }
        System.out.println(sum);
    }
}
