package pexam;

import java.net.InetSocketAddress;
import java.net.Socket;


public class RBautista1 {
    public static void main(String[] args){
        String hostname = "localhost";
        try{
            int port = 1;

            while (port <= 1024){

                try {
                    Socket socket = new Socket();
                    socket.connect(new InetSocketAddress(hostname, port), 200);
                    socket.close();
                    System.out.println(hostname + ": " + port + " is open.");
                } catch (Exception ignored) {
                    //close
                }
                port++;
            }

        } catch (Exception e2){
            System.out.println("An error has occured.");
            e2.printStackTrace();
        }
    }


}
