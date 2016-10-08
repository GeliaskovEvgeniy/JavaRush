package com.javarush.test.level05.lesson09.task03;

/* Создать класс Dog
Создать класс Dog (собака) с тремя конструкторами:
- Имя
- Имя, рост
- Имя, рост, цвет
*/

public class Dog
{
    //напишите тут ваш код
    private String dog;

    public Dog(String name) {
        this.dog = name;
    }

    public Dog(String name, int age) {
        this.dog = dog + age;
    }

    public Dog(String name, int age, String color) {
        this.dog = dog + color;
    }

}
