package com.javarush.test.level18.lesson10.home07;

/* Поиск данных внутри файла
Считать с консоли имя файла
Найти в файле информацию, которая относится к заданному id, и вывести ее на экран в виде, в котором она записана в файле.
Программа запускается с одним параметром: id (int)
Закрыть потоки. Не использовать try-with-resources

В файле данные разделены пробелом и хранятся в следующей последовательности:
id productName price quantity

где id - int
productName - название товара, может содержать пробелы, String
price - цена, double
quantity - количество, int

Информация по каждому товару хранится в отдельной строке
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        Scanner scanner = new Scanner(System.in);
//        ArrayList<String> list = read(scanner.nextLine());
//        String s = args[0];
//        outConcol(list, s);

        BufferedReader in = new BufferedReader(new FileReader(scanner.nextLine()));
        ArrayList<String> list = new ArrayList<>();
        String s;
        while ((s = in.readLine()) != null){
//            list.add(s);
            if (s.startsWith(args[0]+" "))
            {
                System.out.println(s);
                in.close();
                break;
            }
        }
        scanner.close();
    }
/*
    public static ArrayList<String> read(String fileName) throws IOException
    {
        BufferedReader in = new BufferedReader(new FileReader(fileName));
        ArrayList<String> list = new ArrayList<>();
        String s;
        while ((s = in.readLine()) != null){
//            list.add(s);
            if (s.startsWith(args[0]+" "))
            {
                System.out.println(s);
                in.close();
                break;
            }
        }
        in.close();
        return list;
    }

    public static void outConcol(ArrayList<String> list, String id){
        for (String s : list){
            String[] arr = s.split(" ");
            if (arr[0].equals(id)){
                System.out.println(arr[0] + " " + arr[1] + " " + arr[2] + " "+ arr[3]);
            }
        }
    }*/
}
