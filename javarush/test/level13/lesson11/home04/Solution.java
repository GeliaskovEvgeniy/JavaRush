package com.javarush.test.level13.lesson11.home04;

/* Запись в файл
1. Прочесть с консоли имя файла.
2. Считывать строки с консоли, пока пользователь не введет строку "exit".
3. Вывести абсолютно все введенные строки в файл, каждую строчку с новой стороки.
*/


import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();

        ArrayList<String> list =new ArrayList<>();
        while (true){
            String s = scanner.nextLine();
            list.add(s);
            if (s.equals("exit"))
                break;

        }
        scanner.close();

        FileWriter writer = new FileWriter(fileName);
        while (list.size() > 0){
            String s = list.get(0);
            writer.append(s);
            writer.append('\n');
            list.remove(0);
        }
        writer.flush();
        writer.close();
    }
}
