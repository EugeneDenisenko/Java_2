package com.geekbrains.lesson6.homework;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    private static final int PORT = 8190;

    public static void main(String[] args) throws IOException {
        new Server().start(PORT);
    }

    public void start(int port) throws IOException {
        ServerSocket serverSocket = null;
        Socket clientSocket = null;
        Thread inputThread = null;

        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("Server запущен...");
            clientSocket = serverSocket.accept();
            System.out.println("Клиент подключился");

            DataInputStream inputStream = new DataInputStream(clientSocket.getInputStream());
            DataOutputStream outputStream = new DataOutputStream(clientSocket.getOutputStream());

            inputThread = runInputLoop(inputStream);
            runOutputLoop(outputStream);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputThread != null) {
                inputThread.interrupt();
            }
            if (clientSocket != null) {
                clientSocket.close();
            }
            if (serverSocket != null) {
                serverSocket.close();
            }
        }
    }

    private Thread runInputLoop(DataInputStream inputStream) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (!Thread.currentThread().isInterrupted()) {
                    try {
                        String message = inputStream.readUTF();
                        System.out.println("From client: " + message);
                        if (message.startsWith("/end")) {
                            System.exit(0);
                        }
                    } catch (IOException e) {
                        System.out.println("Подключение прервано");
                        System.exit(0);
                        break;
                    }
                }
            }
        });
        thread.start();
        return thread;
    }

    private void runOutputLoop(DataOutputStream outputStream) throws IOException {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String message = scanner.nextLine();
            if (message.startsWith("/end")) {
                break;
            }
            outputStream.writeUTF(message);
        }
    }
}
