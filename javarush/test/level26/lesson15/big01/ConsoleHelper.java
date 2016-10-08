package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ResourceBundle;

public class ConsoleHelper {

    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message){
        System.out.println(message);
    }

    public static String readString() throws InterruptOperationException
    {
        String result = null;
        try {
            result = reader.readLine();
        } catch (IOException e) {}

        if ("EXIT".equalsIgnoreCase(result))
            throw new InterruptOperationException();
        return result;
    }

    public static String askCurrencyCode() throws InterruptOperationException
    {
        String result = null;
        while (true)
        {
            writeMessage(res.getString("before"));
            result = readString().trim();
            if (result.matches("^[A-Za-z]{3}$"))
                break;
            else writeMessage(res.getString("invalid.data"));
        }
        return result.toUpperCase();
    }

    private static ResourceBundle res = ResourceBundle.getBundle("com.javarush.test.level26.lesson15.big01.resources.deposit_en");


    public static String[] getValidTwoDigits(String currencyCode) throws InterruptOperationException
    {   String s;
        while (true)
        {
            writeMessage(res.getString("success.format"));
            s  = readString();
            if (s.matches("\\d+ \\d+"))
            {
                break;
            }
            else writeMessage(res.getString("invalid.data"));
        }
        return s.split(" ");
    }

    public static Operation askOperation() throws InterruptOperationException
    {   Operation result = null;
        while (true){
            writeMessage("Выберите операцию. 1 - INFO, 2 - DEPOSIT, 3 - WITHDRAW, 4 - EXIT");
            try {
                result = Operation.getAllowableOperationByOrdinal(Integer.parseInt(readString()));
                break;
            }
            catch (IllegalArgumentException  e) {writeMessage(res.getString("invalid.data"));}}
        return result;
    }
}
