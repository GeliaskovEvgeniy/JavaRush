package com.javarush.test.level15.lesson09.task01;

import java.util.HashMap;
import java.util.Map;

/* Статики 1
В статическом блоке инициализировать labels 5 различными парами.
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();

    static {
        labels.put(1.1, "one");
        labels.put(2.2, "twu");
        labels.put(3.3, "free");
        labels.put(4.4, "foo");
        labels.put(5.5, "fife");
    }

    public static void main(String[] args) {
        System.out.println(labels);
    }
}
