/**
 * @author Bautista, Raquel S.
 * 01/27/2020
 * 9:30-11:00 TF
 * D515
 */

import java.util.Scanner;

/**
 * This class enables the use of arithmetic operations to fractions.
 * It enables addition, subtraction, multiplication, division and reducing of fractions.
 */
public class FractionArithmetic{
    /**
     * This is the main method of the class.
     * @param args
     */
    public static void main(String[] args){
        /**
         * Creates two fractions.
         */
        Fraction fraction1 = new Fraction();
        Fraction fraction2 = new Fraction();
        int choice = 0;
        /**
         * Loop for the menu.
         * Shows the menu and enables the user to input choice.
         * Shows option for input, addition, subtraction, multiplication, division and reducing fractions.
        */
        while(choice!=8){
            showMenu();
            choice = readInteger();
            switch (choice){
                case 1:
                    System.out.println("Input value for Fraction 1.");
                    fraction1 = readFraction();
                    break;
                case 2:
                    System.out.println("Input value for Fraction 2.");
                    fraction2 = readFraction();
                    break;
                /**
                 * Calculates the sum of two fractions.
                 * Gets the decimal form of the sum.
                 * Outputs the results.
                 */
                case 3:
                    Fraction sum = fraction1.add(fraction2);
                    System.out.println(fraction1 + " + " + fraction2 + " = " + sum + " or " + sum.toDouble());
                    break;
                case 4:
                    subtractFractions(fraction1,fraction2);
                    break;
                case 5:
                    Fraction product = fraction1.multiply(fraction2);
                    System.out.println(fraction1 + " x " + fraction2 + " = " + product + " or " + product.toDouble());
                    break;
                case 6:
                    divideFractions(fraction1,fraction2);
                    break;
                case 7:
                    System.out.println("Input value of fraction to be reduced");
                    Fraction f = readFraction();
                    Fraction reduced = f.reduce();
                    System.out.println("Reduced: " + reduced + " or " + reduced.toDouble() );
                    break;
                case 8:
                    System.out.println("Thank you for using this program.");
                    System.exit(0);
            }
        }
    } // end of main

    /**
     * This method subtracts two fractions.
     * It also enables user to choose the fraction to subtract.
     * Outputs results including its decimal form
     * @param fraction1
     * @param fraction2
     */
    private static void subtractFractions(Fraction fraction1, Fraction fraction2){
        Fraction difference;
        double decimal;
        System.out.println("Please choose subtraction format.");
        System.out.println("1. " + fraction1 + " - " + fraction2);
        System.out.println("2. " + fraction2 + " - " + fraction1);
        int choice2 = readInteger();
        if(choice2==1){
            difference = fraction1.subtract(fraction2);
            System.out.println(fraction1 + " - " + fraction2 + " = " + difference + " or " + difference.toDouble());
        } else {
            difference = fraction2.subtract(fraction1);
            System.out.println(fraction2 + " - " + fraction1 + " = " + difference + " or " + difference.toDouble());
        }
    }

    /**
     * This method divides two fractions.
     * It also enables user to choose the dividend and divisor.
     * @param fraction1
     * @param fraction2
     */
    private static void divideFractions(Fraction fraction1, Fraction fraction2){
        Fraction quotient;
        System.out.println("Please choose dividend and divisor.");
        System.out.println("1. " + fraction1 + " / " + fraction2);
        System.out.println("2. " + fraction2 + " / " + fraction1);
        int choice3 = readInteger();
        if(choice3==1){
            quotient = fraction1.divide(fraction2);
            System.out.println(fraction1 + " / " + fraction2 + " = " + quotient + " or " + quotient.toDouble());
        }else{
            quotient = fraction2.divide(fraction1);
            System.out.println(fraction2 + " / " + fraction1 + " = " + quotient + " or " + quotient.toDouble());
        }
    }

    /**
     * This method shows the menu options for the arithmetic operations.
     */
    private static void showMenu() {
        System.out.println(".==================================. ");
        System.out.println("|MENU:                             |");
        System.out.println("|1. Input value for Fraction 1     |");
        System.out.println("|2. Input value for Fraction 2     |");
        System.out.println("|3. Add fractions                  |");
        System.out.println("|4. Subtract fractions             |");
        System.out.println("|5. Multiply fractions             |");
        System.out.println("|6. Divide fractions               |");
        System.out.println("|7. Reduce a fraction              |");
        System.out.println("|8. Exit                           |");
        System.out.println(".==================================.");
        System.out.println("Input choice from 1 to 8: ");
    }

    /**
     * This method enables user to input an integer.
     * It also checks the validity of the input.
     * @return
     */
    private static int readInteger(){
        Scanner keyboard = new Scanner(System.in);
        int integer = 0;
        Boolean valid=false;
        while(!valid){
            try{
                integer = Integer.parseInt(keyboard.next());
                valid = true;
            }catch (Exception x){
                System.out.println("Invalid entry.");
                valid = false;
            }
        }
        return integer;
    }

    /**
     * This method prompts user to input the value of numerator and denominator of the fraction.
     * It also checks the validity of the denominator.
     * @return
     */
    private static Fraction readFraction(){
        Fraction result = new Fraction();
        System.out.println("Input numerator: ");
        result.setNumerator(readInteger());
        System.out.println("Input denominator: ");
        result.setDenominator(readInteger());
        if(result.getDenominator()==0){
            System.out.println("Denominator cannot be equal to zero. Please input a valid denominator.");
            System.out.println("Input new denominator: ");
            result.setDenominator(readInteger());
        }
        return result;
    }
} // end of FractionArithmetic class