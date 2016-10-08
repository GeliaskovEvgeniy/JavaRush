package com.javarush.test.level22.lesson13.task01;

import java.util.StringTokenizer;

/* StringTokenizer
Используя StringTokenizer разделить query на части по разделителю delimiter.
Пример,
getTokens("level22.lesson13.task01", ".") == {"level22", "lesson13", "task01"}
*/
public class Solution {

    public static void main(String[] args)
    {
        String[] s = getTokens("level22.lesson13.task01", ".");
        for (String s1 : s)
            System.out.println(s1);
    }

    public static String [] getTokens(String query, String delimiter) {
        StringTokenizer tokenizer = new StringTokenizer(query, delimiter);
        String[] strings = new String[tokenizer.countTokens()];
        for (int i = 0; tokenizer.hasMoreTokens(); i++) {
            strings[i] = tokenizer.nextToken();
        }

        return strings;
    }
}
