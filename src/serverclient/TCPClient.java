package serverclient;

import java.io.*;
import java.net.*;

public class TCPClient {

    public static void main(String[] args) {

        try {

            Socket socket = new Socket("192.168.1.170", 5000);

            BufferedReader input = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            PrintWriter output = new PrintWriter(
                    socket.getOutputStream(), true);

            output.println("Hello Server!");

            String response = input.readLine();

            System.out.println("Server: " + response);

            socket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}