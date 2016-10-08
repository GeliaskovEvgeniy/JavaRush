package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;
import com.javarush.test.level26.lesson15.big01.exception.NotEnoughMoneyException;
import java.util.Map;
import java.util.ResourceBundle;

class WithdrawCommand implements Command {
    private ResourceBundle res = ResourceBundle.getBundle("com.javarush.test.level26.lesson15.big01.resources.withdraw_en");

    @Override
    public void execute() throws InterruptOperationException
    {
        String currencyCode = ConsoleHelper.askCurrencyCode();
        CurrencyManipulator currencyManipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode);

        while (true){
            ConsoleHelper.writeMessage(res.getString("before"));
            try
            {
                int sum = Integer.parseInt(ConsoleHelper.readString());
                if (sum <= 0) {
                    throw new NumberFormatException();
                }
                if (currencyManipulator.isAmountAvailable(sum)){
                    Map<Integer, Integer> map = currencyManipulator.withdrawAmount(sum);
                    for (Map.Entry<Integer, Integer> m :map.entrySet()){
                        ConsoleHelper.writeMessage(String.format(res.getString("success.format"), m.getKey(), m.getValue()));
                    }
                    ConsoleHelper.writeMessage("Операция прошла успешно.");
                    break;
                }else {
                    throw new IllegalAccessException();
                }
            }catch (NumberFormatException e) {
                ConsoleHelper.writeMessage(res.getString("specify.amount"));
            }catch (NotEnoughMoneyException e) {
                ConsoleHelper.writeMessage(res.getString("exact.amount.not.available"));
            }catch (IllegalAccessException e) {
                ConsoleHelper.writeMessage(res.getString("not.enough.mone"));
            }
        }
    }
}
