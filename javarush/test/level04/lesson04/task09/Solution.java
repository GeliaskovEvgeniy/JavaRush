package com.javarush.test.level04.lesson04.task09;

/* Светофор
Работа светофора для пешеходов запрограммирована следующим образом: в начале каждого часа в течение трех минут горит зеленый сигнал,
затем в течение одной минуты — желтый, а потом в течение одной минуты — красный, затем опять зеленый горит три минуты и т. д.
Ввести с клавиатуры вещественное число t, означающее время в минутах, прошедшее с начала очередного часа.
Определить, сигнал какого цвета горит для пешеходов в этот момент.
Результат вывести на экран в следующем виде:
"зеленый" - если горит зеленый цвет, "желтый" - если горит желтый цвет, "красный" - если горит красный цвет.
Пример для числа 2.5:
зеленый
Пример для числа 3:
желтый
Пример для числа 4:
красный
Пример для числа 5:
зеленый
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код 2 1 1

        String green = "зеленый";
        String yelow = "желтый";
        String red = "красный";

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        double minuta = Double.parseDouble(reader.readLine());

        if (minuta % 5 > 0 && minuta % 5 < 3) {
            System.out.println(green);
        } else if (minuta % 5 >= 3 && minuta % 5 < 4) {
            System.out.println(yelow);
        } else {
            System.out.println(red);
        }

    }
}