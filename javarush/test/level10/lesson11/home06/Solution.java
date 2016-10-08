package com.javarush.test.level10.lesson11.home06;

/* Конструкторы класса Human
Напиши класс Human с 6 полями. Придумай и реализуй 10 различных конструкторов для него. Каждый конструктор должен иметь смысл.
*/

public class Solution
{
    public static void main(String[] args)
    {

    }

    public static class Human
    {
        //напишите тут ваши переменные и конструкторы
        String name;
        int age;
        boolean sex;
        String addres;
        int rost;
        int ves;

        public Human(String name) {
            this.name = name;
        }

        public Human(String name, boolean sex) {
            this.name = name;
            this.sex = sex;
        }

        public Human(String name, boolean sex, String addres) {
            this.name = name;
            this.sex = sex;
            this.addres = addres;
        }

        public Human(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public Human(String name, int age, boolean sex, int rost, int ves) {
            this.name = name;
            this.age = age;
            this.sex = sex;
            this.rost = rost;
            this.ves = ves;
        }

        public Human(String name, int age, boolean sex, int rost, int ves, String addres) {
            this.name = name;
            this.age = age;
            this.sex = sex;
            this.rost = rost;
            this.ves = ves;
            this.addres = addres;
        }

        public Human(boolean sex, String addres) {
            this.addres = addres;
            this.sex = sex;
        }

        public Human(int age, boolean sex, int rost, int ves) {
            this.age = age;
            this.sex = sex;
            this.rost = rost;
            this.ves = ves;
        }

        public Human(boolean sex, int rost, int ves) {
            this.sex = sex;
            this.rost = rost;
            this.ves = ves;
        }

        public Human(String name, int age, boolean sex, int rost, String addres) {
            this.name = name;
            this.age = age;
            this.sex = sex;
            this.rost = rost;
            this.addres = addres;
        }

    }
}
