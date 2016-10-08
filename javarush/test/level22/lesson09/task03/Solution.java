package com.javarush.test.level22.lesson09.task03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/* Составить цепочку слов
В методе main считайте с консоли имя файла, который содержит слова, разделенные пробелом.
В методе getLine используя StringBuilder расставить все слова в таком порядке,
чтобы последняя буква данного слова совпадала с первой буквой следующего не учитывая регистр.
Каждое слово должно участвовать 1 раз.
Метод getLine должен возвращать любой вариант.
Слова разделять пробелом.
В файле не обязательно будет много слов.

Пример тела входного файла:
Киев Нью-Йорк Амстердам Вена Мельбурн

Результат:
Амстердам Мельбурн Нью-Йорк Киев Вена
*/
public class Solution {
    public static void main(String[] args) throws IOException
    {
        //...
        Scanner scanner = new Scanner(System.in);
        BufferedReader bf = new BufferedReader(new FileReader(scanner.nextLine()));
        String[] s = bf.readLine().split(" ");
        Arrays.sort(s);
        for (String a : s)
            System.out.print(a+" ");
        System.out.println();
        scanner.close();
        bf.close();
        StringBuilder result = getLine(s);
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {
        StringBuilder sb = new StringBuilder();
        sb.append(words[0]);

        for (int i = 0; i < words.length; i++){
            char c = sb.toString().toLowerCase().charAt(sb.length()-1);
            for (int j = 1; j < words.length; j++ ){
                char a = words[j].toLowerCase().charAt(0);
                if( c == a){
                    sb.append(" ");
                    sb.append(words[j]);
                }
            }

        }
        return sb;
    }
}
