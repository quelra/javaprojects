import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Pattern;
import java.math.*;

public class Solutions{
    public static void main(String[] args) throws IOException {
        System.out.println("==================================");
        System.out.println("1  - Password Check");
        System.out.println("2  - Lucky Ticket");
        System.out.println("3  - Spy Detected");
        System.out.println("4  - Boy or Girl");
        System.out.println("5  - Dislike of Threes");
        System.out.println("6  - Windblume");
        System.out.println("7  - A New Password");
        System.out.println("8  - Help Far Away Kingdom");
        System.out.println("9  - The Miracle and the Sleeper");
        System.out.println("10 - Elections");
        System.out.println("11 - The Sum of 2050");
        System.out.println("12 - Splits");
        System.out.println("Choose a Method: ");

        Scanner scan = new Scanner(System.in);
        int input = scan.nextInt();
        switch (input){
            case 1:
                // passwordCheck();
                break;
            case 2:
                // luckyTicket();;
                break;
            case 3:
                //spyDetected();
                break;
            case 4:
                //  boyOrGirl();
                break;
            case 5:
                // dislikeOfThrees();
                break;
            case 6:
                //  windBlumeOde();
                break;
            case 7:
                // aNewPassword();
                break;
            case 8:
                // helpFarAwayKingdom();
                break;
            case 9:
                // theMiracleAndTheSleeper();
                break;
            case 10:
                // elections();
                break;
            case 11:
                //  theSumOf2050(inputs);
                break;
            case 12:
                // splits();
                break;
            default:
                System.out.println("Incorrect Input! Please enter a valid value [1] - [12]");
        }
        scan.close();
    }

    /**
     * @author Raquel Bautista
     * Checks if the password has atleast 5 characters, least 1 large English letter, 1 small English letter, at least 1 digit.
     * @param password The password string to check.
     * @return Returns "Correct" if the password meets the requirements, "Too weak" if otherwise.
     */
    public static boolean passwordCheck(String password){
        System.out.println("Password Check Method");
        System.out.println("Password check: ");
        // Scanner scan = new Scanner(System.in);
        // String password = scan.nextLine();

        String regex = "(?=.*[A-Z])(?=.*[a-z])^(?=.*[0-9]).{5,100}$";

        if(Pattern.matches(regex,password)){
            System.out.println("Correct");
            return true;
        }else{
            System.out.println("Too weak");
        }
        // scan.close();
        return false;
    }//end of passwordCheck

    /**
     * @author Raquel Bautista
     * This checks the if the inputted ticket number is lucky (containing only 4 and 7), even length, and equal first half sum and second half sum.
     * @param input The integer input to check.
     * @return returns true if the input is considered lucky.
     */
    public static boolean luckyTicket(int input[]){
        System.out.println("Lucky Ticket Method");
        // Scanner scan = new Scanner(System.in);
        // String numberLength = scan.nextLine();
        // String ticketNumber = scan.nextLine();
        String numberLength = String.valueOf(input[0]);
        String ticketNumber = String.valueOf(input[1]);
        boolean isLucky = true, isLengthEven = false;
        int sumFirstHalf = 0, length = ticketNumber.length(), sumSecondHalf = 0;
        String[] others = new String[]{"0", "1", "2", "3", "5", "6", "8", "9"};
        String res = "";

        for (int i = 0; i < others.length; i++) {
            if(ticketNumber.contains(others[i])){
                isLucky = false;
            }
        }

        for(int i=0; i<length/2;i++) {
            sumFirstHalf += Integer.parseInt(String.valueOf(ticketNumber.charAt(i)));
        }

        for(int i=(length/2); i<length;i++) {
            sumSecondHalf += Integer.parseInt(String.valueOf(ticketNumber.charAt(i)));
        }

        if((ticketNumber.length()%2==0) && (Integer.parseInt(numberLength) == ticketNumber.length())){
            isLengthEven = true;
        }

        if(isLengthEven && isLucky && sumFirstHalf==sumSecondHalf){
            System.out.println("YES");
            return true;
        }else {
            System.out.println("NO");
        }
        return false;
        // scan.close();
    }//end of luckyTicket

