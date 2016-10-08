package com.javarush.test.level20.lesson10.bonus01;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* Алгоритмы-числа
Число S состоит из M чисел, например, S=370 и M(количество цифр)=3
Реализовать логику метода getNumbers, который должен среди натуральных чисел меньше N (long)
находить все числа, удовлетворяющие следующему критерию:
число S равно сумме его цифр, возведенных в M степень
getNumbers должен возвращать все такие числа в порядке возрастания

Пример искомого числа:
370 = 3*3*3 + 7*7*7 + 0*0*0
8208 = 8*8*8*8 + 2*2*2*2 + 0*0*0*0 + 8*8*8*8

На выполнение дается 10 секунд и 50 МБ памяти.
*/
public class Solution {

    public static void main(String[] args) {

        Date data = new Date();
        int[] i = getNumbers(99999999);
        for (int a : i) {
            System.out.print(a + " ");
        }
        System.out.println();
        Date date2 = new Date();
        long s = date2.getTime() - data.getTime();
        System.out.println(s);
    }

    public static int[] getNumbers(int N)
    {
        int[] result = null;

        List<Integer> list = new ArrayList<>();

        for (int i = 1; i < N; i++) {
            int degree = getDegree(i);
            int input = i;
            int sum = 0;
            int k;

            do {
                k = input % 10;
                sum += sqrt(k, degree);
            } while ( (input /= 10) > 0);

            if (sum == i) {
                list.add(i);
            }
        }
        result = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;
    }

    public static int getDegree(int i) {
        int degree = 0;

        do {
            degree += 1;
        } while ( (i /= 10) > 0);

        return degree;

//        List<Integer> list = new ArrayList<>();
//        for (int i1 = 1, i2 = 0; i1 <= N; i2++, i1++)
//        {
//            String s = i1 + "";
//            char[] c = s.toCharArray();
//            int[] resul = new int[c.length];
//
//            for (int a = 0; a < c.length; a++) {
//                int j = Integer.parseInt(String.valueOf(c[a]));
//                int i =  sqrt(j, c.length);
//                resul[a] = i;
//            }
//
//            int d = resul[0];
//            for (int i = 1; i < resul.length; i++) {
//                d += resul[i];
//            }
//            if (d==i1)
//                list.add(d);
//        }
//        int[] result = new int[list.size()];
//        for (int i = 0; i < list.size(); i++) {
//            result[i] = list.get(i);
//        }
//
//        return result;
    }

    public static int sqrt(int i, int j) {
        int r = 1;
        for (int i1 = 0; i1 < j; i1++) {
            r = r*i;
        }

        return r;
    }
}
