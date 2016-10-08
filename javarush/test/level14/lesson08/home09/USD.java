package com.javarush.test.level14.lesson08.home09;

/**
 * Created by 1 on 20.01.2016.
 */
public class USD extends Money
{
    public USD(double amount)
    {
        super(amount);
    }

    @Override
    public String getCurrencyName()
    {
        return "USD";
    }
}
