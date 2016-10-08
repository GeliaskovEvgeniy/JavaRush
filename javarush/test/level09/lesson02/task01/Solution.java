package com.javarush.test.level09.lesson02.task01;

/* Каждый метод должен возвращать свой StackTrace
Написать пять методов, которые вызывают друг друга. Каждый метод должен возвращать свой StackTrace.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        long k = 1000 / (long) 2.5;
        System.out.println(k);
        k =(long) (1000 / 2.5);
        System.out.println(k);

    }

    public static StackTraceElement[] method1()
    {
        method2();
        //напишите тут ваш код
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        return stackTraceElements;
    }

    public static StackTraceElement[] method2()
    {
        method3();
        //напишите тут ваш код
        StackTraceElement[] stackTraceElements1 = Thread.currentThread().getStackTrace();
        return stackTraceElements1;
    }

    public static StackTraceElement[] method3()
    {
        method4();
        //напишите тут ваш код
        StackTraceElement[] stackTraceElements2 = Thread.currentThread().getStackTrace();
        return stackTraceElements2;
    }

    public static StackTraceElement[] method4()
    {
        method5();
        //напишите тут ваш код
        StackTraceElement[] stackTraceElements3 =Thread.currentThread().getStackTrace();
        return stackTraceElements3;
    }

    public static StackTraceElement[] method5()
    {
        //напишите тут ваш код
        StackTraceElement[] stackTraceElement4 = Thread.currentThread().getStackTrace();
        return stackTraceElement4;
    }
}
