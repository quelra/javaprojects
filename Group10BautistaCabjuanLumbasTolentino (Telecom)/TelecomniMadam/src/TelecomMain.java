import java.util.*;
import java.io.*;

public class TelecomMain {
    public static void main(String[]args)throws Exception{
        menu();
    }
    public static void menu () throws Exception{
        Scanner scan = new Scanner(System.in);
        Process.showMENU();
        int choice = scan.nextInt();
        redirectMENU(choice);
    }
    public static void redirectMENU(int choice) throws Exception {
        switch (choice) {
            case 1: File.newAccount(); break;
            case 2: File.showBillInfoByPlan(); break;
            case 3: File.searchByAccountNum(); break;
            case 4: File.sortByPlanOnly(); break;
            case 5:
                System.out.println("Thank you for using TelecomNiMadam!");
                System.exit(0);
        }
    }

}
