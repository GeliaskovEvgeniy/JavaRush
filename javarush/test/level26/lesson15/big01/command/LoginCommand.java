package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.ResourceBundle;

class LoginCommand implements Command
{
    private ResourceBundle validCreditCards = ResourceBundle.getBundle("com.javarush.test.level26.lesson15.big01.resources.verifiedCards");

    @Override
    public void execute() throws InterruptOperationException
    {
        String a;

        while (true){
            ConsoleHelper.writeMessage("Введите номер карты.");
             a = ConsoleHelper.readString();
            if (a.matches("^[0-9]{12}$")){
                if (validCreditCards.containsKey(a)){
                    ConsoleHelper.writeMessage("Верификация прошла успешно.");
                    break;
                }
            } else {
                ConsoleHelper.writeMessage("Данные не валидны.");
            }
        }
        while (true){
            ConsoleHelper.writeMessage("Введите пинкод");
            String s = ConsoleHelper.readString();
            if (s.matches("^[0-9]{4}$")){
                if (validCreditCards.getString(a).equals(s)){
                    ConsoleHelper.writeMessage("Верификация прошла успешно.");
                    break;
                }
            } else {
                ConsoleHelper.writeMessage("Данные не валидны.");
            }
        }
    }
}
