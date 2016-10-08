package com.javarush.test.level25.lesson09.task03;

import java.util.ArrayList;
import java.util.List;

/* Живем своим умом
В классе Solution реализуйте интерфейс UncaughtExceptionHandler, который должен:
1. прервать нить, которая бросила исключение.
2. вывести в консоль стек исключений начиная с самого вложенного.
Пример исключения: new Exception("ABC", new RuntimeException("DEF", new IllegalAccessException("GHI")))
Пример вывода:
java.lang.IllegalAccessException: GHI
java.lang.RuntimeException: DEF
java.lang.Exception: ABC
*/
public class Solution implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        if (t != null)
        {
            t.interrupt();
            List<String> list = new ArrayList<>();
            while (e != null)
            {
                list.add(e.getClass().getName() + ": " + e.getMessage());
                e = e.getCause();
            }
            for (int i = list.size()-1; i >= 0; i--){
                System.out.println(list.get(i));
            }
        }
    }

    public static void main(String[] args)
    {
        Solution solution = new Solution();
        Thread thread = new Thread(){
            public void run(){
                try{
                    throw new Exception("ABC", new RuntimeException("DEF", new IllegalAccessException("GHI")));
                }catch (Exception e){
                    getUncaughtExceptionHandler().uncaughtException(currentThread(), e);
                }
            }
        };
        thread.setUncaughtExceptionHandler(solution);
        thread.start();
    }
}
