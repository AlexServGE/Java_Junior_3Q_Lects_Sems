package org.example;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientExample1 {
    public static void main(String[] args) {
        try {
            InetAddress address = InetAddress.getLocalHost();
            try (Socket socket = new Socket(address, 1300)) {
                InputStream inputStream = socket.getInputStream();
                System.out.println(new String(inputStream.readAllBytes()));
                inputStream.close();
            }
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}