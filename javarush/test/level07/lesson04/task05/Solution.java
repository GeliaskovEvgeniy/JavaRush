package com.javarush.test.level07.lesson04.task05;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Один большой массив и два маленьких
1. Создать массив на 20 чисел.
2. Ввести в него значения с клавиатуры.
3. Создать два массива на 10 чисел каждый.
4. Скопировать большой массив в два маленьких: половину чисел в первый маленький, вторую половину во второй маленький.
5. Вывести второй маленький массив на экран, каждое значение выводить с новой строки.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        int[] listBig = new int[20];
        int[] listSmolOne = new int[10];
        int[] listSmolToo = new int[10];

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < listBig.length; i++) {
            listBig[i] = Integer.parseInt(reader.readLine());
        }

        for (int i = 0, j = 10; i < 10; i++, j++) {
            listSmolOne[i] = listBig[i];
            listSmolToo[i] = listBig[j];
        }

        for (int i=0;i<10;i++) {
            System.out.println(listSmolToo[i]);
        }

    }
}
