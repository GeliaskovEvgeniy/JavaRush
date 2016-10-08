package com.javarush.test.level18.lesson10.home08;

import java.io.*;
import java.util.*;

/* Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit"
Передайте имя файла в нить ReadThread
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Закрыть потоки. Не использовать try-with-resources
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s;
        while (!(s = scanner.nextLine()).equals("exit")) {
            new ReadThread(s).start();
        }
        scanner.close();

    }

    public static class ReadThread extends Thread {
        private String fileName;
        public ReadThread(String fileName)
        {
            //implement constructor body
            this.fileName = fileName;

        }
        // implement file reading here - реализуйте чтение из файла тут
        public void run() {
           try
           {
               InputStream stream = new BufferedInputStream(new FileInputStream(fileName));
               Map<Integer, Integer> map = new HashMap<>();
               while (stream.available() > 0)
               {
                   int b = stream.read();
                   if (map.containsKey(b))
                   {
                       map.put(b, map.get(b) + 1);
                   } else
                   {
                       map.put(b, 1);
                   }
               }
               stream.close();
               int max = 0;
               int result = 0;
               for (Map.Entry<Integer, Integer> m : map.entrySet())
               {
                   if (max < m.getValue())
                   {
                       max = m.getValue();
                       result = m.getKey();
                   }
               }

               resultMap.put(fileName, result);
           } catch (Exception e) {}
        }
    }
}
