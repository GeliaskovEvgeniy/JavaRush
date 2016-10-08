package com.javarush.test.level14.lesson08.home10;

/**
 * Created by 1 on 20.01.2016.
 */
public class Singleton
{
    private static class SingletonHolder
    {
        private static Singleton instance = new Singleton();
    }
    private Singleton()
    {

    }



    public static Singleton getInstance() {

        return SingletonHolder.instance;
    }

}
