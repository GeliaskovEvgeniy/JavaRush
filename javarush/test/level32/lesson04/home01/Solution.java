package com.javarush.test.level32.lesson04.home01;

import java.io.*;
import java.util.Scanner;

/* Читаем из потока
Реализуйте логику метода getAllDataFromInputStream. Он должен вернуть StringWriter, содержащий все данные из переданного потока.
Возвращаемый объект ни при каких условиях не должен быть null.
Метод main не участвует в тестировании.
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        StringWriter writer = getAllDataFromInputStream(new FileInputStream("q"));
        System.out.println(writer.toString());
    }

    public static StringWriter getAllDataFromInputStream(InputStream is) throws IOException {
        StringWriter writer = new StringWriter();
        if (is != null) {
            Scanner scanner = new Scanner(is);
            while (scanner.hasNext()) {
                writer.write(scanner.nextLine() + "\n");
            }
            scanner.close();
        }
        return writer;
    }
}
