package com.javarush.test.level14.lesson06.home01;



public class BelarusianHen extends Hen
{
    @Override
    public int getCountOfEggsPerMonth()
    {
        return 120;
    }

    public  String getDescription() {
        return String.format(super.getDescription() + " Моя страна - %s. Я несу %s яиц в месяц.", Country.BELARUS, getCountOfEggsPerMonth());
    }
}

