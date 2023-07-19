import service.BautistaRaquelLuckyService;
import service.BautistaRaquelLuckyServiceService;

import javax.xml.ws.WebServiceRef;
import java.util.Scanner;

public class Client {
    @WebServiceRef(wsdlLocation = "http://localhost:8080/luckyservice")
    public static void main(String[] args) {
        try {
            BautistaRaquelLuckyServiceService lss = new BautistaRaquelLuckyServiceService();
            BautistaRaquelLuckyService ls = hws.getBautistaRaquelLuckyServicePort();

            Scanner scan = new Scanner(System.in);

            int pn = ls.getNum();
            System.out.println("PLAYER NUMBER: " + pn);
            System.out.println("hit? y/n");

            String choice = scan.nextLine();

            if(choice.equals("y")){
                pn += ls.hit();
            }

            System.out.println(ls.play(pn));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}