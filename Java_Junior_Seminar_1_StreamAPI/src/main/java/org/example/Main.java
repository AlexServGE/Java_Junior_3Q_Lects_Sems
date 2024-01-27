package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toCollection;

public class Main {
    public static void main(String[] args) {
        List<Product> products = generateRandomProducts();

        Stream<Product> mystream1 = products.stream();
        Stream<Integer> mystream2 = Arrays.stream(new Integer[]{1,2,3,4});
        Stream<Integer> mystream3 = Stream.of(1,2,3,4);

        ArrayList<Product> productCollection = products.stream().collect(Collectors.toCollection(ArrayList::new));
        System.out.println(productCollection);

        List<Product> existingCollection = new ArrayList<>();
        products.stream().collect(Collectors.toCollection(()->existingCollection));

        Stream<Product> originalStream = products.stream();
        Stream<Product> electronicsStream = products.stream()
                .filter(product -> product.getCategory().equals("Электроника"));
        Stream<Product> lowCostElectronicsStream = products.stream()
                .filter(product -> product.getCost() < 10);

        lowCostElectronicsStream.forEach(product -> System.out.println(product));

        products.stream()
                .filter(product -> product.getCost() < 10) //промежуточна операция
                .filter(product -> product.getCategory().equals("Электроника"))
                .forEach(product -> System.out.println(product)); //терминальная операция

        products.stream()
                .filter(product -> product.getCost() < 10 && product.getCategory().equals("Электроника")) //промежуточна операция
                .forEach(product -> System.out.println(product)); //терминальная операция


    }

    private static List<Product> generateRandomProducts() {
        return List.of(
                new Product("Молоко", 70, "Продукты"),
                new Product("Хлеб", 54, "Продукты"),
                new Product("Компьютер", 70, "Продукты"),
                new Product("Наушники", 1, "Электроника"),
                new Product("Клавиатура", 5, "Продукты")
        );
    }

    static class Product {
        private final String name;
        private int cost;
        private String category;

        public Product(String name, int cost, String category) {
            this.name = name;
            this.cost = cost;
            this.category = category;
        }

        public String getName() {
            return name;
        }

        public int getCost() {
            return cost;
        }

        public String getCategory() {
            return category;
        }

        public void setCost(int cost) {
            this.cost = cost;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        @Override
        public String toString() {
            return String.format("[%s] (cost = %s, category = %s)", name, cost, category);
        }
    }
}