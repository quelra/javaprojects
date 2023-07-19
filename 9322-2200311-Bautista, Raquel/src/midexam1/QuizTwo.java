package midexam1;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.text.ParseException;

public interface QuizTwo extends Remote {
    public String dotw(int m, int d, int y) throws RemoteException, ParseException;
    public int noOfDays(int m, int d) throws RemoteException, ParseException;
}
