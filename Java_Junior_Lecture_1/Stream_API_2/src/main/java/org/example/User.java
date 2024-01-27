package org.example;

public class User {
    String name;
    int age;

    {
        this.name = "Random";
        this.age = 10;
    }

    public User() {
    }

    public User(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
