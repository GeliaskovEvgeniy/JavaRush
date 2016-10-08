package com.javarush.test.level18.lesson10.home10;

/* Собираем файл
Собираем файл из кусочков
Считывать с консоли имена файлов
Каждый файл имеет имя: [someName].partN. Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.
Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end"
В папке, где находятся все прочтенные файлы, создать файл без приставки [.partN]. Например, Lion.avi
В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        Scanner scanner = new Scanner(System.in);
        TreeSet<String> listFileName = new TreeSet<>();
        String s;
        while (!((s = scanner.nextLine()).equals("end"))){
            listFileName.add(s);
        }
        scanner.close();

        packaging(listFileName);
    }

    public static void packaging(TreeSet<String> list) throws IOException
    {
        String s = list.first();
        String s1 = s.substring(0, s.indexOf(".part"));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(s1));
        int count = 0;
        for (String fileName : list)
        {
            BufferedInputStream bais = new BufferedInputStream(new FileInputStream(fileName));
            byte[] arr = new byte[bais.available()];
            while (bais.available() > 0) {
                count = bais.read(arr);
                bos.write(arr, 0, count);
            }
            bos.flush();
            bais.close();
        }
        bos.close();
    }
}
