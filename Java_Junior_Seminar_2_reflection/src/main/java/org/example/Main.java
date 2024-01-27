package org.example;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {


        Class<Person> personClass = Person.class;

        Constructor<Person> constructor2 = personClass.getConstructor(String.class, int.class);
        Person personViaReflection2 = constructor2.newInstance("Igor", 20);
        System.out.println(personViaReflection2);

        Constructor<Person> constructor = personClass.getDeclaredConstructor(String.class);
        constructor.setAccessible(true);
        Person personViaReflection = constructor.newInstance("Igor");
        System.out.println(personViaReflection);

        Constructor<? super Head> constructorPerson = Head.class.getSuperclass().getDeclaredConstructor(String.class);
        constructorPerson.setAccessible(true);
        Object dasha = constructorPerson.newInstance("Dasha");
        System.out.println(dasha);
    }
}