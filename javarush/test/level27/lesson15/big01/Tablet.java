package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.ad.AdvertisementManager;
import com.javarush.test.level27.lesson15.big01.ad.NoVideoAvailableException;
import com.javarush.test.level27.lesson15.big01.kitchen.Order;
import java.io.IOException;
import java.util.Observable;
import java.util.logging.Level;

public class Tablet extends Observable
{
    private final int number;
    public static java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Tablet.class.getName());

    public Tablet(int number) {
        this.number = number;
    }

    public Order createOrder() {

        Order order = null;
        try {
            order = new Order(this);
            ConsoleHelper.writeMessage(order.toString());
            setChanged();
            notifyObservers(order);

            AdvertisementManager manager = new AdvertisementManager(order.getTotalCookingTime()*60);
            try
            {
                manager.processVideos();
            }catch (NoVideoAvailableException e) {
                logger.log(Level.INFO, "No video is available for the order " + order);
            }
        }catch (IOException e) {
            logger.log(java.util.logging.Level.SEVERE, "Console is unavailable.");
        }


        return order;
    }

    @Override
    public String toString()
    {
        return String.format("Tablet{number=%d}", number);
    }
}
