package org.example;

import lombok.Getter;

import java.lang.reflect.Field;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws NoSuchFieldException {
        MyClass myClass = new MyClass();
        System.out.println(myClass.getNegative());
        System.out.println(myClass.getPositive());

        RandomIntegerProcessor.processObject(myClass);
        System.out.println(myClass.getNegative());
        System.out.println(myClass.getPositive());

        System.out.println("------");

        //получение доступа к аннотации поля через рефлексию
        Field valueField = myClass.getClass().getDeclaredField("negative");
        RandomInteger annotation = valueField.getAnnotation(RandomInteger.class);
        System.out.println(annotation.minValue());
        System.out.println(annotation.maxValue());

        //проверяем существует ли аннотация RandomInteger annotation
        System.out.println(annotation == null);
    }

    @Getter
    static class MyClass {
        @RandomInteger(minValue = 0, maxValue = 10)
        private int positive;
        @RandomInteger(minValue = -10, maxValue = -1)
        private int negative;
    }
}