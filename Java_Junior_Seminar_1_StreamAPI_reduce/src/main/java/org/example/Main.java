package org.example;

import java.util.Arrays;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 5);

        Integer sum = numbers.stream()
                .reduce(10, (left, right) -> left + right);

        System.out.println(sum); //output 11

        List<Integer> numbers2 = Arrays.asList(1, 2, 3);

        // 1*10 + 2*10 + 3*10
        Integer sum2 = numbers2.stream()
                .reduce(10, (identity, val) -> identity * val, (left, right) -> left + right);

        System.out.println(sum2); //output 60
    }
}