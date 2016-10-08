package com.javarush.test.level27.lesson15.big01;


import com.javarush.test.level27.lesson15.big01.kitchen.Cook;
import com.javarush.test.level27.lesson15.big01.kitchen.Order;
import com.javarush.test.level27.lesson15.big01.kitchen.Waitor;

public class Restaurant {
    public static void main(String[] args)
    {
        Tablet tablet = new Tablet(5);
        Order order = tablet.createOrder();

        Cook cook = new Cook("Amigo");
        cook.update(tablet, order);

        Waitor waitor = new Waitor();
        waitor.update(cook, order);
    }
}
