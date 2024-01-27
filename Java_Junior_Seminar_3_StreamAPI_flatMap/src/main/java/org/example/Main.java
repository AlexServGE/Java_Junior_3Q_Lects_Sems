package org.example;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<String> langs = List.of("java", "C#", "python");

//        List<String> langs2 = langs.stream().
//                map(it -> Arrays.stream(it.toCharArray())).collect(Collectors.toList());


        List<String> myChars2 = langs.stream().
                flatMap(it -> it.chars().boxed()).map(Character::toString).
                toList();

        System.out.println(myChars2);

        List<String> myStringList = IntStream.range(0,10).mapToObj(it -> "hello"+it).collect(Collectors.toCollection(ArrayList::new));

    }
}