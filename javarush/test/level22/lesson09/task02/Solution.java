package com.javarush.test.level22.lesson09.task02;

import java.util.Map;

/* Формируем Where
Сформируйте часть запроса WHERE используя StringBuilder.
Если значение null, то параметр не должен попадать в запрос.
Пример:
{"name", "Ivanov", "country", "Ukraine", "city", "Kiev", "age", null}
Результат:
"name = 'Ivanov' and country = 'Ukraine' and city = 'Kiev'"
*/
public class Solution {
//
//    public static void main(String[] args)
//    {
//        Map<String, String> map = new HashMap<>();
//        map.put("name", "Ivanov");
//        map.put("country", "Ukraine");
//        map.put(null, "ffvsfv");
//        map.put("ev", null);
//        System.out.println(getCondition(map).toString());
//
//    }

    public static StringBuilder getCondition(Map<String, String> params) {
        StringBuilder str = new StringBuilder();
//        str.append("WHERE IS NOT NULL");
//        if (params.isEmpty()) return null;
        for (Map.Entry<String, String> map : params.entrySet()) {
            if (map.getKey() != null && map.getValue() != null) {
                str.append(map.getKey() + " = " + "'" + map.getValue() + "' and ");
            }
        }
        int i = str.lastIndexOf("'");
        return new StringBuilder().append(str.substring(0, i+1));
    }
}
