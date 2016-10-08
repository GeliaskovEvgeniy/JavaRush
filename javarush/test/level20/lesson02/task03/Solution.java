package com.javarush.test.level20.lesson02.task03;

import com.sun.jmx.snmp.Enumerated;

import java.io.*;
import java.util.*;

/* Знакомство с properties
В методе fillInPropertiesMap считайте имя файла с консоли и заполните карту properties данными из файла.
Про .properties почитать тут - http://ru.wikipedia.org/wiki/.properties
Реализуйте логику записи в файл и чтения из файла для карты properties.
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();

    public static void main(String[] args) throws Exception
    {
        Solution solution = new Solution();
        solution.fillInPropertiesMap();
        for (Map.Entry<String, String> m : properties.entrySet()) {
            System.out.println(m.getKey() + " - " + m.getValue());
        }
    }

    public void fillInPropertiesMap() throws Exception
    {
        //implement this method - реализуйте этот метод
        Scanner scanner = new Scanner(System.in);
        File file = new File(scanner.nextLine());
        scanner.close();
        FileInputStream inputStream = new FileInputStream(file);
        load(inputStream);
        inputStream.close();

    }

    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод
        Properties saveProperteis = new Properties();
        for (Map.Entry<String, String> pair : properties.entrySet()) {
            saveProperteis.setProperty(pair.getKey(), pair.getValue());
        }
        saveProperteis.store(outputStream, null);
    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
        Properties p = new Properties();
        p.load(inputStream);
        Enumeration e = p.propertyNames();
        while (e.hasMoreElements()) {
            String key = (String) e.nextElement();
            properties.put(key, p.getProperty(key));
        }

    }
}
