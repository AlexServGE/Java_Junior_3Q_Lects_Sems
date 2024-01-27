package org.example;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedInputStream bufferedInputStreamPom = new BufferedInputStream(Files.newInputStream(Path.of("build.gradle.kts")));
        byte[] bytesRead = bufferedInputStreamPom.readAllBytes();
        System.out.println(new String(bytesRead));
        bufferedInputStreamPom.close();

        ByteArrayOutputStream out = new ByteArrayOutputStream();

        for (int i = -127; i < 383; i =i+10) {
            out.write(i);
        }

//        out.write(1);
//        out.write(100);
//        out.write(0);
//        out.write(383);
//        out.write(127);


        ByteArrayInputStream in = new ByteArrayInputStream(out.toByteArray());
        int value;
        int j = 1;
        while ((value = in.read()) != -1) {
            System.out.println(j++ + " element is - " + value + ". If (byte)value - " + (byte) value);
        }
        in.close();
//        int value = in.read();
//        System.out.println("First element is - " + value);
//
//        value = in.read();
//        System.out.println("Second element is - " + value + ". If (char)value - " + (byte) value);
//
//        value = in.read();
//        System.out.println("Third element is - " + value);
//
//        value = in.read();
//        System.out.println("Fourth element is - " + value + ". If (byte)value - " + (byte) value);
//
//        value = in.read();
//        System.out.println("Fifth element is - " + value + ". If (byte)value - " + (byte) value);
    }
}