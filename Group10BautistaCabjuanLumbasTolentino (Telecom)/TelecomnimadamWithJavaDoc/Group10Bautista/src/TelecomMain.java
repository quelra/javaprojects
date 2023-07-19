/**
 * This is the main class for the program of the telecommunications project .
 */

import java.util.*;
import java.io.*;

/**
 * This program is for a telecommunications company charging basis.
 *
 * The program is menu-based which allows the subscribe to their chosen plans,
 * ables them to add their information for their account,
 * and check their billing information.
 *
 * @author Bautista,Cabjuan,Lumbas,Tolentino
 * @since 2019-12-07
 */

public class TelecomMain {
    public static void main(String[]args)throws Exception{
        menu();
    }
    public static void menu () throws Exception{
        Scanner scan = new Scanner(System.in);
        Process.showMENU();
        int choice = scan.nextInt();
        redirectMENU(choice);
        /**
         * Scans for the chosen action of the user in the menu for the user's desired action.
         *
         * @throws Exception when the method gets called
         */
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
