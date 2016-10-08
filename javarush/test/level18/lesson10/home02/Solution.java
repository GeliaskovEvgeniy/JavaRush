package com.javarush.test.level18.lesson10.home02;

/* Пробелы
В метод main первым параметром приходит имя файла.
Вывести на экран соотношение количества пробелов к количеству всех символов. Например, 10.45
1. Посчитать количество всех символов.
2. Посчитать количество пробелов.
3. Вывести на экран п2/п1*100, округлив до 2 знаков после запятой
4. Закрыть потоки. Не использовать try-with-resources
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Solution {
    public static void main(String[] args) throws IOException
    {

        String file = args[0];
        String spase = " ";
        InputStream inputStream = new FileInputStream(file);
        int cauntChars = 0,
            reads,
            cauntSpase = 0;
        while ((reads = inputStream.read()) !=-1) {
            cauntChars++;
            if (spase.contains((char)reads + ""))
                cauntSpase++;
        }

        //System.out.println(cauntSpase + "/" + cauntChars);

        double f =  (double)cauntSpase/cauntChars * 100;
        double d = new BigDecimal(f).setScale(2, RoundingMode.UP).doubleValue();

        System.out.println(d);
        inputStream.close();
    }
}
