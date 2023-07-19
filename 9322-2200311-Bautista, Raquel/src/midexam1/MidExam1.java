package midexam1;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class MidExam1 {
    public static void main(String[] args) {
        try {
            MidServant stub = new MidServant();
            Registry registry = LocateRegistry.createRegistry(12007);
            registry.rebind("midexam1", stub);
        } catch (RemoteException e) {
            System.out.println("An error has occurred");
            e.printStackTrace();
        }

    }
}
