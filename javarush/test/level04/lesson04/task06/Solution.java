package com.javarush.test.level04.lesson04.task06;

/* День недели
Ввести с клавиатуры номер дня недели, в зависимости от номера вывести название «понедельник», «вторник», «среда», «четверг», «пятница», «суббота», «воскресенье»,
если введен номер больше или меньше 7 – вывести «такого дня недели не существует».
Пример для номера 5:
пятница
Пример для номера 10:
такого дня недели не существует
*/

import java.io.*;
import java.util.HashMap;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int chislo = Integer.parseInt(reader.readLine());

        if (chislo == 1) {
            System.out.println("понедельник");
        } else if (chislo == 2) {
            System.out.println("вторник");
        } else if (chislo == 3) {
            System.out.println("среда");
        } else if (chislo == 4) {
            System.out.println("четверг");
        } else if (chislo == 5) {
            System.out.println("пятница");
        } else if (chislo == 6) {
            System.out.println("субота");
        } else if (chislo == 7) {
            System.out.println("воскресенье");
        } else {
            System.out.println("такого дня недели не существует");
        }

    }

}