package pact1;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * This class accepts a host name from the user and lists all the associated IP addresses to it.
 */
public class PreActivity1 {
    public static void main(String[] args){
        PreActivity1 program;
        try{
            program = new PreActivity1();
            program.run();
        } catch (UnknownHostException x1){
            System.out.println("Invalid Host");
        }    catch (Exception e){
            System.out.println("An error has occurred");
            e.printStackTrace();
        }

    }

    /**
     * The run method prompts the user to input a host name.
     * The IP addresses associated to it are stored in an array.
     * The number of IP address are shown.
     * The IP addresses stored in the array are shown with its corresponding host name.
     * The user can enter different hostname as long as he/she wants.
     * @throws UnknownHostException
     */
    public void run() throws UnknownHostException {
        int hostNo = 1;
        String c="y";
        while(c.equals("y")){
            Scanner scan = new Scanner(System.in);
            System.out.print("Host " + hostNo + "- Type Host Name: ");
            String hostName = scan.next();
            InetAddress[] a = InetAddress.getAllByName(hostName);
            System.out.println("Number of host(s)/IP(s): " + (a.length));
            for(InetAddress address: a){
                System.out.println("Host name: " + address.getHostName());
                System.out.println("IP address: " + address.getHostAddress());
            }
            System.out.print("\nSearch Another? [Y/N]: ");
            c=scan.next();
            hostNo++;
        }
        System.exit(0);
    }
}
