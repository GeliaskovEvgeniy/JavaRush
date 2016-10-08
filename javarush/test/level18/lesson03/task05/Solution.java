package com.javarush.test.level18.lesson03.task05;

import java.io.FileInputStream;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;




/* Сортировка байт
Ввести с консоли имя файла
Считать все байты из файла.
Не учитывая повторений - отсортировать их по байт-коду в возрастающем порядке.
Вывести на экран
Закрыть поток ввода-вывода

Пример байт входного файла
44 83 44

Пример вывода
44 83
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        FileInputStream fis = new FileInputStream(scanner.nextLine());
        Set<Integer> set = new TreeSet<>();
        while (fis.available() > 0){
            set.add(fis.read());
        }
        for (int i : set){
            System.out.println(i);
        }
        scanner.close();
        fis.close();
    }
}
