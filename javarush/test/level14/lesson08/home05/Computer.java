package com.javarush.test.level14.lesson08.home05;

/**
 * Created by 1 on 19.01.2016.
 */
public class Computer
{
    private  Keyboard keyboard;
    private  Mouse mouse;
    private  Monitor monitor;



    public Keyboard getKeyboard()
    {
        return keyboard;
    }

    public Mouse getMouse()
    {
        return mouse;
    }

    public Monitor getMonitor()
    {
        return monitor;
    }

    public Computer()
    {
        this.keyboard =  new getKeyboard();
        this.mouse = new getMouse();
        this.monitor = new getMonitor();
    }

    private class getKeyboard extends Keyboard
    {
    }

    private class getMouse extends Mouse
    {
    }

    private class getMonitor extends Monitor
    {
    }
}
