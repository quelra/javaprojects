package rmi;
import java.rmi.Remote;
import java.rmi.RemoteException;


public interface SampleRemote extends Remote {
    int countCharacters(String value) throws RemoteException;
}