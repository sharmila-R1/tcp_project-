package serverclient;

import java.io.*;
import java.net.*;

public class ClientHandler extends Thread {

    private Socket socket;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {

        try {

            System.out.println("Client Connected: " + socket.getInetAddress());

            BufferedReader input = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            PrintWriter output = new PrintWriter(
                    socket.getOutputStream(), true);

            String message = input.readLine();

            System.out.println("Client: " + message);

            output.println("Hello Client! Message received.");

            socket.close();

            System.out.println("Client disconnected.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}