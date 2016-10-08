package com.javarush.test.level22.lesson05.task01;

/* Найти подстроку
Метод getPartOfString должен возвращать подстроку начиная с символа после 1-го пробела и до конца слова,
которое следует после 4-го пробела.
Пример: "JavaRush - лучший сервис обучения Java."
Результат: "- лучший сервис обучения"
На некорректные данные бросить исключение TooShortStringException (сделать исключением).
Сигнатуру метода getPartOfString не менять.
Метод main не участвует в тестировании.
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException
    {
        try{
            int a = 0;
            int i = 0;
            for (char c : string.toCharArray()){
                if (c == ' ') i++;
                if (i == 5) break;
                a++;
            }
            return string.substring(string.indexOf(" ")+1, a).trim();

        }catch (Exception e){
            throw new TooShortStringException();
        }
    }

    public static class TooShortStringException extends Throwable
    {
    }

    public static void main(String[] args) throws TooShortStringException
    {
        System.out.println(getPartOfString("JavaRush - лучший сервис       обучения Java."));
        String s = getPartOfString("  a b c d ");
        System.err.println(s + "|");
        System.err.println("0123456789012345678901234567890");
//2
        s = getPartOfString("JavaRush - лучший сервис            обучения Java.");
        System.err.println(s + "|");
        System.err.println("0123456789012345678901234567890");
//3
        s = getPartOfString("     5");
        System.err.println(s + "|");
        System.err.println("0123456789012345678901234567890");
//4
        s = getPartOfString("  1 + 2= 3");
        System.err.println(s + "|");
        System.err.println("0123456789012345678901234567890");
//5
        s = getPartOfString("a + b = c ");
        System.err.println(s + "|");
        System.err.println("0123456789012345678901234567890");
//6
        s = getPartOfString("    ");
        System.err.println(s + "|");
        System.err.println("0123456789012345678901234567890");
//7
        s = getPartOfString("");
        System.err.println(s + "|");
        System.err.println("0123456789012345678901234567890");
//8
        s = getPartOfString(null);
        System.err.println(s + "|");
        System.err.println("0123456789012345678901234567890");
    }
}
