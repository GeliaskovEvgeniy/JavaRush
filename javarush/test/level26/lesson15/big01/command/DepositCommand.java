package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.ResourceBundle;

class DepositCommand implements Command {
    private ResourceBundle res = ResourceBundle.getBundle("com.javarush.test.level26.lesson15.big01.resources.deposit_en");

    @Override
    public void execute() throws InterruptOperationException
    {
        String code = ConsoleHelper.askCurrencyCode();
        CurrencyManipulator cm = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(code);
        String[] str = ConsoleHelper.getValidTwoDigits(code);
        cm.addAmount(Integer.parseInt(str[0]), Integer.parseInt(str[1]));
    }
}
