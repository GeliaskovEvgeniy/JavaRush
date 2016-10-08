package com.javarush.test.level19.lesson03.task04;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

/* И еще один адаптер
Адаптировать Scanner к PersonScanner.
Классом-адаптером является PersonScannerAdapter.
Данные в файле хранятся в следующем виде:
Иванов Иван Иванович 31 12 1950

В файле хранится большое количество людей, данные одного человека находятся в одной строке. Метод read() должен читать данные одного человека.
*/

public class Solution {

    public static void main(String[] args) throws IOException, ParseException
    {
        Scanner scanner = new Scanner(new FileReader("a"));
        PersonScannerAdapter psa = new PersonScannerAdapter(scanner);
        while (scanner.hasNext()) {
            Person person = psa.read();
            System.out.println(person.toString());
        }
        psa.close();
        scanner.close();
    }

    public static class PersonScannerAdapter implements PersonScanner{

        private Scanner scanner;

        public PersonScannerAdapter(Scanner scanner) {
            this.scanner = scanner;
        }

        @Override
        public Person read() throws IOException, ParseException
        {
            String s = scanner.nextLine();
            String[] arr = s.split(" ");
            String ss = arr[3] + "-" + arr[4] + "-" + arr[5];
            SimpleDateFormat dat = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
            Date d = dat.parse(ss);
            return new Person(arr[0], arr[1], arr[2], d);
        }

        @Override
        public void close() throws IOException {
            scanner.close();
        }
    }
}
