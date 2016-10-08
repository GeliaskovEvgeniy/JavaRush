package com.javarush.test.level29.lesson15.big01.human;

import java.util.ArrayList;
import java.util.List;

public class University {

    private  String name;
    private  int age;
    private List<Student> students = new ArrayList<>();

    public University(String name, int age) {

        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Student> getStudents()
    {
        return students;
    }

    public void setStudents(List<Student> students)
    {
        this.students = students;
    }

    public Student getStudentWithAverageGrade(double averageGrade) {
        for (Student student : students) {
            if (student.getAverageGrade() == averageGrade){
                return student;
            }
        }
        return null;
    }

    public Student getStudentWithMaxAverageGrade() {
        Student maxAverageGrade = students.get(0);
        for (int i = 1; i < students.size(); i++) {
            if (students.get(i).getAverageGrade() > maxAverageGrade.getAverageGrade()) {
                maxAverageGrade = students.get(i);
            }
        }
        return maxAverageGrade;
    }

    public Student getStudentWithMinAverageGrade() {
        Student minAverageGrate = students.get(0);
        for (int i = 1; i < students.size(); i++) {
            if (students.get(i).getAverageGrade() < minAverageGrate.getAverageGrade()) {
                minAverageGrate = students.get(i);
            }
        }
        return minAverageGrate;
    }

    public void expel(Student student) {
        students.remove(student);
    }
}
