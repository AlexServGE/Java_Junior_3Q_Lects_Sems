package org.example;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Function;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {

        List<String> strings = new ArrayList<>(List.of("python", "java", "c#"));
        Comparator<String> comparison = Main::myComparator;
        strings.sort(comparison);
        System.out.println(strings);


        Function<String, Integer> myfunc = Main::extractStringLength;
        System.out.println(myfunc.apply("hello"));

        Runnable myRun = Main::printRandomNumberLessThan100;
        myRun.run();

        //специфическое поведение референс-метода
        Function<String, Integer> stringLengthExtractor = String::length; //передаем в лямбду apply метод length c входящей переменной
        System.out.println(stringLengthExtractor.apply("hello")); //однако метод length не принимает взодных параметров
        //вывод: если лямбда не наход входной параметр в передаваемом референс-методе, то она подставляем входной параметр вместо имени класса (в данном случае String)

        Supplier<Integer> javaLengthGetter = "java"::length; //пример реализации анонимного класса через референс-метод с прямым указанием входного параметра
        System.out.println(javaLengthGetter.get());

        Supplier<Person> personGenerator = Person::new;
        System.out.println(personGenerator.get());

        Function<String, Person> personWithNameGenerator = Person::new;
        System.out.println(personWithNameGenerator.apply("Петя"));
    }

    static int myComparator(String a, String b) {
        return a.length() - b.length();
    }

    static Integer extractStringLength(String arg) {
        return arg.length();
    }

    static void printRandomNumberLessThan100() {
        System.out.println(ThreadLocalRandom.current().nextInt(100));
    }

    public static class Person {
        public static Long counter = 1L;
        public String name;

        public Person() {
            this.name = "Person #" + counter++;
        }

        public Person(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }
}