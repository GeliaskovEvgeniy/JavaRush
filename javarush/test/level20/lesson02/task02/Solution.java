package com.javarush.test.level20.lesson02.task02;

import com.javarush.test.level14.lesson06.home01.Country;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* Читаем и пишем в файл: JavaRush
Реализуйте логику записи в файл и чтения из файла для класса JavaRush
В файле your_file_name.tmp может быть несколько объектов JavaRush
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream("a");
            InputStream inputStream = new FileInputStream("a");

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            User user = new User();
            user.setFirstName("firstName");
            user.setLastName("lastName");
            user.setBirthDate(new Date());
            user.setMale(true);
            user.setCountry(User.Country.UKRAINE);
            javaRush.users.add(user);
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject ра
            for (User u : loadedObject.users) {
                System.out.println(u.getFirstName());
                System.out.println(u.getLastName());
                System.out.println(u.getBirthDate());
                System.out.println(u.isMale());
                System.out.println(u.getCountry().getDisplayedName());
            }


            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter writer = new PrintWriter(outputStream);
            writer.println(users.size());
            for (User u : users) {
                writer.println(u.getFirstName() != null ? "yes" : "no");
                if (u.getFirstName() != null) writer.println(u.getFirstName());
                writer.println(u.getLastName() != null ? "yes" : "no");
                if (u.getLastName() != null) writer.println(u.getLastName());
                writer.println(u.getBirthDate() != null ? "yes" : "no");
                if (u.getBirthDate() != null) writer.println(new SimpleDateFormat("dd-MM-yyyy").format(u.getBirthDate()));
                writer.println(u.isMale());
                writer.println(u.getCountry() != null ? "yes" : "no");
                if (u.getCountry() != null) writer.println(u.getCountry().getDisplayedName());
            }
            writer.flush();
            writer.close();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            int usersSize = Integer.parseInt(reader.readLine());
            for (int i = 0; i < usersSize; i++) {

                users.add(new User());
                if (reader.readLine().equals("yes")) users.get(i).setFirstName(reader.readLine());
                if (reader.readLine().equals("yes")) users.get(i).setLastName(reader.readLine());
                if (reader.readLine().equals("yes")) users.get(i).setBirthDate(new SimpleDateFormat("dd-MM-yyyy").parse(reader.readLine()));
                users.get(i).setMale(reader.readLine().equals("true"));
                if (reader.readLine().equals("yes")) {
                    String s = reader.readLine();
                    switch (s) {
                        case "Ukraine" : users.get(i).setCountry(User.Country.UKRAINE); break;
                        case "Russia" : users.get(i).setCountry(User.Country.RUSSIA); break;
                        case "Other" : users.get(i).setCountry(User.Country.OTHER); break;
                    }

                }
            }
            reader.close();
        }
    }
}
