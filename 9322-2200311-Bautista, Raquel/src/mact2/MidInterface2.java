package mact2;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MidInterface2 extends Remote {
    // allows registration of users and saved in a data structure/collection
    // (preferably a hashmap)
    public boolean register(User u) throws RemoteException;
    // returns the instance of User where n is the user name
    public User getUser(String n) throws RemoteException;
}