    /**
     * @author Leonardo Gavino III
     * Method for getting the index of the
     * @param inputs
     * @return
     */
    public static int[] spyDetected(String[] inputs){
        System.out.println("Spy Detected Method");
//        Scanner scan = new Scanner(System.in);
//        int numberOfInputs = Integer.parseInt(scan.nextLine());
        int numberOfInputs = Integer.parseInt(inputs[0]);
        List<Integer> outputs = new ArrayList<>();

        if(1 <= numberOfInputs && numberOfInputs <= 100){
            int lA = 1;
            int inp = 2;
            for(int i=0; i<numberOfInputs; i++){
//                int lengthOfArray = Integer.parseInt(scan.nextLine()) ;

                int lengthOfArray = Integer.parseInt(inputs[lA]);


                if(3 <= lengthOfArray && lengthOfArray<= 100){
                    String input = inputs[inp];

                    //make array method
                    int[] array = new int[lengthOfArray];
                    StringBuilder number = new StringBuilder();
                    int counter =0;
                    for(int a=0; a<input.length(); a++){
                        int comparison = Character.compare(input.charAt(a),' ');
                        if(comparison >0){
                            number.append(input.charAt(a));
                        } else {
                            array[counter]=Integer.parseInt(number.toString());
                            counter ++;
                            number = new StringBuilder();
                        }
                    }
                    array[lengthOfArray-1] = Integer.parseInt(number.toString());

                    //checkArrayIfTwoNum method
                    List<Integer> allNumbers = new ArrayList<>();
                    boolean checker=true;

                    for(int b=0; b<array.length;b++){
                        if(!allNumbers.contains(array[b])){
                            allNumbers.add(array[b]);
                        }
                    }

                    if (allNumbers.size() >= 3){
                        checker = false;
                    }

                    if(checker){
                        //findSpy method
                        int firstNumber = array[0];
                        int spy = 0;
                        for(int c =1; c<array.length; c++){
                            if (firstNumber != array[c]){
                                if (firstNumber != array[array.length-1]){
                                    if(array[array.length-1] != array[array.length-2]){
                                        spy = array.length;
                                    } else {
                                        spy = 1;
                                    }
                                } else {
                                    spy = c + 1;
                                }
                                break;
                            }
                        }
                        outputs.add(spy);
                    }
                }
                lA += 2;
                inp += 2;
            }

        }
        int[] outputs2 = new int[outputs.size()];
        for(int i=0;i<outputs.size();i++){
            outputs2[i] = outputs.get(i);
        }
        for (Integer output : outputs) {
            System.out.println(output);
        }
        return outputs2;
    }

    /**
     * @author Leonardo Gavino III
     * @param profile
     * @return
     */
    public static boolean boyOrGirl(String profile){
        System.out.println("Boy Or Girl Method");
        // Scanner scan = new Scanner(System.in);
        // String profile = scan.nextLine();
        //checkIfSmallLetters method
        boolean checker=true;
        for(int i=0; i<profile.length();i++){
            if(Character.isUpperCase(profile.charAt(i)) || Character.isDigit(profile.charAt(i))){
                checker = false;
                break;
            }
        }

        if(!profile.equals(" ") && profile.length()<=100 && checker){

            //countLetters method
            List<Character> allLetters = new ArrayList<>();
            for(int i=0;i<profile.length();i++){
                if(!allLetters.contains(profile.charAt(i))){
                    allLetters.add(profile.charAt(i));
                }
            }

            if(allLetters.size()%2 == 0){
                System.out.println("CHAT WITH HER!");
                return true;
            } else {
                System.out.println("IGNORE HIM!");
            }
        }
        return false;
    }


    /**
     * @author Heidi Batara
     * @since October 27, 2021
     * This method computes and displays the minimum number of 2050-numbers
     * required for a given input.
     * The first line of the input indicates the number of test cases.
     * @param inputs An array of integers with the value at index 0 containing the number of cases.
     * @return Minimum number of 2050-numbers
     */
    public static long[] theSumOf2050(long[] inputs){
        System.out.println("The Sum Of 2050 Method");
        //Scanner scanKB = new Scanner(System.in);
        //int noOfCases = scanKB.nextInt();
        int noOfCases = Integer.parseInt(String.valueOf(inputs[0]));
        long [] outputsList = new long[noOfCases];
        int count= 0;
        while (count < noOfCases){
            long input = 0;
            //input = scanKB.nextLong();
            input=Long.parseLong(String.valueOf(inputs[count+1]));
            long output = 0;
            if (input % 2050 != 0) {
                output=-1;
            }else{
                input/=2050;
                while(input!=0){
                    output+=(input%10);
                    input/=10;
                }
            }
            outputsList[count]=output;
            count++;
        }
        for (int i =0; i< outputsList.length; i++){
            System.out.println(outputsList[i]);
        }
        return outputsList;
    }//end theSumof2050


