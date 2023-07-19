package mact2;

import midexam1.QuizTwo;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.text.ParseException;
import java.util.Scanner;

public class MidExamClient1 {
    private Registry registry = LocateRegistry.getRegistry("localhost", 12007);
    private QuizTwo remote;

    public MidExamClient1() throws RemoteException, NotBoundException {
        this.remote = (QuizTwo) this.registry.lookup("midexam1");
    }

    public static void main(String[] args) {
        try {
            MidExamClient1 client = new MidExamClient1();
            client.run();
        } catch (NotBoundException | RemoteException | ParseException e) {
            System.out.println("An error has occurred");
            e.printStackTrace();
        }
    }

    public void run() throws RemoteException, ParseException {
        System.out.println("========================================");

        Scanner scan = new Scanner(System.in);
        System.out.println("Month: " );
        int m = scan.nextInt();
        System.out.println("Day: ");
        int d = scan.nextInt();
        System.out.println("Year: ");
        int y = scan.nextInt();

        System.out.println("Day of the month: " + remote.dotw(m, d, y));
        System.out.println("Number of days: " + remote.noOfDays(m,d));

        System.out.println("========================================");

    }
}
