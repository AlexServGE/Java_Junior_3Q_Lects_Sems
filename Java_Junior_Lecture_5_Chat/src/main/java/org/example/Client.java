package org.example;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

import java.util.Scanner;

/**
 * Client имеет метод main
 * Он имеет два потока, чтобы использовать консоль для печати и получения сообщений.
 * @sendMessage()
 * @listenForMessage()
 */

public class Client {

    private Socket socket;
    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;
    private String name;

    public Client(Socket socket, String userName) {
        this.socket = socket;
        this.name = userName;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        } catch (IOException e) {
            closeEverything(this.socket, bufferedReader, bufferedWriter);
        }
    }

    public void sendMessage(){
        try {
            bufferedWriter.write(this.name); //Перед началом чата отправляет всем имя нового пользователя
            bufferedWriter.newLine();
            bufferedWriter.flush();

            Scanner scanner = new Scanner(System.in); //Scanner начинает принимать новые сообщения
            while (socket.isConnected()) {
                String message = scanner.nextLine();
                bufferedWriter.write(this.name + ": " + message);
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }
        } catch (IOException e) {
            closeEverything(this.socket, bufferedReader, bufferedWriter);
        }
    }

    public void listenForMessage(){
        new Thread(new Runnable() { //отдельный поток необходим, так как Scanner не будет давать получать сообщения
            @Override
            public void run() {
                String messageFromGroup;
                while(socket.isConnected()){
                    try{
                        messageFromGroup = bufferedReader.readLine();
                        System.out.println(messageFromGroup);
                    } catch (IOException e) {
                        closeEverything(socket, bufferedReader, bufferedWriter);
                    }
                }
            }
        }).start();
    }

    private void closeEverything(Socket socket, BufferedReader bufferedReader, BufferedWriter bufferedWriter) {
        try {
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            if (bufferedWriter != null) {
                bufferedWriter.close();
            }
            if (socket != null) {
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите своё имя:");
        String name = scanner.nextLine();
        Socket socket = new Socket(InetAddress.getLocalHost(),1300);
        Client client = new Client(socket, name);
        client.listenForMessage();
        client.sendMessage();
    }
}
