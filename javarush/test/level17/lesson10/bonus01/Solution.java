package com.javarush.test.level17.lesson10.bonus01;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* CRUD
CrUD - Create, Update, Delete
Программа запускается с одним из следующих наборов параметров:
-c name sex bd
-u id name sex bd
-d id
-i id
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-c  - добавляет человека с заданными параметрами в конец allPeople, выводит id (index) на экран
-u  - обновляет данные человека с данным id
-d  - производит логическое удаление человека с id
-i  - выводит на экран информацию о человеке с id: name sex (м/ж) bd (формат 15-Apr-1990)

id соответствует индексу в списке
Все люди должны храниться в allPeople
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat

Пример параметров: -c Миронов м 15/04/1990
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();
    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        //start here - начни тут

        if (args.length > 0) {
            switch (args[0]){
                case "-c" : crud(args); break;
                case "-u" : update(args); break;
                case "-d" : delete(args); break;
                case "-i" : reade(args); break;
            }
        }
    }

    public static void crud(String[] arr){
        try
        {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
            Date bd = dateFormat.parse(arr[3]);
            if (arr[2].equals("м"))
                allPeople.add(Person.createMale(arr[1], bd));
            else
                allPeople.add(Person.createFemale(arr[1], bd));
            System.out.println(allPeople.size()-1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void update(String[] arr){
        try
        {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
            Date bd = dateFormat.parse(arr[4]);
            if (arr[3].equals("м"))
                allPeople.set(Integer.parseInt(arr[1]), Person.createMale(arr[2], bd));
            else
                allPeople.set(Integer.parseInt(arr[1]), Person.createFemale(arr[2], bd));
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void delete(String[] arr){
        try
        {
            int i = Integer.parseInt(arr[1]);
            allPeople.get(i).setName(null);
            allPeople.get(i).setSex(null);
            allPeople.get(i).setBirthDay(null);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void reade(String[] arr){
        try
        {
            int i = Integer.parseInt(arr[1]);
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
            System.out.print(allPeople.get(i).getName() + " ");
            if (allPeople.get(i).getSex().equals(Sex.MALE)) System.out.print("м");
            else System.out.print("ж");
            System.out.println(" " + dateFormat.format(allPeople.get(i).getBirthDay()));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
