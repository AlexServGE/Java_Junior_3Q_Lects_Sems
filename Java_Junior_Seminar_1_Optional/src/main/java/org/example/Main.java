package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        List<String> myList = new ArrayList<>(List.of("Саша", "Ваня", "Сережа", "Гоша"));
        Optional<String> result = myList.stream().filter(x -> x.startsWith("Са")).findFirst();

        result.ifPresentOrElse(System.out::println, () -> System.out.println("Error"));
        result.ifPresent(System.out::println);
        System.out.println(result.isEmpty());

        String nameWithSa = result.orElse("Ничего не нашёл");
        System.out.println(nameWithSa);

    }
}