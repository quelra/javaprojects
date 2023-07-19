
import java.util.Scanner;

public class luckyTicket{
    public static void main(String[]args){
        Scanner keyboard = new Scanner(System.in);
        String numberLength = keyboard.nextLine();
        String ticketNumber = keyboard.nextLine();
        boolean isLucky = true;
        boolean isLengthEven = false;
        int sumFirstHalf = 0;
        int length = ticketNumber.length();
        int sumSecondHalf = 0;
        String[] others = new String[]{"0", "1", "2", "3", "5", "6", "8", "9"};
        //Check if the number is lucky (containing 7 or 4) // Better to use regex though
        for (int i = 0; i < others.length; i++) {
            if(ticketNumber.contains(others[i])){
                isLucky = false;
            }
        }
        //Compute the sum of first half
        for(int i=0; i<length/2;i++) {
            sumFirstHalf += Integer.parseInt(String.valueOf(ticketNumber.charAt(i)));
        }
        //Compute the sum of second half
        for(int i=(length/2); i<length;i++) {
            sumSecondHalf += Integer.parseInt(String.valueOf(ticketNumber.charAt(i)));
        }
        //Check if length is even and matches the given input length
        if((ticketNumber.length()%2==0) && (Integer.parseInt(numberLength) == ticketNumber.length())){
            isLengthEven = true;
        }

        if(isLengthEven && isLucky && sumFirstHalf==sumSecondHalf){
            System.out.println("YES");
        }else {
            System.out.println("NO");
        }

    }

    // public static boolean isLucky(String number) {
    //     String[] others = new String[]{"0", "1", "2", "3", "5", "6", "8", "9"};
    //     boolean res = true;
    //     for (int i = 0; i < others.length; i++) {
    //         if(number.contains(others[i])){
    //             res = false;
    //         }
    //     }
    //     return res;
    // }

    // public static int sumFirstHalf(String number){
    //     int length = number.length();

    //     int result =  0;

    //     for(int i=0; i<length/2;i++) {
    //         result += Integer.parseInt(String.valueOf(number.charAt(i)));
    //     }
    //     return result;
    // }

    // public static int sumSecondHalf(String number){
    //     int length =number.length();
    //     int result =  0;

    //     for(int i=(length/2); i<length;i++) {
    //         result += Integer.parseInt(String.valueOf(number.charAt(i)));
    //     }
    //     return result;
    // }

    // public static boolean  isLengthEven(String len, String number){
    //     if((number.length()%2==0) && (Integer.parseInt(len) == number.length())){
    //         return true;
    //     }
    //     return false;
    // }

}
/*
A. Lucky Ticket
time limit per test2 seconds
memory limit per test256 megabytes
inputstandard input
outputstandard output
Petya loves lucky numbers very much. Everybody knows that lucky numbers are positive integers whose decimal record contains only the lucky digits 4 and 7. For example, numbers 47, 744, 4 are lucky and 5, 17, 467 are not.

Petya loves tickets very much. As we know, each ticket has a number that is a positive integer. Its length equals n (n is always even). Petya calls a ticket lucky if the ticket's number is a lucky number and the sum of digits in the first half (the sum of the first n / 2 digits) equals the sum of digits in the second half (the sum of the last n / 2 digits). Check if the given ticket is lucky.

Input
The first line contains an even integer n (2 ≤ n ≤ 50) — the length of the ticket number that needs to be checked. The second line contains an integer whose length equals exactly n — the ticket number. The number may contain leading zeros.

Output
On the first line print "YES" if the given ticket number is lucky. Otherwise, print "NO" (without the quotes).

Examples
inputCopy
2
47
outputCopy
NO
inputCopy
4
4738
outputCopy
NO
inputCopy
4
4774
outputCopy
YES
Note
In the first sample the sum of digits in the first half does not equal the sum of digits in the second half (4 ≠ 7).

In the second sample the ticket number is not the lucky number.


 */