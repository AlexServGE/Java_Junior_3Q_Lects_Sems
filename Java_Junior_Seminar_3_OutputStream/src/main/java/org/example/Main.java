package org.example;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class Main {
    public static void main(String[] args) throws IOException {
        //Получаем путь к файлу "myfile.txt". Можно также использовать Paths.get(<String>)
        Path myFileToWrite = Path.of("myfile.txt");
        //Получаем OutputStream через Files.newOutputStream(<Path>) или Files.newOutputStream(<Path>, StandardOpenOption.APPEND).
        // Можно также использовать Files.write(<Path>, <List<String>>)
        OutputStream myFileToWriteOutputStream = Files.newOutputStream(myFileToWrite, StandardOpenOption.APPEND);
        //Записываем строку, переведя ее в массив byte[]
        myFileToWriteOutputStream.write("Hello, my name is Alex".getBytes());
        myFileToWriteOutputStream.close();
    }
}