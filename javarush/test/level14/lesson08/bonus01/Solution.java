package com.javarush.test.level14.lesson08.bonus01;

import java.io.FileInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* Нашествие эксепшенов
Заполни массив exceptions 10 различными эксепшенами.
Первое исключение уже реализовано в методе initExceptions.
*/

public class Solution
{
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args)
    {
        initExceptions();

        for (Exception exception : exceptions)
        {
            System.out.println(exception);
        }
    }

    private static void initExceptions()
    {   //it's first exception
        try
        {
            float i = 1 / 0;

        } catch (Exception e)
        {
            exceptions.add(e);
        }

        //Add your code here
        try
        {
            ArrayList<String> a = new ArrayList<String>();
            ArrayList<Integer> b = new ArrayList<Integer>();
            b.contains(a.get(0));
        } catch (Exception e)
        {
            exceptions.add(e);
        }

        try
        {
            InputStream inputStream = new FileInputStream("asdfsdg");
        } catch (Exception e)
        {
            exceptions.add(e);
        }

        try
        {
            int[] a = {1, 2, 3};
            for (int i =0;i<a.length;i--) {
                a[i] = 1;
            }
        } catch (Exception e)
        {
            exceptions.add(e);
        }

        try
        {
            Object object = null;
            if (object instanceof Float) {
                Float a = (Float) object;
                System.out.println("Is float value defined? "  + a.isNaN());
            } else if (object instanceof Double) {
                Double a = (Double) object;
                System.out.println("Is double value infinite? " +  a.isInfinite());
            }
        } catch (Exception e)
        {
            exceptions.add(e);
        }

        try
        {
            String test = "test";
            int test2 = Integer.parseInt(test);
        } catch (Exception e)
        {
            exceptions.add(e);
        }

        try
        {
            String test = "test";
            char test2 = test.charAt(100);
        } catch (Exception e)
        {
            exceptions.add(e);
        }

        try
        {
            Object i = new Integer(0);
            System.out.print((String) i);
        } catch (Exception e)
        {
            exceptions.add(e);
        }

        try
        {
            Solution test = new Solution();
            test.clone();
        } catch (Exception e)
        {
            exceptions.add(e);
        }

        try
        {
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
            Date lowDate = sdf.parse("test");
        } catch (Exception e)
        {
            exceptions.add(e);
        }

        try
        {
            throw new NullPointerException("Кота не существует");
        } catch (Exception e)
        {
            exceptions.add(e);
        }
    }
}
