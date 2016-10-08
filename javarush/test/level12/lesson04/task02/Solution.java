package com.javarush.test.level12.lesson04.task02;

/* print(int) и print(Integer)
Написать два метода: print(int) и print(Integer).
Написать такой код в методе main, чтобы вызвались они оба.
*/

public class Solution
{
    public static void main(String[] args)
    {
        print(1);
    }

    //Напишите тут ваши методы
    public static int print(int a) {
        return a;
    }

    public static Integer print(Integer a) {
        return a;
    }
}
