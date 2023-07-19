package pexam;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RBautista2 {
    public static void main(String[] args) throws IOException {
        String hostname = "localhost";
        int port = 1;

        ArrayList<Callable> clients = new ArrayList<>();
        ExecutorService pool = Executors.newFixedThreadPool(20);

        while(port<=1024){
            Callable clientThread = new Callable(hostname, port);
            clients.add(clientThread);
            pool.submit(clientThread);
            port++;
        }

    }
}
