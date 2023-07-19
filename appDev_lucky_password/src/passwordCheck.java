import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.*;

public class passwordCheck {
    public static void main(String[]args){
        /*
        the password length is at least 5 characters;
        the password contains at least one large English letter;
        the password contains at least one small English letter;
        the password contains at least one digit.
         */
        /*
        Input
        The first line contains a non-empty sequence of characters (at most 100 characters). Each character is
        either a large English letter, or a small English letter, or a digit, or one of characters: "!", "?", ".", ",", "_".

        Output
        If the password is complex enough, print message "Correct" (without the quotes), otherwise print message "Too weak" (without the quotes).
         */

        Scanner scan = new Scanner(System.in);
        String password = scan.nextLine();

        String regex = "(?=.*[A-Z])(?=.*[a-z])^(?=.*[0-9]).{5,100}$";

        if(Pattern.matches(regex,password)){
            System.out.println("Correct");
        }else{
            System.out.println("Too weak");
        }
    }
}
