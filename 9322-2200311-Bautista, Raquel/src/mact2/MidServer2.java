package mact2;


import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class MidServer2 {

    public static void main(String[] args) {
        try {
            MidServant2 stub = new MidServant2();
            Registry registry = LocateRegistry.createRegistry(12007);
            registry.rebind("mact2", stub);
        } catch (RemoteException e) {
            System.out.println("An error has occurred");
            e.printStackTrace();
        }

    }
}
