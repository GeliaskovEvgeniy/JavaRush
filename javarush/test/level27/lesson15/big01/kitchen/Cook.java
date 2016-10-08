package com.javarush.test.level27.lesson15.big01.kitchen;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;
import com.javarush.test.level27.lesson15.big01.Tablet;



import java.util.Observable;
import java.util.Observer;


public class Cook extends Observable implements Observer{
    private String name;
    private Order order;
    private Tablet tablet;


    public Cook(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public void update(Observable o, Object arg) {
        this.order = (Order) arg;
        this.tablet = (Tablet) o;
        if (!this.order.isEmpty()) {
            ConsoleHelper.writeMessage("Start cooking - " + order + ", cooking time "
                    + order.getTotalCookingTime() + "min");
        }
        setChanged();
        notifyObservers(order);


    }

}
