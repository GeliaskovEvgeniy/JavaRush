package com.javarush.test.level18.lesson03.task03;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.*;

/* Самые частые байты
Ввести с консоли имя файла
Найти байт или байты с максимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception
    {
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();
        InputStream inputStream = new FileInputStream(fileName);
        byte[] arr = new byte[inputStream.available()];
        inputStream.read(arr, 0, inputStream.available());
        Result result = method(arr);
        System.out.println(result.getNum());
        scanner.close();
        inputStream.close();
    }


    static Result method(byte[] arr) {

        if (arr == null) {
            return null;
        }

        int maxNum = 0, num = 0, maxCount = 0, count = 0;

        if (arr.length > 0) {

            byte[] copy = Arrays.copyOf(arr, arr.length);
            Arrays.sort(copy);
            boolean started = false;

            for (int i : copy) {

                if (!started || i != num) {
                    started = true;

                    if (count > maxCount) {
                        maxNum = num;
                        maxCount = count;
                    }

                    num = i;
                    count = 1;
                }
                else {

                    count++;
                }
            }
        }

        final int resultNum = maxNum;
        final int resultCount = maxCount;

        return new Result() {

            @Override
            public int getNum() {
                return resultNum;
            }

            @Override
            public int getCount() {
                return resultCount;
            }
        };
    }

    interface Result {
        int getNum();
        int getCount();
    }
}
