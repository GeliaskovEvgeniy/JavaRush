package com.javarush.test.level14.lesson06.home01;

public class MoldovanHen extends Hen
{

    public  int getCountOfEggsPerMonth()
    {
        return 2900;
    }

    public  String getDescription() {
        return String.format(super.getDescription() + " Моя страна - %s. Я несу %s яиц в месяц.", Country.MOLDOVA, getCountOfEggsPerMonth());
    }
}

