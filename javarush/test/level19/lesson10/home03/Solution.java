package com.javarush.test.level19.lesson10.home03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* Хуан Хуанович
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String
[день] - int, [месяц] - int, [год] - int
данные разделены пробелами

Заполнить список PEOPLE импользуя данные из файла
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException, ParseException
    {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));


        while (reader.ready()) {
            String res = reader.readLine();
            String[] result = res.split(" ");
            String s = "";
            String d = "";
            for (String a : result) {
                try {
                    int i = Integer.parseInt(a);
                    d+=a+" ";

                }catch (Exception e) {
                    s+=a+" ";
                }
            }
            String s1 = d.trim();
            String d1 = s.trim();

            SimpleDateFormat format = new SimpleDateFormat("dd MM yyyy");
            Date date = format.parse(s1);

            PEOPLE.add(new Person(d1, date));
        }
        reader.close();
    }

}
