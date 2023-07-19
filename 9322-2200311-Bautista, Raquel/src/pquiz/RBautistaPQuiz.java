package pquiz;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RBautistaPQuiz {
        private static ArrayList<ClientHandler> clients = new ArrayList<>();
        private static ExecutorService pool = Executors.newFixedThreadPool(10);

        public static void main(String[] args) throws IOException {
            ServerSocket serverSocket = new ServerSocket(12007);

            while(true){
                Socket clientSocket = serverSocket.accept();
                ClientHandler clientThread = new ClientHandler(clientSocket);
                clients.add(clientThread);
                pool.execute(clientThread);
            }
        }

}
