package com.javarush.test.level05.lesson07.task04;

/* Создать класс Circle
Создать класс (Circle) круг, с тремя инициализаторами:
- centerX, centerY, radius
- centerX, centerY, radius, width
- centerX, centerY, radius, width, color
*/

public class Circle
{
    //напишите тут ваш код
    private int circule = 0;
    private String color = null;

    public void initialize(int centerX, int centerY, int radius){
        this.circule = centerX + centerY + radius;
    }
    public void initialize(int centerX, int centerY, int radius, int width){
        this.circule = circule + width;
    }
    public void initialize(int centerX, int centerY, int radius, int width, String color){
        this.color = color;
    }

}
