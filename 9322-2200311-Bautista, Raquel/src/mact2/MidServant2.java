package mact2;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;

public class MidServant2 extends UnicastRemoteObject implements MidInterface2{
    public HashMap<String, String> users = new HashMap();

    public MidServant2() throws RemoteException {
    }


    @Override
    public boolean register(User u) throws RemoteException {
        users.put(u.getName(), u.getPassword());

        if(users.containsKey(u.getName())){
            return true;
        }
        return false;
    }

    @Override
    public User getUser(String n) throws RemoteException {
        try{
            if(users.containsKey(n)){
                User getUser  = new User(n, users.get(n));
                return getUser;
            }
        } catch(Exception x){
            x.printStackTrace();
        }
        return null;
    }
}
