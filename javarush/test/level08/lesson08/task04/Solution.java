package com.javarush.test.level08.lesson08.task04;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* Удалить всех людей, родившихся летом
Создать словарь (Map<String, Date>) и занести в него десять записей по принципу: «фамилия» - «дата рождения».
Удалить из словаря всех людей, родившихся летом.
*/

public class Solution
{


    public static HashMap<String, Date> createMap()
    {
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("Stallone", new Date("JUNE 1 1980"));
        map.put("Cron", new Date("JUNE 5 1981"));
        map.put("Aso", new Date("JUNE 8 2001"));
        map.put("Som", new Date("JUNE 23 1998"));
        map.put("Doss", new Date("JUNE 12 1981"));
        map.put("Fura", new Date("JUNE 14 2013"));
        map.put("Pok", new Date("JUNE 15 2014"));
        map.put("Spock", new Date("JUNE 4 2010"));
        map.put("Fack", new Date("JUNE 6 2003"));
        map.put("End", new Date("MAY 1 1985"));
        return map;

        //напишите тут ваш код

    }

    public static void removeAllSummerPeople(HashMap<String, Date> map)
    {
        //напишите тут ваш код
        Iterator<Map.Entry<String, Date>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Date a = iterator.next().getValue();
            int v=a.getMonth();
            if (v > 4 && v <8)
                iterator.remove();
        }

    }
}
