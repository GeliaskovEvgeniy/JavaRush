package com.javarush.test.level15.lesson12.home05;


public class SubSolution extends Solution
{
    SubSolution()
    {
        super();
    }

    SubSolution(Integer integer)
    {
        super(integer);
    }

    SubSolution(int i)
    {
        super(i);
    }

    public SubSolution(char c)
    {
        super(c);
    }

    public SubSolution(Character character)
    {
        super(character);
    }

    public SubSolution(Solution solution)
    {
        super(solution);
    }

    protected SubSolution(String s)
    {
        super(s);
    }

    protected SubSolution(boolean b)
    {
        super(b);
    }

    protected SubSolution(byte b)
    {
        super(b);
    }

    private SubSolution(float f){}
    private SubSolution(long l){}
    private SubSolution(double d){}
}
