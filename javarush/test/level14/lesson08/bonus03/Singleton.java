package com.javarush.test.level14.lesson08.bonus03;

public class Singleton
{
    private static Singleton _instans = null;

    private Singleton(){}

    public static  Singleton getInstance()
    {
        if (_instans == null)
            _instans = new Singleton();
        return _instans;
    }
}
