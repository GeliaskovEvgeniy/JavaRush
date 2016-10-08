package com.javarush.test.level08.lesson08.task05;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* Удалить людей, имеющих одинаковые имена
Создать словарь (Map<String, String>) занести в него десять записей по принципу «фамилия» - «имя».
Удалить людей, имеющих одинаковые имена.
*/

public class Solution
{
    public static HashMap<String, String> createMap()
    {
        //напишите тут ваш код
        HashMap<String, String> map = new HashMap<>();
        map.put("As", "sd");
        map.put("Asd", "sd");
        map.put("Asz", "sd");
        map.put("Asx", "sd");
        map.put("Asc", "sdd");
        map.put("Asv", "sdf");
        map.put("Asr", "sdg");
        map.put("Asq", "sde");
        map.put("Asw", "sdq");
        map.put("Asg", "sdq");
        return map;
    }

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map)
    {
        //напишите тут ваш код
        HashMap<String, String> copy = new HashMap<>(map);
        for (String volue : copy.values()) {
            if (Collections.frequency(copy.values(), volue) > 1)
                removeItemFromMapByValue(map, volue);
        }
    }

    public static void removeItemFromMapByValue(HashMap<String, String> map, String value)
    {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair: copy.entrySet())
        {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }
}
