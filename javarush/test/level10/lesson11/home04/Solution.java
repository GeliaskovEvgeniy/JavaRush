package com.javarush.test.level10.lesson11.home04;

/* Большая зарплата
Вывести на экран надпись «Я не хочу изучать Java, я хочу большую зарплату» 40 раз по образцу.
Образец:
Я не хочу изучать Java, я хочу большую зарплату
 не хочу изучать Java, я хочу большую зарплату
не хочу изучать Java, я хочу большую зарплату
е хочу изучать Java, я хочу большую зарплату
 хочу изучать Java, я хочу большую зарплату
хочу изучать Java, я хочу большую зарплату
…
*/


import java.util.ArrayList;
import java.util.List;

public class Solution
{
    public static void main(String[] args)
    {
        String s = "Я не хочу изучать Java, я хочу большую зарплату";

        //напишите тут ваш код
        StringBuilder str = new StringBuilder(s);

        List<Character> ch = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            ch.add(str.charAt(i));
        }

        for (int i = 0; i < 40; i++) {


            for (Character c : ch) {
                System.out.print(c);
            }
            System.out.println();
            ch.remove(0);
        }
    }

}
