package com.javarush.test.level21.lesson16.big01;

import java.util.ArrayList;

public class Hippodrome
{
    public static Hippodrome game;

    public static ArrayList<Horse> horses = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException
    {

        game = new Hippodrome();

        game.getHorses().add(new Horse("Срела", 3, 0));
        game.getHorses().add(new Horse("Ракета", 3, 0));
        game.getHorses().add(new Horse("Телега", 3, 0));
        game.run();
        game.printWinner();
    }

    public ArrayList<Horse> getHorses() {
        return horses;
    }

    public Horse getWinner() {
        Horse horse = getHorses().get(0);
        for (int i = 1; i < getHorses().size(); i++) {
            if (getHorses().get(i).getDistance() > horse.getDistance()) horse = getHorses().get(i);
        }
        return horse;
    }

    public void printWinner() {
        System.out.println(String.format("Winner is %s!", getWinner().getName()));
    }

    public void run() throws InterruptedException
    {
        for (int i = 0; i < 100; i++) {
            move();
            print();
            Thread.sleep(200);
        }
    }

    public void move() {
        for (Horse horse : getHorses()) {
            horse.move();
        }
    }

    public void print() {
        for (Horse horse : getHorses()) {
            horse.print();
        }
        System.out.println();
        System.out.println();
    }


}
