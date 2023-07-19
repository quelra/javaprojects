package pexam;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RBautista3 {
    private static final int PORT = 12007;
    private static final ArrayList<RunnableClientHandler> clients = new ArrayList<>();
    private static final ExecutorService pool = Executors.newFixedThreadPool(20);

    public static void main(String[] args) throws IOException {
        try(ServerSocket serverS = new ServerSocket(PORT);
             ){

            while(true){
                Socket clientSocket = serverS.accept();
                RunnableClientHandler clientThread = new RunnableClientHandler(clientSocket);
                clients.add(clientThread);
                pool.execute(clientThread);
            }

        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
