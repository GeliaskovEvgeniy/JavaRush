package com.javarush.test.level08.lesson08.task01;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/* 20 слов на букву «Л»
Создать множество строк (Set<String>), занести в него 20 слов на букву «Л».
*/

public class Solution
{
    public static HashSet<String> createSet()
    {
        //напишите тут ваш код
        Set<String> set = new HashSet<>();

        set.add("лес");
        set.add("лоза");
        set.add("лор");
        set.add("лир");
        set.add("лошадь");
        set.add("лодка");
        set.add("лик");
        set.add("лом");
        set.add("лаз");
        set.add("лама");
        set.add("луна");
        set.add("лужа");
        set.add("ложка");
        set.add("лето");
        set.add("лен");
        set.add("лора");
        set.add("лера");
        set.add("листок");
        set.add("лимо");
        set.add("Лиса");
        return (HashSet<String>) set;

    }
}
