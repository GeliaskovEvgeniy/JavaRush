package com.javarush.test.level18.lesson03.task01;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;

/* Максимальный байт
Ввести с консоли имя файла
Найти максимальный байт в файле, вывести его на экран.
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String nameFile = scanner.nextLine();
        ArrayList<Integer> list = new ArrayList<>();
        FileInputStream fileInputStream = new FileInputStream(nameFile);
        while (fileInputStream.available() > 0) {
            list.add(fileInputStream.read());
        }
        int maximum = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (maximum < list.get(i)) {
                maximum = list.get(i);
            }
        }
        System.out.println(maximum);
        scanner.close();
        fileInputStream.close();
    }
}
