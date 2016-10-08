package com.javarush.test.level18.lesson10.bonus02;

/* Прайсы
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается со следующим набором параметров:
-c productName price quantity
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-c  - добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно, инкрементируя максимальный id, найденный в файле

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;
import java.util.Scanner;
import java.util.TreeSet;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();
        scanner.close();
        int id = read(fileName);
        String s = id + "";
        if (args[0].equals("-c"))
        {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
            writer.write("\n");
            writer.close();

            create(fileName, s, 8);
            create(fileName, args[1], 30);
            create(fileName, args[2], 8);
            create(fileName, args[3], 4);
        }


    }

    public static void create(String fileName, String s , int length) throws IOException
    {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
        writer.write(s);
        int a = length - s.length();
        for (int i = 0; i < a; i++){
            writer.write(" ");
        }
        writer.close();
    }

    public static int read(String file) throws IOException
    {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        TreeSet<Integer> set = new TreeSet<>();
        while (reader.ready()){
            String s = reader.readLine();
            int s1 = 0;
            try{
                s1 = Integer.parseInt(s.substring(0, 8).trim());
            }catch (Exception e){
            }finally {
                set.add(s1);
            }

        }
        reader.close();
        return set.last() + 1;
    }
}
