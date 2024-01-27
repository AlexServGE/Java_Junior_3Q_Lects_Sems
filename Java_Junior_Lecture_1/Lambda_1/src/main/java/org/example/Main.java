package org.example;

public class Main {
    public static void main(String[] args) {

        PlainInterface plainInterface = Integer::sum;
        PlainInterface plainInterface1 = Integer::compare;

        System.out.println(plainInterface.action(5,3));
        System.out.println(plainInterface1.action(5,3));
    }
}