import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class File {

    static void newAccount() throws Exception {
        Scanner scan = new Scanner(System.in);
        BufferedReader reader = new BufferedReader(new FileReader("res/Accounts.txt"));
        PrintWriter add = new PrintWriter(new BufferedWriter(new FileWriter("res/Accounts.txt", true)));
        String choice = null;

        do {
            int accnum = 0;
            int phonenum = Process.generateNumber(0);
            String phonenumber = "0969" + phonenum;
            int plan;

            while (true) {
                String line = reader.readLine();
                if (line == null) {
                    break;
                }
                String[] cut = line.split(",");
                accnum = Integer.parseInt(cut[0]);
                while (phonenumber.equals(cut[1])) {
                    phonenum = Process.generateNumber(0);
                    phonenumber = "0969" + phonenum;
                }
            }
            accnum++;

            System.out.print("Enter Last Name: ");
            String lastname = scan.next();
            System.out.print("Enter First Name: ");
            String firstname = scan.next();
            System.out.println("List of Plans");
            Process.showPlans();
            System.out.print("Choose a plan: ");
            plan = scan.nextInt();
            Process.displayNewAccount(accnum, phonenumber, lastname, firstname, plan);
            add.println(+accnum + "," + phonenumber + "," + lastname + "," + firstname + "," + Process.getPlanDetails(plan));

            add.close();

            System.out.println("Do you want to return to menu? Yes/no");
            choice = scan.next();
        } while (choice.equalsIgnoreCase("No"));
        TelecomMain.menu();
    }

    public static void showBillInfoByPlan() throws Exception {
        Scanner scan = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new FileReader("res/Accounts.txt"));
        PrintWriter out = new PrintWriter(new FileWriter("res/BillInfo.txt"));
        int size = getSize(0);
        out.println("Number of Accounts: " + size);
        String line;
        String data[], phoneNo[] = new String[size];
        String name[] = new String[size], plan[] = new String[size];
        int accNo[] = new int[size], fee[] = new int[size], sms[] = new int[size], calls[] = new int[size], dataGb[] = new int[size], currentBal[] = new int[size];
        line = br.readLine();
        int i = 0;
        while (true) {
            if (line == null) {
                break;
            }
            data = line.split(",");
            //create a parallel array
            accNo[i] = Integer.parseInt(data[0]);
            phoneNo[i] = data[1];
            name[i] = data[2] + ", " + data[3]; //concatenated the last name and first name
            plan[i] = data[4];
            fee[i] = Integer.parseInt(data[5]);
            sms[i] = Integer.parseInt(data[6]);
            calls[i] = Integer.parseInt(data[7]);
            dataGb[i] = Integer.parseInt(data[8]);
            currentBal[i] = Integer.parseInt(data[9]);
            line = br.readLine();
            i++;
        }
        int bill[] = getBillInfo(plan,currentBal,sms,calls,dataGb);
        Process.sortByPlan(plan, accNo, phoneNo, name, fee, sms, calls, dataGb, currentBal);
        Process.showParallel(out, plan, accNo, phoneNo, name, bill);
        br.close();
        out.close();
    }

    public static void sortByPlanOnly() throws Exception {
        Scanner scan = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new FileReader("res/Accounts.txt"));
        int size = getSize(0);
        String line;
        String data[], phoneNo[] = new String[size];
        String name[] = new String[size], plan[] = new String[size];
        int accNo[] = new int[size], fee[] = new int[size], sms[] = new int[size], calls[] = new int[size], dataGb[] = new int[size], currentBal[] = new int[size];
        int j = 0, i = 0;
        String plans = null;
        String choice = null;

        do {
            line = br.readLine();

            while (true) {
                if (line == null) {
                    break;
                }
                data = line.split(",");
                //create a parallel array
                accNo[i] = Integer.parseInt(data[0]);
                phoneNo[i] = data[1];
                name[i] = data[2] + ", " + data[3]; //concatenated the last name and first name
                plan[i] = data[4];
                fee[i] = Integer.parseInt(data[5]);
                sms[i] = Integer.parseInt(data[6]);
                calls[i] = Integer.parseInt(data[7]);
                dataGb[i] = Integer.parseInt(data[8]);
                currentBal[i] = Integer.parseInt(data[9]);
                line = br.readLine();
                i++;
            }
            int bills[] = getBillInfo(plan, currentBal, sms, calls, dataGb);
            Process.sortByPlan(plan, accNo, phoneNo, name, fee, sms, calls, dataGb, currentBal);
            System.out.println("Plans: ");
            System.out.print("=================\n||1.Plantutan  ||\n||2.Leche Plan ||\n||3.Planet     ||\n||4.Plangana   ||\n=================\nSelect Plan: ");
            int selectplan = scan.nextInt();
            switch (selectplan) {
                case 1: plans = "Plantutan"; break;
                case 2: plans = "Leche Plan"; break;
                case 3: plans = "Planet"; break;
                case 4: plans = "Plangana";
            }
            System.out.println("Plan: " + plans);
            System.out.printf("%-15s%-15s%-20s%-20s\n", "Account#", "Phone#", "Name", "Bills");
            System.out.printf("================================================================\n");
            for (i = 0; i < plan.length; i++)
                if (plan[i].equalsIgnoreCase(plans)) {
                    System.out.printf("%-15s%-15s%-20s%-20s\n", accNo[i], phoneNo[i], name[i], bills[i]);
                    System.out.printf("================================================================\n");
                }
            System.out.println("Do you want to return to menu? Yes/no");
            choice = scan.next();
        } while (choice.equalsIgnoreCase("No"));
        TelecomMain.menu();
    }

    public static void searchByAccountNum() throws Exception {
        Scanner scan = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new FileReader("res/Accounts.txt"));
        String choice;
        String Aline[];
        int size = getSize(0);
        int search[] = new int[size];
        int Acounter = 0;
        String acc[] = new String[size], NameL[] = new String[size], NameF[] = new String[size], FName[] = new String[size], Plan[] = new String[size];
        int text[] = new int[getSize(0)];
        int calls[] = new int[getSize(0)];
        int inter[] = new int[getSize(0)];
        int bal[] = new int[getSize(0)];
        do {
            System.out.println("Enter Account Number");
            int x = scan.nextInt();
            while (true) {
                String line = br.readLine();
                if (line == null) {
                    break;
                }
                Aline = line.split(",");
                acc[Acounter] = Aline[1];
                NameL[Acounter] = Aline[2];
                NameF[Acounter] = Aline[3];
                Plan[Acounter] = Aline[4];
                FName[Acounter] = NameL[Acounter] + "," + NameF[Acounter];
                search[Acounter] = Integer.parseInt(Aline[0]);
                bal[Acounter] = Integer.parseInt(Aline[9]);
                text[Acounter]= Integer.parseInt(Aline[6]);
                calls[Acounter]=Integer.parseInt(Aline[7]);
                inter[Acounter]=Integer.parseInt(Aline[8]);
                Acounter++;
            }
            int[] bill = getBillInfo(Plan,bal,text,calls,inter);
            int first = 0;
            int last = search.length - 1;
            int index = Process.binarySearch(search, first, last, x);
            System.out.printf("====================================================================================\n");
            System.out.printf("%-15s%-15s%-20s%-20s%-10s\n", "Account#", "Phone#", "Name", "Plan", "Bill");
            System.out.printf("%-15s%-15s%-20s%-20s%-10s\n", search[index], acc[index], FName[index], Plan[index], bill[index]);
            System.out.printf("====================================================================================\n");
            System.out.println("Do you want to return to menu? Yes/no");
            choice = scan.next();
        } while (choice.equalsIgnoreCase("No"));
        br.close();
        TelecomMain.menu();
    }

    public static int getSize(int a) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("res/Accounts.txt"));
        int count = 0;
        while (true) {
            String line = br.readLine();
            if (line == null) {
                break;
            }
            count++;
        }
        return count;
    }
    public static int getSizeCharges(String chargesFile) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(chargesFile));
        int count = 0;
        while (true) {
            String line = br.readLine();
            if (line == null) {
                break;
            }
            count++;
        }
        return count;
    }
    public static int[] getBillInfo(String[] Plan, int[] Balance, int[] SMS, int[] Calls, int[] Data) throws Exception {
        String inputFile = "res/" + Process.promptUserToInputChargesFile();
        BufferedReader br = new BufferedReader(new FileReader(inputFile));
        String line;
        String ArrayLine[];
        int size = getSizeCharges(inputFile);
        int AccountNo[] = new int[size];
        String TypeofService[] = new String[size];
        int cost[] = new int[size];
        String network[] = new String[size];

        int counter = 0;
        int textcost = 3;
        int callscost = 5;
        int datacost = 1; //per mb
        while (true) {
            line = br.readLine();
            if (line== null) {
                break;
            }
            ArrayLine = line.split(",");
            AccountNo[counter] = Integer.parseInt(ArrayLine[0]);
            TypeofService[counter] = ArrayLine[1];
            cost[counter] = Integer.parseInt(ArrayLine[2]);
            network[counter] = ArrayLine[3];
            counter++;
        }

       Data  = Process.toMBConverter(TypeofService,cost,AccountNo);
       Calls= Process.sortBillsByCalls(TypeofService,cost,AccountNo);
       SMS  = Process.sortBillsBySMS(TypeofService,cost,AccountNo);

        for(int i=0;i<AccountNo.length;i++){
            if (Plan[i].equalsIgnoreCase("Plantutan")) {
                int Limitofcalls = 300;
                int Limitoftexts = 3000;
                int DataMB= 7*1000;
                if (Data[i] > DataMB) {
                    Balance[i] = ((Data[i] - DataMB) * datacost) + Balance[i];
                }

                if (Calls[i] > Limitofcalls) {
                    Balance[i] = ((Calls[i] - Limitofcalls) * callscost) + Balance[i];
                }

                if (SMS[i] > Limitoftexts) {
                    Balance[i] = (((SMS[i] -Limitoftexts) * textcost) + Balance[i]);
                }
                Balance[i]+=799;
            }
            if (Plan[i].equalsIgnoreCase("Planet")) {
                int DataMB = 62*1000;
                if (Data[i] > DataMB) {
                    Balance[i] = ((Data[i] - DataMB) * datacost) + Balance[i];
                }
                Balance[i]+=2999;
            }
            if (Plan[i].equalsIgnoreCase("Leche Plan")) {

                int DataMB = 18*1000;
                if (Data[i] > DataMB) {
                    Balance[i] = ((Data[i] - DataMB) * datacost) + Balance[i];
                }
                Balance[i]+=1299;
            }
            if (Plan[i].equalsIgnoreCase("Plangana")) {
                int Limitofcalls = 100;
                int Limitoftexts = 1000;
                int DataMB= 3*1000;
                if (Data[i] > DataMB) {
                    Balance[i] = ((Data[i] - DataMB) * datacost) + Balance[i];
                }
                if (Calls[i] > Limitofcalls) {

                    Balance[i] = (((Calls[i] - Limitofcalls) * callscost) + Balance[i]);
                }
                if (SMS[i] > Limitoftexts) {
                    Balance[i] = (((SMS[i] - Limitoftexts) * textcost) + Balance[i]);
                }
                Balance[i]+=599;
            }
        }
        return Balance;
    }
}