    /**
     * @author Heidi Batara
     * @since October 27, 2021
     * This function computes and displays the number of different weights of its split, for a given input.
     * @param input The integer to split.
     * @return Number of possible split combinations.
     */
    public static int splits(int input){
        System.out.println("Splits Method");
        //  Scanner scanKB = new Scanner(System.in);
        // input = scanKB.nextInt();
        int output = (input/2)+1;
        System.out.println(output);
        return output;
    }//end splits

    /**
     * @author Rodolfo Mercado
     * @since October 27, 2021
     * The function starts at 1 and goes through all the numbers until the input is reached.
     * Integers that are NOT divisible by 3, end with the digit 3, and both are skipped.
     * The output consists of the the last integer the function went through.
     * @param input Target integer.
     * @return Last integer the function went through.
     */
    public static int dislikeOfThrees(int input){
        System.out.println("Dislike Of Threes Method");
        int index = 0;
        int a = 1;
        int b = 1;
        int c = input;
        index++;
        while (a < c) {
            b++;
            if (b % 3 != 0 && b % 10 != 3) a++;
        }
        System.out.println(b);
        return b;
    }
    //end dislikeOfThrees

    /**
     * @author Rodolfo Mercado
     * @since October 27, 2021
     * This functions returns "YES" if the integer input can be split into two even numbers.
     * The split values do not have to be equal
     * @param n The integer value to be split.
     * @return Returns "YES" is integer input can be split into two even numbers. "NO" if otherwise.
     */
    public static String watermelon(int n){
        System.out.println("Watermelon Method");
        boolean splittable = false;
        for(int i = 1; i <= n/2; i++){
            int half = n-i;
            if((i%2)==0&&(half%2)==0){
                splittable = true;
                break;
            }
        }
        if(splittable){
            System.out.println("YES");
            return "YES";
        } else{
            System.out.println("NO");
            return "NO";
        }
    }//end windBlume ode



    /**
     * @author Rianne Justin Policarpio
     * @since October 27, 2021
     * the length of the password must be equal to n,
     * the password should consist only of lowercase Latin letters,
     * the number of distinct symbols in the password must be equal to k,
     * any two consecutive symbols in the password must be distinct.
     * @param n Length of the password.
     * @param k Number of distinct symbols.
     * @return The generated password based to the parameters.
     */
    public static String aNewPassword(int n, int k){
        System.out.println("A New Password Method");
        //  Scanner scan = new Scanner(System.in);
        //  int n = scan.nextInt();
        //  int k = scan.nextInt();
        //  StringBuilder s = new StringBuilder();
        String s = "";
        for(int i = 0; i<n;i++){
            s += ((char) ((int) 'a' + i % k));
        }
        System.out.println(s);
        return s;
    }

    /**
     * @author Rianne Justin Policarpio
     * @since October 27, 2021
     * if x does not end with digit 9 & fraction part is < 0.5
     * the rounded up number coincides with the number’s integer part.
     * If x does not end with digit 9 & fraction part is > 0.5
     * rounded up number is obtained if we add 1 to the last digit of the number’s integer part.
     * If the number’s integer part ends with digit 9, to round up the numbers one should go to Vasilisa the Wise.
     * Samle Input & Output
     * I: 0.0  O:0
     * I: 1.49       O:1
     * I: 1.50                     O:2
     * I: 2.71828182845904523536   O:3
     * I: 12345678901234567890.1   O:12345678901234567890
     * I: 123456789123456789.999   O:GOTO Vasilisa.
     * @param choice Double x to be evaluated.
     * @return Returns a string representing the outcome based on the conditions.
     */
    public static String helpFarAwayKingdom(double choice) {
        System.out.println("Help Far Away Kingdom Method");
        //Scanner scan = new Scanner(System.in);
        String answer;
        // BigDecimal x = scan.nextBigDecimal();
        BigDecimal x = BigDecimal.valueOf(choice);
        if(x.toBigInteger().mod(BigInteger.TEN).compareTo(BigInteger.valueOf(9))==0){
            System.out.println("GOTO Vasilisa.");
            answer = "GOTO Vasilisa.";
        } else {
            System.out.println(x.setScale(0, BigDecimal.ROUND_HALF_UP));
            answer = String.valueOf(x.setScale(0, BigDecimal.ROUND_HALF_UP));
        }
        return answer;
    }

