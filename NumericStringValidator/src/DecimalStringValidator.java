/*** On Java Regular Expression
 * 1. [] is used to enclose characters from which one will be chosen
 * 2. ? is used to indicate an optional part
 * 3. | denotes or
 * 4. \\d is an escape sequence to mean a decimal digit rather than the character of
 * 5. () is used for grouping a sequence
 * 6. \\. is an escape sequence to mean the decimal point
 * 7. - is used to specify a range of characters depending on the sequential arrangement
 * of characters in the Unicode Character set. Hence, 0-9 refers to the numerals from 1 to 9.
 */

import java.util.regex.Pattern;
import java.util.Scanner;

public class DecimalStringValidator {
    /**
     * 1. Construct an object of Scanner that will be used to reference an entry from the keyboard.
     * 2. Create a regular expression representing valid decimal numerical string
     * 3. Read the string
     * 4. if the string matches the regular expression for a valid decimal numerical string
     *          print "valid decimal string"
     *      else
     *          print "invalid decimal string"
     * 5. exit
     */
    public static void main(String[]args)throws Exception{
        Scanner keyboard = new Scanner(System.in);
        String regex = "([0]|[1-9]\\d*)?(\\.[0-9]\\d*)?";
        System.out.print("Enter the string to be checked: ");
        String input = keyboard.nextLine();
        System.out.print(input + " is ");
        if(Pattern.matches(regex,input))
            System.out.println("a Valid decimal string");
        else
            System.out.println("an Invalid decimal string");
        System.exit(0);
    }//end of main method
}//end of class
