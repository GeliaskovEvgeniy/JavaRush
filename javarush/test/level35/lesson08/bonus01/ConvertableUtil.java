package com.javarush.test.level35.lesson08.bonus01;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConvertableUtil {

    public static<T extends Convertable> Map convert(List<T> list) {
        Map<Object, T> result = new HashMap<>();
        for (T t : list){
            result.put(t.getKey(), t);
        }
        return result;
    }
}
