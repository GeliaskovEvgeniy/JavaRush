package com.javarush.test.level18.lesson10.bonus01;

/* Шифровка
Придумать механизм шифровки/дешифровки

Программа запускается с одним из следующих наборов параметров:
-e fileName fileOutputName
-d fileName fileOutputName
где
fileName - имя файла, который необходимо зашифровать/расшифровать
fileOutputName - имя файла, куда необходимо записать результат шифрования/дешифрования
-e - ключ указывает, что необходимо зашифровать данные
-d - ключ указывает, что необходимо расшифровать данные
*/

import java.io.*;

public class Solution {

//    private static String alphabet = "абвгдеёжзийклмнопрстуфхцчшщъыьэюяабвгдеёжзийклмнопрстуфхцчшщъыьэюяАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";

    public static void main(String[] args) throws IOException
    {
/*
        BufferedWriter writer = new BufferedWriter(new FileWriter(args[2]));
        BufferedReader reader;

        if (args[0].equals("-e")){
            reader = new BufferedReader(new FileReader(args[1]));
            String s;
            while ((s = reader.readLine()) != null){
                writer.write(encrypt(s, 4) + "\n");

            }
            writer.close();
            reader.close();
        } else if (args[0].equals("-d")){
            reader = new BufferedReader(new FileReader(args[1]));
            String s;
            while ((s = reader.readLine()) != null){
                writer.write(decrypt(s, 4) + "\n");

            }
            reader.close();
            writer.close();
        }
*/
        int key = 5;
        FileInputStream fileInputStream = new FileInputStream(args[1]);
        FileOutputStream fileOutputStream = new FileOutputStream(args[2]);
        if (args[0].equals("-e")){  // необходимо зашифровать данные
            while (fileInputStream.available() > 0){
                int data = fileInputStream.read();
                fileOutputStream.write(data+key);
            }
        }
        if (args[0].equals("-d")){  // -d - ключ указывает, что необходимо расшифровать данные
            while (fileInputStream.available() > 0){
                int data = fileInputStream.read();
                fileOutputStream.write(data-key);
            }
        }
        fileInputStream.close();
        fileOutputStream.close();
    }
    }

/*

    public static String encrypt(String s, int i){
        StringBuilder sb = new StringBuilder();
        for (int a = 0; a < s.length();a++){
            for (int j = 0; j < alphabet.length(); j++){

                if (s.charAt(a) == alphabet.charAt(j)){
                    sb.append(alphabet.charAt(j+i));
                    break;
                } else if (j == alphabet.length()-1){
                    sb.append(s.charAt(a));
                }
            }
        }
        return sb.toString();
    }

    public static String decrypt(String s, int i){
        StringBuilder sb = new StringBuilder();
        for (int a = 0; a < s.length();a++){
            for (int j = i; j < alphabet.length(); j++){
                if (s.charAt(a) == alphabet.charAt(j)){
                    sb.append(alphabet.charAt(j-i));
                    break;
                } else if (j == alphabet.length()-1){
                    sb.append(s.charAt(a));
                }
            }
        }
        return sb.toString();

    }
*/


