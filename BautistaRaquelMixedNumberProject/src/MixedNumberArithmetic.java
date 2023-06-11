import java.util.Scanner;


public class MixedNumberArithmetic {
    public static void main(String[] args){
        MixedNumberArithmetic myProgram;
        try{
            myProgram = new MixedNumberArithmetic();
            myProgram.run();
        } catch (Exception x){
            System.out.println(x.getMessage());
        }
        System.exit(0);
    }

    public void run(){
        Scanner keyboard = new Scanner(System.in);

        int operation = 0;

        do {
            operation = readChoice(1, 6);

            switch (operation) {
                case 1:
                    addMixedNumbers();
                    break;
                case 2:
                    subtractMixedNumbers();
                    break;
                case 3:
                    multiplyMixedNumber();
                    break:
                case 4:
                    divideMixedNumbers();
                    break;
                case 5:
                    convertMixedNumberToFraction();
                    break;
                case 6:
                    System.out.println("Thank you for using this program");
                    System.exit(0);
            }

            System.out.println("\n\npress enter to continue...");
            keyboard.nextLine();
        } while (operation>0 && operation <7);
    }

    public void showMenu(){
        System.out.println("This program helps you do arithmetic with Mixed Numbers.");
        System.out.println("Choose the operation to be performed.");
        System.out.println("1. Add Mixed Numbers.");
        System.out.println("2. Subtract Mixed Numbers.");
        System.out.println("3. Multiply Mixed Numbers.");
        System.out.println("4. Divide Mixed Numbers.");
        System.out.println("5. Convert a Mixed Number to a fraction.");
        System.out.println("6. Exit.");
    }

    public int readInteger(){
        Scanner scan = new Scanner(System.in);
        int result = 0;
        boolean validEntry = true;

        do{
            try{
                result = Integer.parseInt(scan.nextLine());
                validEntry = true;
            } catch (Exception ex){
                System.out.println("You have entered an invalid integer.");
                validEntry = false;
            }
        } while (!validEntry);
        return result;
    }

    public int readChoice(int low, int high){
        int choice = 0 ;
        do{
            showMenu();
            System.out.println("Pleade enter your choice <1/2/3/4/5/6> : ");
            choice = readInteger();
            if (choice<low || choice>high)
                System.out.println("The choices must be from " + low + "to " + high + ".");
        }  while (choice<low || choice>high);
        return choice;
    }

    public void addMixedNumbers(){
        int wholePart = 0;
        int numerator = 0;
        int denominator = 0;

        System.out.println("You want to add two mixed numbers.");
        System.out.println("Enter the whole number part of the first mixed number.");
        wholePart = readInteger();
        System.out.println("Enter the numerator of the fraction part of the first mixed number: ");
        numerator = readInteger();
        System.out.println("Enter the denominator of the fraction part of the first mixed number: ");
        denominator = readInteger();

        MixedNumber m1 = new MixedNumber(wholePart, new Fraction(numerator,denominator));

        System.out.println("Enter the whole number part of the second mixed number: ");
        wholePart = readInteger();
        System.out.println("Enter the numerator of the fraction part of the second mixed number: ");
        numerator = readInteger();
        System.out.println("Enter the denominator of the fraction part of the second mixed number: ");
        denominator = readInteger();

        MixedNumber m2 = new MixedNumber(wholePart, new Fraction(numerator,denominator));

        MixedNumber sum  = m1.add(m2);

        System.out.println("First Mixed Number = " + m1.toString());
        System.out.println("Second Mixed Number = " + m2.toString());
        System.out.println("Sum of Mixed Numbers = " + sum.toString());
        return;
    }

    public  void subtractMixedNumbers(){
        int wholePart = 0;
        int numerator = 0;
        int denominator = 0;

        System.out.println("You want to subtract two mixed numbers.");
        System.out.println("Enter the whole number part of the first number: ");
        wholePart = readInteger();
        System.out.println("Enter the numerator of the fraction part of the first mixed number: ");
        numerator = readInteger();
        System.out.println("Enter the denominator of the fraction part of the first mixed number: ");
        denominator = readInteger();

        MixedNumber m1 = new MixedNumber(wholePart, new Fraction(numerator,denominator));

        System.out.println("Enter the whole number part of the second mixed  number: ");
        wholePart = readInteger();
        System.out.println("Enter the numerator of the fraction part of the second mixed number: ");
        numerator = readInteger();
        System.out.println("Enter the denominator of the fraction part of the second mixed number: ");
        denominator = readInteger();

        MixedNumber m2 = new MixedNumber(wholePart, new Fraction(numerator,denominator));

        MixedNumber dif = m1.subtract(m2);

        System.out.println("First Mixed Number = " + m1.toString());
        System.out.println("Second Mixed Number = " + m2.toString());
        System.out.println("Difference of mixed Numbers = " + dif.toString());
        return;
    }

    public void multiplyMixedNumber(){

    }


}

