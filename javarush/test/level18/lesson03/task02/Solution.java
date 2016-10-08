package com.javarush.test.level18.lesson03.task02;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;

/* Минимальный байт
Ввести с консоли имя файла
Найти минимальный байт в файле, вывести его на экран.
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();
        FileInputStream fileInputStream = new FileInputStream(fileName);
        ArrayList<Integer> list = new ArrayList<>();
        while (fileInputStream.available() > 0) {
            list.add(fileInputStream.read());
        }
        int minimum = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (minimum > list.get(i)) {
                minimum = list.get(i);
            }
        }
        System.out.println(minimum);
        scanner.close();
        fileInputStream.close();
    }
}
