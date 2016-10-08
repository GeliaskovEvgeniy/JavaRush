package com.javarush.test.level13.lesson11.bonus01;

/* Сортировка четных чисел из файла
1. Ввести имя файла с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.
Пример ввода:
5
8
11
3
2
10
Пример вывода:
2
8
10
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        // напишите тут ваш код
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();
        scanner.close();
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        ArrayList<Integer> list = new ArrayList<>();
        while (reader.ready()){
            list.add(Integer.parseInt(reader.readLine()));
        }
        reader.close();

        for (int i = 0; i < list.size();){
            if (list.get(i)%2 != 0)
                list.remove(i);
            else
                i++;
        }



        int[] a = new int[list.size()];
        for (int i = 0; i < a.length; i++){
            a[i] = list.get(i);
        }

        Arrays.sort(a);

        for (int i : a){
            System.out.println(i);
        }

    }
}
