package com.javarush.test.level14.lesson08.home01;

/**
 * Created by 1 on 19.01.2016.
 */
public class WaterBridge implements Bridge
{
    private static int HARD_HARD = 18;

    @Override
    public int getCarsCount()
    {
        return HARD_HARD;
    }
}
