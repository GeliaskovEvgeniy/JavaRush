package com.javarush.test.level10.lesson11.home08;

import java.util.ArrayList;

/* Массив списков строк
Создать массив, элементами которого будут списки строк. Заполнить массив любыми данными и вывести их на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        ArrayList<String>[] arrayOfStringList =  createList();
        printList(arrayOfStringList);
    }

    public static ArrayList<String>[] createList()
    {
        //напишите тут ваш код
        ArrayList<String>[] list = new ArrayList[3];
        ArrayList<String> a = new ArrayList<>();
        a.add("a"); a.add("s"); a.add("d");
        list[0]=a;
        ArrayList<String> b = new ArrayList<>();
        b.add("q"); b.add("w"); b.add("e");
        list[1]=b;
        ArrayList<String> c = new ArrayList<>();
        c.add("z"); c.add("x"); c.add("c");
        list[2]=c;

        return list;
    }

    public static void printList(ArrayList<String>[] arrayOfStringList)
    {
        for (ArrayList<String> list: arrayOfStringList)
        {
            for (String s : list)
            {
                System.out.println(s);
            }
        }
    }
}