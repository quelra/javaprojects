/**
 * This class contains the process the occurs in the telecommunications project
 */

import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

/**
 *This redirects the user to the menu check the available choices seen in the Main Menu
 * Shows the Main Menu
 *
 * This is the choice made by the user if they would want :
 *    to add an account,
 *    show the output bill of information of accounts,
 *    search an account by their account number,
 *    as well as see the list of accounts by plan .
 *
 */

public class Process {
    /**
     * This shows the menu of the telecommunications for adding an account, Output Bill Information of accounts
     * Searching an Account by Account Number as well as seeing the List of Accounts by Plan
     */

    static void showMENU() {
        System.out.println("\n ===========================================");
        System.out.printf("%-43s%1s\n","|| MENU","||");
        System.out.printf("%-43s%1s\n","|| 1. Add Account","||");
        System.out.printf("%-43s%1s\n","|| 2. Output Bill Information of accounts","||");
        System.out.printf("%-43s%1s\n","|| 3. Search Account by Account Number","||");
        System.out.printf("%-43s%1s\n","|| 4. List of Accounts by Plan","||");
        System.out.printf("%-43s%1s\n","|| 5. Exit","||");
        System.out.println(" ===========================================");
        System.out.print("Select Option: ");
    }
    /**
     * Prints out the message that shows the different plans the company offers
     * This shows the plans of the company which displays the price of the plan, data gigabyte, number of texts, minutes of calls
     * Allows the user to choose the plan by inputting :1,2,3 or 4.
     */

    static void showPlans() {
        System.out.println("1. Plangana,599 (3gb mobile data, 1000 texts to all network, 100 mins)\n" +
                "2. Plantutan,799 (7gb mobile data, 3000 texts to all network, 300 mins\n" +
                "3. LechePlan,1299 (18gb mobile data, unlimited texts to all network, unlimited mins call to all networks)\n" +
                "4. Planet,2999(62 gb mobile data,unlimited texts to all network, unlimited call to all networks) \n");

        /**
         *This shows the plans of the company which displays the price of the plan, data gigabyte, number of texts, minutes of calls
         *
         * @param plan Prints out the message that shows the specific plan.
         * @return returns to the code that invoked it when it completes all the statements in the method
         */
    }

    static String getPlanDetails(int plan) {
        String details = " ";
        switch (plan) {
            case 1: details = "Plangana,599,1000,100,3,599"; break;
            case 2: details = "Plantutan,799,3000,300,7,799"; break;
            case 3: details = "LechePlan,1299,0,0,18,1299"; break;
            case 4: details = "Planet,2999,0,0,62,2999"; break;
        }
        return details;
    }
    /**
     *Generates a unique phone number for an account.
     *
     * @param a initialized for the number
     * @return returns to the code that invoked it when it completes all the statements in the method
     */


    static int generateNumber(int a) {
        Random rand = new Random();
        int min = 1000000;
        int max = 10000000;
        int phonenum = rand.nextInt(max - min) + min;
        return phonenum;
    }

    /**
     * This allows the user to input their details for when they create a new account.
     * The user is allowed to put their details here.
     *
     * @param accnum account number to be saved for future references to differentiate with the other accounts
     * @param phonenumber the unique phone number assigned to each phone from the user
     * @param lastname inputted last name of the user
     * @param firstname inputted first name of the user
     * @param plan chosen plan of the user
     */

