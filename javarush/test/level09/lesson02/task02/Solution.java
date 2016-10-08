package com.javarush.test.level09.lesson02.task02;

/* И снова StackTrace
Написать пять методов, которые вызывают друг друга. Каждый метод должен возвращать имя метода, вызвавшего его, полученное с помощью StackTrace.
*/

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public  class Solution implements Runnable
{
    @Override
    public void run()
    {
        int i=1;
        try {
            while (true)
            {

                System.out.println("Diamon run " + i);
                Thread.sleep(1000);
                i++;
            }
        } catch (InterruptedException e) {
        }
    }

    public static void main(String[] args) throws Exception
    {

            Thread diamon = new Thread(new Solution());
            diamon.setDaemon(true);
            diamon.start();

        System.out.println("Begin!!!");
        Thread.sleep(10000);
    }


}
