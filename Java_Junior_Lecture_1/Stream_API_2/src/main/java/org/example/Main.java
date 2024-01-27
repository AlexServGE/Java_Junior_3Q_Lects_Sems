package org.example;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.*;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Hello", "world", "finish");
//        list = list.stream().filter(x->x.length() > 5).collect(Collectors.toList());
        list.stream().filter(x -> x.length() > 5).forEach(System.out::println);
        for (String s : list) {
            System.out.println(s);
        }

        Arrays.asList(1, 2, 3, 4, 5).stream().map(chislo -> "число: " + chislo + " квадрат числа: " + chislo * chislo).forEach(System.out::println);
        System.out.println("------------------");
        Arrays.asList(1, 2, 5, 4, 3).stream().sorted().forEach(System.out::println);
        System.out.println("------------------");
        Arrays.asList(1, 2, 2, 4, 2).stream().sorted().distinct().forEach(System.out::println);
        System.out.println("------------------");
        System.out.println(Arrays.asList(1, 2, 2, 4, 2).stream().sorted().distinct().findFirst().get());
        System.out.println("------------------");
        List<User> usersList = Arrays.asList(new User(),new User(),new User());
        System.out.println(usersList);
        System.out.println("------------------");
        usersList.stream().map(user -> new User(user.age-5)).forEach(System.out::println);

    }
}