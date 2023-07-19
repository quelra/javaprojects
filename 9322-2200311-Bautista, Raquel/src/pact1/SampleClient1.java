package pact1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
public class SampleClient1 {
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
// read and print message from server (ask: client name)
            System.out.print(streamRdr.readLine());
            String input = keyboard.nextLine();
// send input to the server
            streamWtr.println(input);
// read and print message from server (ask: client age)
            System.out.print(streamRdr.readLine());
            input = keyboard.nextLine();
// send input to server
            streamWtr.println(input);
// read and print server response (can or cannot vote)
            System.out.println(streamRdr.readLine());
// read and print closing message from server
            System.out.println(streamRdr.readLine());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