    /**
     * @author Karl Laroya
     * Calculates the highest possible modulo using the numbers within the range
     * @param inputs An array of string inputs.
     * @return The array containing the highest possible modulus.
     */
    public static int[] theMiracleAndTheSleeper(String[] inputs ){
        System.out.println("The Miracle and The Sleeper Method");
        // BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        // int tests = Integer.parseInt(bufferedReader.readLine());
        int tests = Integer.parseInt(inputs[0]);
        int[] answersArray = new int[tests];

        for (int i = 0; i <= tests - 1; i++) {
            int a, b, d, highestModulo = 0;
            //    String inputs = bufferedReader.readLine();
            String input = inputs[i+1];
            String[] numbers = input.split(" ");

            int l = Integer.parseInt(numbers[0]);
            b = Integer.parseInt(numbers[1]);

            if (b % 2 == 0) {
                a = b / 2;
                a += 1;
            } else {
                a = (b + 1) / 2;
            }
            highestModulo = b % a;
            if (a < l) {
                d = l - a;
                highestModulo -= d;
            }

            answersArray[i] = highestModulo;
        }

        for (int z = 0; z <= answersArray.length - 1; z++) {
            System.out.println(answersArray[z]);
        }
        return answersArray;
    }//end of theMiracleAndTheSleeper

    /**
     * @author Karl Laroya
     * Calculates the needed votes of the losing candidate/s to win over the winning candidate/s with the highest votes.
     * @param inputs A String array containing the votes for the three candidates.
     * @return An array containing the votes needed for each candidate.
     */
    public static int[] elections(String[] inputs){
        System.out.println("Elections Method");
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        int tests = Integer.parseInt(bufferedReader.readLine());
        int tests = Integer.parseInt(inputs[0]);
        int[][] neededVotesSets = new int[tests][3];

        for (int i = 0; i <= tests - 1; i ++) {
//            String candidateVotes = bufferedReader.readLine();
            String candidateVotes = inputs[i+1];
            String[] votesArray = candidateVotes.split(" ");
            int candidateAVotes = Integer.parseInt(votesArray[0]);
            int candidateBVotes = Integer.parseInt(votesArray[1]);
            int candidateCVotes = Integer.parseInt(votesArray[2]);
            int candidateANeededVotes = 0;
            int candidateBNeededVotes = 0;
            int candidateCNeededVotes = 0;

            if (candidateAVotes <= Math.max(candidateBVotes, candidateCVotes)) {
                candidateANeededVotes += Math.max(candidateBVotes, candidateCVotes) + 1 - candidateAVotes;
            }
            if (candidateBVotes <= Math.max(candidateAVotes, candidateCVotes)) {
                candidateBNeededVotes = Math.max(candidateAVotes, candidateCVotes) + 1 - candidateBVotes;
            }
            if (candidateCVotes <= Math.max(candidateAVotes, candidateBVotes)) {
                candidateCNeededVotes = Math.max(candidateAVotes, candidateBVotes) + 1 - candidateCVotes;
            }

            neededVotesSets[i][0] = candidateANeededVotes;
            neededVotesSets[i][1] = candidateBNeededVotes;
            neededVotesSets[i][2] = candidateCNeededVotes;
        }

        int[] results = new int[tests*3];
        int i=0;
        for (int z = 0; z <= neededVotesSets.length - 1; z++) {
            System.out.println(neededVotesSets[z][0] + " " + neededVotesSets[z][1] + " " + neededVotesSets[z][2]);
            results[i] = neededVotesSets[z][0];
            results[i+1] = neededVotesSets[z][1];
            results[i+2] = neededVotesSets[z][2];
            i += 3;
        }
        return results;
    }//end of elections

}//end of Solutions class
//end of Solutions class
