package pexer1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerExer1 {
        public static void main(String[] args) {
            int port = 2000;
            try (
                    ServerSocket serverSocket = new ServerSocket(port);
                    Socket clientSocket = serverSocket.accept();
                    BufferedReader streamRdr = new BufferedReader(
                            new InputStreamReader(clientSocket.getInputStream()));
                    PrintWriter streamWtr = new PrintWriter(
                            clientSocket.getOutputStream(), true);
            ) {
                String name;
                do{
                    // server sends message to client
                    streamWtr.println("What is your name? ");
                    // server accepts input from client
                    name = streamRdr.readLine();
                    streamWtr.println(name);
                    int age;
                    while (true) {
                        streamWtr.println("What is your age? ");
                        try {
                            age = Integer.parseInt(streamRdr.readLine());
                            streamWtr.println(age);
                            if (age <= 0) {
                                throw new NumberFormatException();
                            } else {
                                break;
                            }
                        } catch (NumberFormatException nfe) {
                            // println method will auto flush
                            streamWtr.println("Please enter a valid age.");
                            continue;
                        }

                    }
                    if (age >= 18) {
                        streamWtr.println(name +
                                ", you may exercise your right to vote!");
                    } else {
                        streamWtr.println(name +
                                ", you are still too young to vote!");
                    }
                    streamWtr.println();
                }while(!name.equals("bye!"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

}
