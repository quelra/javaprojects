package mact2;

import java.io.Serializable;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class MidClient2  {
    private Registry registry = LocateRegistry.getRegistry("localhost", 12007);
    private MidInterface2 remote;

    public MidClient2() throws RemoteException, NotBoundException {
        this.remote = (MidInterface2) this.registry.lookup("mact2");
    }

    public static void main(String[] args) {
        try {
            MidClient2 client = new MidClient2();
            client.runRegister();
        } catch (NotBoundException | RemoteException e) {
            System.out.println("An error has occurred");
            e.printStackTrace();
        }
    }

    public void runRegister() throws RemoteException {
        try {
            Scanner scan = new Scanner(System.in);
            System.out.println("Register");
            System.out.print("Enter username: ");
            String username = scan.nextLine();
            System.out.print("Enter password: ");
            String password = scan.nextLine();

            User u = new User(username, password);

            if(remote.register(u)){
                System.out.println("\nUsername " + remote.getUser(username).getName() + " is successfully registered");
            }


        } catch (Exception e){
            e.printStackTrace();
        }

    }

}