    static void displayNewAccount(int accnum, String phonenumber, String lastname, String firstname, int plan) {
        switch (plan) {
            case 1:
                System.out.println("========================================================================================");
                System.out.println("Account Number: " + accnum);
                System.out.println("Phone Number: " + phonenumber);
                System.out.println(firstname + " " + lastname);
                System.out.println("Plan: Plangana");
                System.out.println("3gb mobile data, 1000 texts to all network, 100 mins call");
                System.out.println("Account successfully added on Accounts.txt.");
                break;
            case 2:
                System.out.println("========================================================================================");
                System.out.println("Account Number: " + accnum);
                System.out.println("Phone Number: " + phonenumber);
                System.out.println(firstname + " " + lastname);
                System.out.println("Plan: Plantutan");
                System.out.println("7gb mobile data, 3000 texts to all network, 300 mins call");
                System.out.println("Account successfully added on Accounts.txt.");
                break;
            case 3:
                System.out.println("========================================================================================");
                System.out.println("Account Number: " + accnum);
                System.out.println("Phone Number: " + phonenumber);
                System.out.println(firstname + " " + lastname);
                System.out.println("Plan: LechePlan");
                System.out.println("18gb mobile data, unlimited texts to all network, unlimited mins call to all networks");
                System.out.println("Account successfully added on Accounts.txt.");
                break;
            case 4:
                System.out.println("========================================================================================");
                System.out.println("Account Number: " + accnum);
                System.out.println("Phone Number: " + phonenumber);
                System.out.println(firstname + " " + lastname);
                System.out.println("Plan: Planet");
                System.out.println("62 gb mobile data,unlimited texts to all network, unlimited call to all networks)");
                System.out.println("Account successfully added on Accounts.txt.");
                break;
        }
    }
    /**
     * This allows the user to search for their account using their names.
     *
     * @param search searches for the user's query
     * @param first This is a parameter for the user's first name
     * @param last This is a parameter for the user's last name
     * @param x a value for the search of the user name
     * @return returns the search
     */
    public static int binarySearch(int[] search, int first, int last, int x) {
        while (first <= last) {
            int mid = (first + last) / 2;
            if (search[mid] < x) {
                first = mid + 1;
            } else if (search[mid] > x) {
                last = mid - 1;
            } else if (search[mid] == x) {
                return mid;
            }
        }
        return -1;
    }

    /**
     *The sorts the plan of the user by their account number ,phone number , name, the fee to be paid
     *as well as their sms, calls, and data usage. This also shows the user's current balance
     *
     * @param sortByPlan This sorts by plan
     * @param accNo account number to be saved for future references to differentiate with the other accounts
     * @param phoneNo the unique phone number assigned to each phone from the user
     * @param name this is the inputted name of the user
     * @param fee the fee to be paid by the user based on their usage from their plan
     * @param sms the type of sms from the plan that is to be sorted
     * @param calls the type of calls per minute from the plan that is to be sorted
     * @param data the type of data from the plan that is to be sorted
     * @param currentBal The current balance of the user to be compared with their future transactions
     */
    public static void sortByPlan(String[] sortByPlan, int[] accNo, String[] phoneNo, String[] name, int[] fee, int[] sms, int[] calls, int[] data, int[] currentBal){
        for (int a = 0; a < sortByPlan.length; a++) {
            for (int j = 1; j < (sortByPlan.length - a); j++) {
                if (sortByPlan[j].compareTo(sortByPlan[j - 1]) < 0) {
                    swapStrings(j - 1, j, sortByPlan);
                    swapNum(j - 1, j, accNo);
                    swapStrings(j - 1, j, phoneNo);
                    swapStrings(j - 1, j, name);
                    swapNum(j - 1, j, fee);
                    swapNum(j - 1, j, sms);
                    swapNum(j - 1, j, calls);
                    swapNum(j - 1, j, data);
                    swapNum(j - 1, j, currentBal);
                }
            }
        }
    }

    /**
     * This is a method to swap numbers
     *
     * @param _1 first intialized value
     * @param _2 second intialized value
     * @param a third intialized value for swapping numbers
     */

    static void swapNum(int _1, int _2, int[] a) {
        int temp = a[_1];
        a[_1] = a[_2];
        a[_2] = temp;
    }

    /**
     This is a method to swap strings
     *
     * @param _1 first intialized value
     * @param _2 second intialized value
     * @param a third intialized value for swapping strings
     */

