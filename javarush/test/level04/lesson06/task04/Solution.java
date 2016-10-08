package com.javarush.test.level04.lesson06.task04;

/* Сравнить имена
Ввести с клавиатуры два имени, и если имена одинаковые вывести сообщение «Имена идентичны». Если имена разные, но их длины равны – вывести сообщение – «Длины имен равны».
*/

import java.io.*;
import java.util.Objects;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String nameOne = reader.readLine();
        String nameTwo = reader.readLine();

        if (nameOne.equals(nameTwo)) {
            System.out.println("Имена идентичны");
        } else if (nameOne.length() == nameTwo.length()) {
            System.out.println("Длины имен равны");
        }

    }
}
