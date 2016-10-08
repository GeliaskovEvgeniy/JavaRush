package com.javarush.test.level20.lesson10.home03;

import java.io.*;

/* Найти ошибки
Почему-то при сериализации/десериализации объекта класса B возникают ошибки.
Найдите проблему и исправьте ее.
Класс A не должен реализовывать интерфейсы Serializable и Externalizable.
Сигнатура класса В не содержит ошибку :)
Метод main не участвует в тестировании.
*/
public class Solution implements Serializable{
    final static long serialVersionUID = 1L;
    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        Solution s = new Solution();
        B b2 = s.new B("sss");
        System.out.println(b2.name);
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("a"));
        oos.writeObject(b2);
        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("a"));
        B b1 = (B) ois.readObject();
        ois.close();

        System.out.println(b1.name);


    }

    public static class A {

        protected String name = "A";

        public A() {
        }

        public A(String name) {
            this.name += name;
        }
    }

    public class B extends A implements Serializable {
        public B(String name) {
            super(name);
            this.name += name;
        }
        private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
            s.defaultReadObject();
            name = (String)s.readObject();
        }
        private void writeObject(ObjectOutputStream s) throws IOException {
            s.defaultWriteObject();
            s.writeObject(this.name);
        }
    }
}
