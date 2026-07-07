package serverclient;

import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TCPServer {

    public static void main(String[] args) {

        try {

            ServerSocket serverSocket = new ServerSocket(5000);

            DateTimeFormatter formatter =
                    DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

            System.out.println("======================================");
            System.out.println(" TCP Server Started");
            System.out.println(" Port : 5000");
            System.out.println(" Waiting for clients...");
            System.out.println("======================================");

            while (true) {

                Socket socket = serverSocket.accept();

                String connectTime =
                        LocalDateTime.now().format(formatter);

                System.out.println("=================================");
                System.out.println("Client Connected");
                System.out.println("Client IP      : " + socket.getInetAddress().getHostAddress());
                System.out.println("Client Port    : " + socket.getPort());
                System.out.println("Server IP      : " + socket.getLocalAddress().getHostAddress());
                System.out.println("Server Port    : " + socket.getLocalPort());
                System.out.println("=================================");

                ClientHandler handler =
                        new ClientHandler(socket, formatter);

                handler.start();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}