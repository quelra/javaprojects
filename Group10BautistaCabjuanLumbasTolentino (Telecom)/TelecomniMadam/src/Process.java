import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

public class Process {
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

    static void showPlans() {
        System.out.println("1. Plangana,599 (3gb mobile data, 1000 texts to all network, 100 mins)\n" +
                "2. Plantutan,799 (7gb mobile data, 3000 texts to all network, 300 mins\n" +
                "3. LechePlan,1299 (18gb mobile data, unlimited texts to all network, unlimited mins call to all networks)\n" +
                "4. Planet,2999(62 gb mobile data,unlimited texts to all network, unlimited call to all networks) \n");
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

    static int generateNumber(int a) {
        Random rand = new Random();
        int min = 1000000;
        int max = 10000000;
        int phonenum = rand.nextInt(max - min) + min;
        return phonenum;
    }

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

    static void swapNum(int _1, int _2, int[] a) {
        int temp = a[_1];
        a[_1] = a[_2];
        a[_2] = temp;
    }

    static void swapStrings(int _1, int _2, String[] a) {
        String temp = a[_1];
        a[_1] = a[_2];
        a[_2] = temp;
    }

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
    public static int[] toMBConverter(String[]Type,int []Data, int Accountnumber[]){
        int Databal [] = new int[Data.length];
        for (int counter = 0; counter<Type.length; counter++){
            if (Type[counter].equalsIgnoreCase("gb")){
                Databal[Accountnumber[counter]-1]+= Data[counter]*1000;
            }else Databal[Accountnumber[counter]-1]+=Data[counter];
        }

        return Databal;
    }
    public static int[] sortBillsByCalls (String[]Type,int [] Calls, int Accountnumber[]){
        int []Callsbal = new int[Calls.length];
        for (int counter = 0; counter<Type.length; counter++){
            if (Type[counter].equalsIgnoreCase("min")){

                Callsbal[Accountnumber[counter]-1]+= Calls[counter];
            }
        }
        return Callsbal;
    }
    public static int[] sortBillsBySMS (String[]Type,int [] SMS, int Accountnumber[]){

        int []SMSbal = new int[SMS.length];
        for (int counter = 0; counter<Type.length; counter++){
            if (Type[counter].equalsIgnoreCase("sms")){
                SMSbal[Accountnumber[counter]-1]+=SMS[counter];
            }
        }
        return SMSbal;
    }
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