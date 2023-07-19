package cs223Exam;

import javax.management.StringValueExp;

public class ValidIdentifier {
    public static void main(String []args){
        System.out.println(isValid("R_"));

    }

    public static int isValid(String string){
        int result = 0;
        int idx = 0; //for character index in the string
        int state = 0; //start from state 0
        int input = 0; //input category : letter =0, digit=1, underscore=2, others=3
        int table[][] = {{1,2,1,2},{1,1,1,2},{2,2,2,2}};//finite automaton in table form
        while(string.length() < idx){
            switch (string.substring(idx)){
                case "\\[a-zA-Z]":
                    input = 0;
                    break;
                case "\\[0-9]":
                    input = 1;
                    break;
                case "_":
                    input = 2;
                    break;
                default:
                    input = 3;
            }//end of switc
             state = table[state][input];//what statement must be here?
            idx = idx + 1; // let idx point to the next character of string
        }//end of while
        if(state == 1){
            result = 1;
        }
        return result;
    }//end of function/method
}
