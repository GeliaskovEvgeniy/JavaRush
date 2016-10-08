package com.javarush.test.level05.lesson09.task02;

/* Создать класс Cat
Создать класс Cat (кот) с пятью конструкторами:
- Имя,
- Имя, вес, возраст
- Имя, возраст (вес стандартный)
- вес, цвет, (имя, адрес и возраст – неизвестные. Кот - бездомный)
- вес, цвет, адрес ( чужой домашний кот)
Задача конструктора – сделать объект валидным. Например, если вес не известен, то нужно указать какой-нибудь средний вес. Кот не может ничего не весить. То же касательно возраста. А вот имени может и не быть (null). То же касается адреса: null.
*/

public class Cat
{
    //напишите тут ваш код
    private String cat;

    public Cat(String name) {
        this.cat = name;
    }

    public Cat(String name, int ves, int age) {
        this.cat = cat + ves + age;
    }

    public Cat(String name, int age) {
        this.cat = cat +age;
    }

    public Cat(int ves, String color) {
        this.cat = cat + color;
    }

    public Cat(int ves, String color, String adres) {
        this.cat = cat + adres;
    }

}
