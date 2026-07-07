package serverclient;

import java.net.*;

public class TCPServer {

    public static void main(String[] args) {

        try {

            ServerSocket serverSocket = new ServerSocket(5000);

            System.out.println("Server started...");
            System.out.println("Waiting for clients...");

            while (true) {

                Socket socket = serverSocket.accept();

                new ClientHandler(socket).start();

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}