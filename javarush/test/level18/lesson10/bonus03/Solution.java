package com.javarush.test.level18.lesson10.bonus03;

/* Прайсы 2
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается с одним из следующих наборов параметров:
-u id productName price quantity
-d id
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-u  - обновляет данные товара с заданным id
-d  - производит физическое удаление товара с заданным id (все данные, которые относятся к переданному id)

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();
        scanner.close();
//        int id = read(fileName);
//        String s = id + "";
        if (args[0].equals("-u"))
        {
            String s = create(args[1], 8);
            s += create(args[2], 30);
            s += create(args[3], 8);
            s += create(args[4], 4);
            update(fileName, s, Integer.parseInt(args[1]));
        } else if (args[0].equals("-d")){
            delete(fileName, Integer.parseInt(args[1]));
        }


    }

    public static void update(String file, String s, int id) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        ArrayList<String> list = new ArrayList<>();
        while (reader.ready()){
            list.add(reader.readLine());
        }
        for (int i = 0; i < list.size(); i++){
            int in = 0;
            try {
                in = Integer.parseInt(list.get(i).substring(0, 8).trim());
            } catch (Exception e){
            } finally
            {
                if (in == id){
                    list.set(i, s);
                }
            }
        }
        reader.close();
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        for (String s1 : list){
            writer.write(s1 + "\n");
            writer.flush();
        }
        writer.close();
    }

    public static void delete(String file, int id) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        ArrayList<String> list = new ArrayList<>();
        while (reader.ready()){
            list.add(reader.readLine());
        }
        if (contain(list, id))
        {
            Iterator<String> iterator = list.iterator();
            while (iterator.hasNext())
            {
                String s = iterator.next();
                int a = 0;
                try
                {
                    a = Integer.parseInt(s.substring(0, 8).trim());
                }
                catch (Exception e)
                {
                }
                finally
                {
                    if (a == id)
                    {
                        iterator.remove();
                    }
                }
            }
            reader.close();

            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            for (String s : list)
            {
                writer.write(s + "\n");
                writer.flush();
            }
            writer.close();
        }
    }

    public static boolean contain(ArrayList<String> list, int id){
        for (String s : list){
            int i = 0;
            try {
                i = Integer.parseInt(s.substring(0, 8).trim());
            }catch (Exception e){

            }finally
            {
                if (i == id)
                    return true;
            }
        }
        return false;
    }

    public static String create(String s , int length) {
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        int a = length - s.length();
        for (int i = 0; i < a; i++){
            sb.append(" ");
        }
        return sb.toString();
    }
//
//    public static int read(String file) throws IOException
//    {
//        BufferedReader reader = new BufferedReader(new FileReader(file));
//        TreeSet<Integer> set = new TreeSet<>();
//        while (reader.ready()){
//            String s = reader.readLine();
//            int s1 = 0;
//            try{
//                s1 = Integer.parseInt(s.substring(0, 8).trim());
//            }catch (Exception e){
//            }finally {
//                set.add(s1);
//            }
//
//        }
//        reader.close();
//        return set.last() + 1;
//    }
}
