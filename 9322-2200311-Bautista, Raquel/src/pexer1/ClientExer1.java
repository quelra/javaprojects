package pexer1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientExer1 {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        int port = 2000;
        try (
// you may replace "localhost" with ip address of server
                Socket socket = new Socket("localhost", port);
                BufferedReader streamRdr = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));
                PrintWriter streamWtr = new PrintWriter(
                        socket.getOutputStream(), true);
        ) {

            BufferedReader br = new BufferedReader(new FileReader("res/exer1.dat"));
            String[] data = new String[3];
            String line = br.readLine();
            String input;

            while(line!=null){
                data = line.split(" ");
                // read and print message from server (ask: client name)
                System.out.println(streamRdr.readLine());
                input = data[0] + " " + data [1];
                // send input to the server
                streamWtr.println(input);
                System.out.println(streamRdr.readLine());

                // read and print message from server (ask: client age)
                System.out.println(streamRdr.readLine());
                input = data[2];
                // send input to server
                streamWtr.println(input);
                System.out.println(streamRdr.readLine());
                // read and print server response (can or cannot vote)
                System.out.println(streamRdr.readLine());
                System.out.println(streamRdr.readLine());
                line = br.readLine();
            }
            input = "bye!";
            streamWtr.println(input);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    }
    