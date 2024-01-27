package org.example;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientExample2 {
    public static void main(String[] args) {
        try {
            InetAddress address = InetAddress.getLocalHost();
            try (Socket client = new Socket(address, 1300)) {

                System.out.println(client.getInetAddress());
                System.out.println(client.getLocalPort());

                InputStream inStream = client.getInputStream();
                OutputStream outStream = client.getOutputStream();

                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inStream));
                PrintStream printStream = new PrintStream(outStream);

                printStream.println("Привет, сервер!");
                System.out.println(bufferedReader.readLine());
            }
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}