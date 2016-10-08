package com.javarush.test.level21.lesson05.task03;

import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/* Ошибка в equals/hashCode
Исправьте ошибки реализаций методов equals и hashCode для класса Solution
*/
public class Solution {
    private int anInt;
    private String string;
    private double aDouble;
    private Date date;
    private Solution solution;

    public static void main(String[] args)
    {
        Set<Solution> s = new HashSet<>();
        Date date = new Date();
        Solution sol = new Solution();
        Solution solution = new Solution(21, "asd", 3.2, date, sol);
        s.add(solution);
        System.out.println(s.contains(new Solution(21, "asd", 3.2, date, sol)));
    }

    public Solution() {}

    public Solution(int anInt, String string, double aDouble, Date date, Solution solution) {
        this.anInt = anInt;
        this.string = string;
        this.aDouble = aDouble;
        this.date = date;
        this.solution = solution;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Solution solution1 = (Solution) o;
        return anInt == solution1.anInt &&
                Double.compare(solution1.aDouble, aDouble) == 0 &&
                Objects.equals(string, solution1.string) &&
                Objects.equals(date, solution1.date) &&
                Objects.equals(solution, solution1.solution);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(anInt, string, aDouble, date, solution);
    }
}
