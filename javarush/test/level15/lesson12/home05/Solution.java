package com.javarush.test.level15.lesson12.home05;

/* Перегрузка конструкторов
1. В классе Solution создайте по 3 конструктора для каждого модификатора доступа.
2. В отдельном файле унаследуйте класс SubSolution от класса Solution.
3. Внутри класса SubSolution создайте конструкторы командой Alt+Insert -> Constructors.
4. Исправьте модификаторы доступа конструкторов в SubSolution так, чтобы они соответствовали конструкторам класса Solution.
*/

public class Solution {

    Solution(){}
    Solution(Integer integer){}
    Solution(int i){}

    public Solution(char c){}
    public Solution(Character character){}
    public Solution(Solution solution){}

    protected Solution(String s){}
    protected Solution(boolean b){}
    protected Solution(byte b){}

    private Solution(float f){}
    private Solution(long l){}
    private Solution(double d){}
}

