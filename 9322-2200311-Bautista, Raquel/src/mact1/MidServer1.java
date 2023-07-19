package mact1;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.regex.Pattern;

public class MidServer1 extends UnicastRemoteObject implements MidInterface1{


    protected MidServer1() throws RemoteException {}

    @Override
    public String profileString(String s) throws RemoteException {
        String vowelsRegex = "[aeiouAEIOU]";
        String consonantsRegex = "[BCDFGHJKLMNPQRSTVWXYZbcdfghjklmnpqrstvwxyz]";
        String vowels = "", consonants = "";

        for(int i = 0; i<s.length(); i++){
            if(String.valueOf(s.charAt(i)).matches(vowelsRegex)){
                vowels = vowels + (s.charAt(i));
            } else if(String.valueOf(s.charAt(i)).matches(consonantsRegex)){
                consonants = consonants + (s.charAt(i));
            }
        }
        String result = s + " " + s.length() + " " + vowels + " " + consonants;
        return result;
    }

    public static void main(String[] args) {
        try {
            MidInterface1 stub = new MidServer1();
            Registry reg = LocateRegistry.createRegistry(12007);
            reg.rebind("midrmi", stub);
            System.out.println("Midterm RMI bound");
        } catch (RemoteException exc) {
            exc.printStackTrace();
        }
    }

    }


    /*
profileString is a method that will return the following in one line:
The original string + space + length of string + space + all vowels in order of their appearance + space +
all consonants in order of their appearance
For example, an invocation of profileString("sa1nt & louis") would return:
"sa1nt & louis 13 aoui sntls"
Note: All non-letters should be ignored in the computation for vowels and consonants but included in the
computation of the string size.
 */

