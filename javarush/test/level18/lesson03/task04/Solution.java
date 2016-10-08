package com.javarush.test.level18.lesson03.task04;

/* Самые редкие байты
Ввести с консоли имя файла
Найти байт или байты с минимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        FileInputStream fis = new FileInputStream(scanner.nextLine());
        ArrayList<Integer> list = new ArrayList<>();
        while (fis.available() > 0){
            list.add(fis.read());
        }
        ArrayList<Integer> listResult = countMinRepetition(list);
        for (int b : listResult){
            System.out.println(b);
        }
        fis.close();
        scanner.close();

    }

    public static ArrayList<Integer> countMinRepetition(ArrayList<Integer> list){
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < list.size(); i++){
            int counts = 0;
            int b1 = list.get(i);
            for (int j = 0; j < list.size(); j++){
                if (b1 == list.get(j))
                    counts++;
            }
            map.put(b1, counts);
        }
        int[] arr = new int[map.size()];
        for (Map.Entry<Integer, Integer> m : map.entrySet()){
            int i = 0;
            arr[i] = m.getValue();
            i++;
            System.out.println(m.getKey() + " " + m.getValue());
        }
        int max = arr[0];
        for (int i : arr){
            System.out.println(arr[i]);
            if (max > i)
                max = i;
        }
        ArrayList<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> m : map.entrySet()){
            if (max == m.getValue())
                result.add(m.getKey());
        }
        return result;
    }
}
