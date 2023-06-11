import java.util.Scanner;
import java.util.regex.*;

public class InputStringValidator {
    public static void main(String[]args) throws Exception{
        InputStringValidator program;
        try{
            program = new InputStringValidator();
            program.run();
        } catch (Exception x){
            x.printStackTrace();
        }
        System.exit(0);
    }//end of main

    public void run(){
        Scanner keyboard = new Scanner(System.in);
        String regExpression = "([0]|[1-9]\\d*)?(\\.[0-9]\\d*)?";
        System.out.print("Enter the string to be checked: ");
        String input = keyboard.nextLine();
        System.out.print(input + " is ");
        if(isValidString(regExpression,input))
            System.out.println("a valid decimal string");
        else
            System.out.println("an invalid decimal string");
    }//end of run method

    public boolean isValidString(String regularExpression, String inputString){
        return Pattern.matches(regularExpression,inputString);
    }
}
