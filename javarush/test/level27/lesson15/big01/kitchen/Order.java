package com.javarush.test.level27.lesson15.big01.kitchen;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;
import com.javarush.test.level27.lesson15.big01.Tablet;

import java.io.IOException;
import java.util.List;

public class Order {
    private List<Dish> dishes;
    private Tablet tablet;

    public Order(Tablet tablet) throws IOException {
        this.dishes = ConsoleHelper.getAllDishesForOrder();
        this.tablet = tablet;
    }

    @Override
    public String toString()
    {
        return dishes.isEmpty() ? "" : String.format("Your order: %s of %s", dishes, tablet);
    }

    public int getTotalCookingTime(){
        int count = 0;
        for (Dish  d : dishes){
            count += d.getDuration();
        }
        return count;
    }

    public boolean isEmpty() {
        return dishes.isEmpty();
    }
}
