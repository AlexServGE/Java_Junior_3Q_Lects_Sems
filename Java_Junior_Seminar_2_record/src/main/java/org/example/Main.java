package org.example;


public class Main {
    record MyRecord(int x, int y) {

    }

    public static void main(String[] args) {
        MyRecord myRecord = new MyRecord(2, 3);
        int x = myRecord.x();
        int y = myRecord.y();
        System.out.println(myRecord);
    }

}