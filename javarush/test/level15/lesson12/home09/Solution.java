package com.javarush.test.level15.lesson12.home09;

/* Парсер реквестов
Считать с консоли URl ссылку.
Вывести на экран через пробел список всех параметров (Параметры идут после ? и разделяются &, например, lvl=15).
URL содержит минимум 1 параметр.
Если присутствует параметр obj, то передать его значение в нужный метод alert.
alert(double value) - для чисел (дробные числа разделяются точкой)
alert(String value) - для строк

Пример 1
Ввод:
http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo
Вывод:
lvl view name

Пример 2
Ввод:
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo
Вывод:
obj name
double 3.14
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        //add your code here
//        Scanner scanner = new Scanner(System.in);
//        String url = scanner.nextLine();
//
//        String s = url.substring(url.indexOf('?') + 1);
//
//        String[] s1 = s.split("&");
//
//        if (equal(s1)){
//            for (int i = 0; i < s1.length; i++){
//                String[] a = s1[i].split("=");
//                System.out.print(a[0] + " ");
//            }
//            System.out.println();
//            for (int i = 0; i < s1.length; i++){
//                String[] a = s1[i].split("=");
//                for (String q : a){
//                    try {
//                        alert(Double.parseDouble(q));
//                    } catch (Exception e){}
//                }
//            }
//        } else {
//            for (int i = 0; i < s1.length; i++){
//                String[] a = s1[i].split("=");
//                System.out.print(a[0] + " ");
//            }
//        }
        List<String> list = new ArrayList<String>();
        List<String> list2 = new ArrayList<String>();
        List<String> listObjValue = new ArrayList<String>();
        String objValue = null;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        int i = s.indexOf('?');
        s = s.substring(i+1);//оставляем все что после ?
        for(String d:s.split("&"))//Разделяем строки по &
        {
            list.add(d);
        }
        for(String z:list){
            if(z.startsWith("obj=")){  // возможно тут заблуждение
                int j = z.indexOf("=");
                objValue = z.substring(j+1);
                listObjValue.add(objValue);
            }
        }//ищем обьекты obj и заносим их значения в отдельный список
        for(String c:list){
            i = c.indexOf("=");
            if(i!=-1){
                c = c.substring(0, i);
            }
            list2.add(c);// Заносим обьекты слева от равно для вывода во второй список
        }
        for(int l =0;l<list2.size()-1;l++)
        {
            System.out.print(list2.get(l) + " ");
        }
        System.out.print(list2.get(list2.size()-1));
        System.out.println();//играемся с выводом, что бы не было лишнего пробела в конце и был переход на новую строку
        for(String obValue:listObjValue)
        {
            if (obValue != null)
                try
                {
                    double d = Double.parseDouble(obValue);
                    Solution.alert(d);
                }
                catch (Exception e)
                {
                    Solution.alert(obValue);
                }
        }//вывод значений obj
    }

//    public static boolean equal(String[] strings)
//    {
//        for (String s : strings){
//            if (s.startsWith("obj="))
//                return true;
//        }
//        return false;
//    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
