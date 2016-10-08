package com.javarush.test.level03.lesson12.home03;

import java.io.*;

public class Solution
{
    public static void main(String[] args)
    {
        closeToTen(8,11);
        closeToTen(14,7);
    }

    public static void closeToTen(int a, int b)
    {
        //::CODE:
        int x = Solution.abs(10-a);
        int y = Solution.abs(10-b);

        if (x < y) {
            System.out.println(a);
        } else {
            System.out.println(b);
        }

    }

    public static int abs(int a)
    {
        if (a < 0) {
            return -a;
        } else {
            return a;
        }
    }
}