package pquiz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandler implements Runnable {
    private Socket client;
    private BufferedReader streamRdr;
    private PrintWriter streamWtr;


    ClientHandler(Socket clienSocket) throws IOException {
        this.client = clienSocket;
        streamRdr = new BufferedReader(new InputStreamReader(clienSocket.getInputStream()));
        streamWtr = new PrintWriter(clienSocket.getOutputStream(), true);
    }

    @Override
    public void run() {
        try{
            String toSend = "";
            do {
                String string = streamRdr.readLine(); // a. wait for the string
                int noSpaces = 0;

                for (int i = 0; i < string.length(); i++) {
                    if (' ' == string.charAt(i)) {
                        noSpaces++;
                    }
                }

                if (noSpaces == 0) {
                    streamWtr.println("zero"); //send first
                    toSend = "zero";
                } else if (noSpaces % 2 == 0) {
                    toSend = "even";
                    streamWtr.println(toSend);
                } else {
                    toSend = "odd";
                    streamWtr.println(toSend);
                }
            } while(!toSend.equals("zero"));

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
