package com.javarush.test.level15.lesson12.home04;

/**
 * Created by 1 on 28.01.2016.
 */
public class Sun implements Planet
{
    private static Sun ourInstance = new Sun();

    public static Sun getInstance()
    {
        return ourInstance;
    }

    private Sun()
    {
    }
}
