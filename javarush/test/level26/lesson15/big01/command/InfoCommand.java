package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;
import java.util.ResourceBundle;


class InfoCommand implements Command {
    private ResourceBundle res = ResourceBundle.getBundle("com.javarush.test.level26.lesson15.big01.resources.info_en");

    @Override
    public void execute()
    {
        ConsoleHelper consoleHelper = new ConsoleHelper();
        boolean moneyAviable = false;
        for (CurrencyManipulator currencyManipulator : CurrencyManipulatorFactory.getAllCurrencyManipulators())
        {
            moneyAviable = (moneyAviable || !currencyManipulator.hasMoney());
                int totalAmaund = currencyManipulator.getTotalAmount();
            if (totalAmaund > 0)
                consoleHelper.writeMessage(res.getString("before") + " " + currencyManipulator.getCurrencyCode()
                        + " - " + String.valueOf(totalAmaund));
            else
                consoleHelper.writeMessage(res.getString("no.money"));
        }

        if (!moneyAviable)
            consoleHelper.writeMessage(res.getString("no.money"));

    }
}
