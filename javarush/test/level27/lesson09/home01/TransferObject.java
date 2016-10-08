package com.javarush.test.level27.lesson09.home01;

public class TransferObject {
    private int value;
    protected volatile boolean isValuePresent = false; //use this variable

    public synchronized int get() {
        if (!isValuePresent) {
            try {
                this.wait();
            } catch (Exception e){}
        }
        System.out.println("Got: " + value);
        isValuePresent = false;
        this.notify();
        return value;
    }

    public synchronized void put(int value)
    {
        if (isValuePresent) {
            try {
                this.wait();
            } catch (Exception e){}
        }

        this.value = value;
        isValuePresent = true;
        System.out.println("Put: " + value);
        this.notify();

    }
}
