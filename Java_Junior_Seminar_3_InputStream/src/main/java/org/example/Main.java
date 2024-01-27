package org.example;


import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) throws IOException {
        //Получаем путь к файлу "build.gradle.kts". Можно также использовать Paths.get(<String>)
        Path pomPath = Path.of("build.gradle.kts");
        //Получаем InputStream через Files.newInputStream(<Path>). Можно также использовать Files.readAllLines(<Path>)
        InputStream pomInputStream = Files.newInputStream(pomPath);
        //Получаем int соответствующий коду прочитанного символа в кодировке, заданной в IDE (по умолчанию ASCII - латинский алфавит)
        int readOneByte = pomInputStream.read();
        //Печатаем int. Либо можем передать в String предварительно добавив в массив byte[] через каст int в byte - (byte) read
        System.out.println(readOneByte);
        //Получаем массив байт
        byte[] pomBytesRead = pomInputStream.readAllBytes();
        //Переводим байты в строку
        System.out.println(new String(pomBytesRead));
        //Закрываем поток
        pomInputStream.close();
    }
}