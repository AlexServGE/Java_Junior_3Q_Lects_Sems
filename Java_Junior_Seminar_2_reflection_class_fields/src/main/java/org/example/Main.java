package org.example;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws NoSuchFieldException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<Person> personClass = Person.class;
        Constructor<Person> constructor = personClass.getDeclaredConstructor(String.class, int.class);
        Person Igor = constructor.newInstance("Igor", 20);

        //Field

        Field age = personClass.getDeclaredField("age"); //обращаемся к private полю
        age.setInt(Igor, 10);
        System.out.println(Igor);

        Field name = personClass.getDeclaredField("name"); //обращаемся к private final полю
        name.setAccessible(true);
        name.set(Igor,"Sasha");
        System.out.println(Igor);

        //Method

        Method toStringMethod = personClass.getDeclaredMethod("toString");
        String toStringResult = (String) toStringMethod.invoke(Igor);
        System.out.println(toStringResult);

        Method randomPersonMethod = personClass.getDeclaredMethod("randomPerson");
        Person randomPerson = (Person) randomPersonMethod.invoke(null);
        System.out.println(randomPerson);

    }

    public static class Person {
        private static long counter = 1L;
        private final String name;
        private int age;

        private Person(String name) {
            this(name, 20);
        }

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public static Person randomPerson(){
            return new Person("Person #" + counter++);
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}