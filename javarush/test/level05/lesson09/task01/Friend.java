package com.javarush.test.level05.lesson09.task01;

/* Создать класс Friend
Создать класс Friend (друг) с тремя конструкторами:
- Имя
- Имя, возраст
- Имя, возраст, пол
*/

public class Friend
{
    //напишите тут ваш код
    private String frend;

    public Friend(String name) {
        this.frend = name;
    }

    public Friend(String name, int age){
        this.frend = frend + age;
    }

    public Friend(String name, int age, String sex) {
        this.frend = frend + sex;
    }

}