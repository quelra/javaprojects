package pexam;

import java.net.InetSocketAddress;
import java.net.Socket;

public class Callable implements java.util.concurrent.Callable {
    String hostname;
    int port;

    Callable(String host, int port){
        hostname = host;
        this.port = port;
    }

    @Override
    public Object call() throws Exception {
        try {
            Socket socket = new Socket();
            socket.connect(new InetSocketAddress(hostname, port), 200);
            socket.close();
            System.out.println(hostname + ": " + port + " is open.");
            return  true;
        } catch (Exception ignored) {
            return false;
        }
    }
}
