package com.javarush.test.level13.lesson11.home03;

/* Чтение файла
1. Считать с консоли имя файла.
2. Вывести в консоль(на экран) содержимое файла.
3. Не забыть освободить ресурсы. Закрыть поток чтения с файла и поток ввода с клавиатуры.
*/

import com.sun.corba.se.spi.orbutil.fsm.Input;

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        //add your code here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try
        {
            InputStream isStrim = new FileInputStream(reader.readLine());

            while (isStrim.available() > 0)
            {
                System.out.print((char) isStrim.read());
            }
            isStrim.close();
            reader.close();
        }
        catch (Exception e) {
            System.out.println("No file");
        }
    }

}