    static void swapStrings(int _1, int _2, String[] a) {
        String temp = a[_1];
        a[_1] = a[_2];
        a[_2] = temp;
    }

    /**
     *This totals all the bill from the account and shows the total for the user.
     *
     * @param out used for the passing the arguments to methods as a reference type
     * @param plan initialized value for a choice in the menu for the plan of the account
     * @param accNo initialized value for a choice in the menu for account number
     * @param phoneNo initialized value for a choice in the menu for account phone numbers
     * @param name initialized value for a choice in the menu for account name of the users
     * @param bill initialized value for a choice in the menu for account bill
     * @throws Exception when the method gets called
     */
    public static void showParallel(PrintWriter out, String[] plan, int[] accNo, String[] phoneNo, String[] name, int[]bill) throws Exception{
        int totalbill=0;
        out.printf("%-15s%-10s%-15s%-25s%-5s\n", "Plan", "Account#","Phone#", "Name","Final Bill");
        for (int i = 0; i < plan.length; i++) {
            out.printf("%-15s%-10s%-15s%-25s%-5s\n", plan[i], accNo[i], phoneNo[i], name[i],bill[i]);
            totalbill += bill[i];
        }
        System.out.println("\nBill Information Output Successful! " +
                "\nName of text file: BillInfo.txt");
        out.println("\nTotal Bill: "+totalbill);
        out.close();
        TelecomMain.menu();

    }

    /**
     *The data balance which will convert the MB to GB to be calculate accordingly.
     *
     * @param Type Converts the MB of the data to GB
     * @param Data The data of the plan
     * @param Accountnumber The account number of the user's account
     * @return Returns the data balance
     */
    public static int[] toMBConverter(String[]Type,int []Data, int Accountnumber[]){
        int Databal [] = new int[Data.length];
        for (int counter = 0; counter<Type.length; counter++){
            if (Type[counter].equalsIgnoreCase("gb")){
                Databal[Accountnumber[counter]-1]+= Data[counter]*1000;
            }else Databal[Accountnumber[counter]-1]+=Data[counter];
        }

        return Databal;

    }

    /**
     *This sorts the bills by the minutes of calls the user made and returns the call balance.
     *
     * @param Type The type of calls chosen by the user.
     * @param Calls the number of calls per minute
     * @param Accountnumber Account number the account number of the user's account
     * @return Returns the call balance
     */

    public static int[] sortBillsByCalls (String[]Type,int [] Calls, int Accountnumber[]){
        int []Callsbal = new int[Calls.length];
        for (int counter = 0; counter<Type.length; counter++){
            if (Type[counter].equalsIgnoreCase("min")){

                Callsbal[Accountnumber[counter]-1]+= Calls[counter];
            }
        }
        return Callsbal;
    }

    /**
     * This sorts the bills by the SMS and returns the balance
     *
     * @param Type The type of sms chosen by the user.
     * @param SMS the number of text messages
     * @param Accountnumber the account number of the user's account
     * @return Returns the SMS balance
     */
    public static int[] sortBillsBySMS (String[]Type,int [] SMS, int Accountnumber[]){

        int []SMSbal = new int[SMS.length];
        for (int counter = 0; counter<Type.length; counter++){
            if (Type[counter].equalsIgnoreCase("sms")){
                SMSbal[Accountnumber[counter]-1]+=SMS[counter];
            }
        }
        return SMSbal;
    }

    /**
     *This prompts the user to input the charges file with a different file name
     *
     * @return the charges in a file with a new file name.
     */

    public static String promptUserToInputChargesFile(){
        Scanner scan = new Scanner(System.in);
        String chargesFile="Charges.txt";
        System.out.println("Would you like to use Charges.txt? 1. Yes 2. Use other file");
        int choice=scan.nextInt();
        if(choice==2){
            System.out.print("Input Filename of Charges: res/");
            chargesFile=scan.next();
        }
        return chargesFile;

    }
}