package org.example;

import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Runnable runnable = () -> System.out.println(ThreadLocalRandom.current().nextInt(100));
        for (int i = 0; i < 10; i++) {
            runnable.run();
        }

        Function<String, Integer> stringLengthExtractor = (str) -> {
            return str.length();
        };
        System.out.println(stringLengthExtractor.apply("hello"));
    }
}