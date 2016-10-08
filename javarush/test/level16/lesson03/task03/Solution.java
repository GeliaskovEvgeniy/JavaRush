package com.javarush.test.level16.lesson03.task03;

import java.util.ArrayList;
import java.util.List;

/* Список и нити
В методе main добавить в статический объект list 5 нитей SpecialThread - различных объектов.
*/

public class Solution {
    public static volatile List<Thread> list = new ArrayList<Thread>(5);

    public static void main(String[] args) {
        //Add your code here - добавьте свой код тут
        SpecialThread specialThread = new SpecialThread();
        Thread thread = new Thread(specialThread);
        list.add(thread);

        SpecialThread specialThread1 = new SpecialThread();
        list.add(new Thread(specialThread1));

        SpecialThread specialThread2 = new SpecialThread();
        list.add(new Thread(specialThread2));

        SpecialThread specialThread3 = new SpecialThread();
        list.add(new Thread(specialThread3));

        SpecialThread specialThread4 = new SpecialThread();
        list.add(new Thread(specialThread4));

        for (Thread c : list) {
            c.start();
        }
    }

    public static class SpecialThread implements Runnable {
        public void run() {
            System.out.println("it's run method inside SpecialThread");
        }
    }
}
