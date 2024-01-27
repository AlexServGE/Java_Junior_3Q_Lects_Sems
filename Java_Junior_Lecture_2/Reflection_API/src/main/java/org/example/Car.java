package org.example;

public class Car {
    public String name;
    private String price;
    private String engType;
    private String engPower;
    public int maxSpeed;

    public Car(String name) {
        this.name = name;
        this.price = "1000000";
        this.engType = "V8";
        this.engPower = "123";
        this.maxSpeed = 100;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getEngType() {
        return engType;
    }

    public String getEngPower() {
        return engPower;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", maxSpeed=" + maxSpeed +
                '}';
    }
}
