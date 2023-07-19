package mact1;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MidInterface1 extends Remote {
    public String profileString(String s) throws RemoteException;
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

