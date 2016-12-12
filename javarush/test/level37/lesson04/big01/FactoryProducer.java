package com.javarush.test.level37.lesson04.big01;

import com.javarush.test.level37.lesson04.big01.female.FemaleFactory;
import com.javarush.test.level37.lesson04.big01.male.MaleFactory;

public class FactoryProducer
{
    public static AbstractFactory getFactory(HumanFactoryType type){
        if (type.equals(HumanFactoryType.MALE)) {
            return new MaleFactory();
        }
        if (type.equals(HumanFactoryType.FEMALE))
            return new FemaleFactory();
        return null;
    }

    public enum HumanFactoryType {
        MALE, FEMALE;
    }
}
