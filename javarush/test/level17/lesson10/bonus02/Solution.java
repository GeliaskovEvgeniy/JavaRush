package com.javarush.test.level17.lesson10.bonus02;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;


/* CRUD 2
CrUD Batch - multiple Creation, Updates, Deletion
!!!РЕКОМЕНДУЕТСЯ выполнить level17.lesson10.bonus01 перед этой задачей!!!

Программа запускается с одним из следующих наборов параметров:
-c name1 sex1 bd1 name2 sex2 bd2 ...
-u id1 name1 sex1 bd1 id2 name2 sex2 bd2 ...
-d id1 id2 id3 id4 ...
-i id1 id2 id3 id4 ...
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-с  - добавляет всех людей с заданными параметрами в конец allPeople, выводит id (index) на экран в соответствующем порядке
-u  - обновляет соответствующие данные людей с заданными id
-d  - производит логическое удаление всех людей с заданными id
-i  - выводит на экран информацию о всех людях с заданными id: name sex bd

id соответствует индексу в списке
Формат вывода даты рождения 15-Apr-1990
Все люди должны храниться в allPeople
Порядок вывода данных соответствует вводу данных
Обеспечить корректную работу с данными для множества нитей (чтоб не было затирания данных)
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat
*/

public class Solution  {
    public static List<Person> allPeople = new ArrayList<Person>();
    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws InterruptedException
    {
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


    public synchronized static void crud(String[] arr){
        try
        {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
            for (int i = 1; i < arr.length; i+=3) {
                Date bd = dateFormat.parse(arr[i+2]);
                if (arr[i+1].equals("м"))
                    allPeople.add(Person.createMale(arr[i], bd));
                else
                    allPeople.add(Person.createFemale(arr[i], bd));
                System.out.println(allPeople.size() - 1);
            }
        } catch (Exception e) {
        }
    }

    public synchronized static void update(String[] arr){
        try
        {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
            for (int i = 1; i < arr.length; i+=4)
            {
                Date bd = dateFormat.parse(arr[i+3]);
                if (arr[i+2].equals("м"))
                    allPeople.set(Integer.parseInt(arr[i]), Person.createMale(arr[i+1], bd));
                else
                    allPeople.set(Integer.parseInt(arr[i]), Person.createFemale(arr[i+1], bd));
            }
        } catch (Exception e){
        }

    }

    public synchronized static void delete(String[] arr){

        for (int a = 1; a < arr.length; a++)
        {
            try
            {
                {
                    int i = Integer.parseInt(arr[a]);
                    allPeople.get(i).setName(null);
                    allPeople.get(i).setSex(null);
                    allPeople.get(i).setBirthDay(null);
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }

    public synchronized static void reade(String[] arr){
        try
        {
            for (int a = 1; a < arr.length; a++)
            {
                int i = Integer.parseInt(arr[a]);
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
                System.out.print(allPeople.get(i).getName() + " ");
                if (allPeople.get(i).getSex().equals(Sex.MALE))
                    System.out.print("м");
                else
                    System.out.print("ж");
                System.out.println(" " + dateFormat.format(allPeople.get(i).getBirthDay()));
            }
        }catch (Exception e){
        }
    }

}

