package com.javarush.test.level05.lesson07.task03;

/* Создать класс Dog
Создать класс Dog (собака) с тремя инициализаторами:
- Имя
- Имя, рост
- Имя, рост, цвет
*/

public class Dog
{
    //напишите тут ваш код
    private String dog;

    public void initialize(String name) {
        this.dog = name;
    }

    public void initialize(String name, int rost) {
        this.dog = dog + rost;
    }

    public void initialize(String name, int rost, String color) {
        this.dog = dog + color;
    }

}
