package com.javarush.test.level27.lesson15.big01.kitchen;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;
import java.util.Observable;
import java.util.Observer;

public class Waitor implements Observer{
    private Cook cook;
    private Order order;

    @Override
    public void update(Observable o, Object arg) {
        this.cook = (Cook) o;
        this.order = (Order) arg;
        if (!this.order.isEmpty())
            ConsoleHelper.writeMessage(order + " was cooked by " + cook);
    }
}
