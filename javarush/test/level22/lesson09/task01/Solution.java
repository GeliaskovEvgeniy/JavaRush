package com.javarush.test.level22.lesson09.task01;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/* Обращенные слова
В методе main с консоли считать имя файла, который содержит слова, разделенные пробелами.
Найти в тексте все пары слов, которые являются обращением друг друга. Добавить их в result.
Порядок слов first/second не влияет на тестирование.
Использовать StringBuilder.
Пример содержимого файла
рот тор торт о
о тот тот тот
Вывод:
рот тор
о о
тот тот
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException
    {
        Scanner scanner = new Scanner(System.in);
        BufferedReader reader = new BufferedReader(new FileReader(scanner.nextLine()));
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(reader.readLine());
        sameContent(stringBuilder);
        for (Pair p : result) {
            System.out.println(p.toString());
        }
        scanner.close();
        reader.close();

    }

    public static void sameContent(StringBuilder s){
        String s1 = s.toString();
        String[] str = s1.split(" ");
        Pair pair = null;
        for (int j = 0; j < str.length; j++)
        {
            pair = new Pair();
            pair.first = str[j];
            for (int i = str.length-1; i > j; i--)
            {
                String q = pair.first;
                String w = String.valueOf(new StringBuilder().append(str[i]).reverse());
                if (q.equals(w)) {
                    pair.second = str[i];
                    result.add(pair);
                }

            }
        }
    }

    public static class Pair {
        String first;
        String second;

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                    first == null && second != null ? second :
                    second == null && first != null ? first :
                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
