package serverclient;

import java.io.*;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ClientHandler extends Thread {

    private Socket socket;
    private DateTimeFormatter formatter;

    public ClientHandler(Socket socket,
                         DateTimeFormatter formatter) {

        this.socket = socket;
        this.formatter = formatter;
    }

    @Override
    public void run() {

        try {

            BufferedReader input =
                    new BufferedReader(
                            new InputStreamReader(
                                    socket.getInputStream()));

            PrintWriter output =
                    new PrintWriter(
                            socket.getOutputStream(), true);

            String message = input.readLine();

            System.out.println("Message Received : " + message);

            output.println("Hello Client! Message received.");

            String disconnectTime =
                    LocalDateTime.now().format(formatter);

            System.out.println("--------------------------------------");
            System.out.println(" Client Disconnected");
            System.out.println(" IP Address : "
                    + socket.getInetAddress().getHostAddress());
            System.out.println(" Disconnected At : "
                    + disconnectTime);
            System.out.println("--------------------------------------");

            socket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}