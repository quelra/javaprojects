package mact1;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class MidClient1 {

    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 12007);
            MidInterface1 remote = (MidInterface1) registry.lookup("midrmi");
            String test = "sa1nt & louis";
            System.out.println(remote.profileString(test));
        } catch (RemoteException | NotBoundException exc) {
            exc.printStackTrace();
        }
    }
}
