package com.javarush.test.level15.lesson12.home04;

/**
 * Created by 1 on 28.01.2016.
 */
public class Moon implements Planet
{
    private static Moon ourInstance = new Moon();

    public static Moon getInstance()
    {
        return ourInstance;
    }

    private Moon()
    {
    }
}
