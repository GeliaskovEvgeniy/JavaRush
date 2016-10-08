package com.javarush.test.level08.lesson11.home06;

/* Вся семья в сборе
1. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
3. Вывести все объекты Human на экран.
*/

import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args)
    {
        //напишите тут ваш код
        ArrayList<Human> child = new ArrayList<>();


        Human d1 = new Human("A", true, 2);
        System.out.println(d1);
        Human d2 = new Human("B", false, 6);
        System.out.println(d2);
        Human d3 = new Human("C", false, 4);
        System.out.println(d3);
        child.add(d1);
        child.add(d2);
        child.add(d3);
        Human father = new Human("Sem", true, 31, child );
        System.out.println(father);
        Human mather = new Human("Zoy", false, 29, child);
        System.out.println(mather);
        child.remove(0);
        child.remove(0);
        child.remove(0);
        child.add(father);
        Human ded = new Human("Tom", true, 84, child);
        System.out.println(ded);
        Human baba = new Human("Poly", false, 75, child);
        System.out.println(baba);
        child.remove(0);
        child.add(mather);
        Human ded2 = new Human("Roy", true, 56, child);
        System.out.println(ded2);
        Human baba2 = new Human("Raiy", false, 51, child);
        System.out.println(baba2);

    }

    public static class Human
    {
        //напишите тут ваш код
        String name;
        boolean sex;
        int age;
        ArrayList<Human> children = new ArrayList<>();

        public Human(String name, boolean sex, int age) {
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        public Human(String name, boolean sex, int age, ArrayList<Human> children) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children = children;
        }

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0)
            {
                text += ", дети: "+this.children.get(0).name;

                for (int i = 1; i < childCount; i++)
                {
                    Human child = this.children.get(i);
                    text += ", "+child.name;
                }
            }

            return text;
        }
    }

}
