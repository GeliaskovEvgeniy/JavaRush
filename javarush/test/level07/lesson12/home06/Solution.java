package com.javarush.test.level07.lesson12.home06;

/* Семья
Создай класс Human с полями имя(String), пол(boolean),возраст(int), отец(Human), мать(Human).
Создай объекты и заполни их так, чтобы получилось: Два дедушки, две бабушки, отец, мать, трое детей. Вывести объекты на экран.
Примечание:
Если написать свой метод String toString() в классе Human, то именно он будет использоваться при выводе объекта на экран.
Пример вывода:
Имя: Аня, пол: женский, возраст: 21, отец: Павел, мать: Катя
Имя: Катя, пол: женский, возраст: 55
Имя: Игорь, пол: мужской, возраст: 2, отец: Михаил, мать: Аня
…
*/

public class Solution
{
    public static void main(String[] args)
    {
        //напишите тут ваш код
        Human ded = new Human("Bob",true, 81, null, null);
        System.out.println(ded);

        Human ded2 = new Human("Roy", true, 74, null, null);
        System.out.println(ded2);

        Human baba = new Human("Poli", false, 68, null, null);
        System.out.println(baba);

        Human baba2 = new Human("Bety", false, 67, null,null);
        System.out.println(baba2);

        Human father = new Human("Pol", true, 41, ded, baba);
        System.out.println(father);

        Human mother = new Human("Susy", false, 38, ded2, baba2);
        System.out.println(mother);

        Human child1 = new Human("Katy", false, 3, father, mother);
        System.out.println(child1);

        Human child2 = new Human("Vasiy", true, 6, father, mother);
        System.out.println(child2);

        Human child3 = new Human("Aniy", false, 12, father, mother);
        System.out.println(child3);

    }

    public static class Human
    {
        //напишите тут ваш код
        String name;
        boolean sex;
        int age;
        Human father;
        Human mother;

        public  Human(String name, boolean sex, int age, Human father, Human mother) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;
        }

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }

}
