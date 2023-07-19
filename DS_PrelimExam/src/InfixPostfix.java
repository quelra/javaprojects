import java.util.Scanner;

public class InfixPostfix {

    private static int pointer = 0;
    public static void main(String [] args) throws StackException{
        Scanner input = new Scanner(System.in);
        try {
            run();
        } catch (Exception e) {

        }
    }

    public static void run() {
        menu();
    }

    public static void menu() {
        System.out.println("*=*=*=*=*=*=*=*=*=*=*=*=*=*=*");
        System.out.println("             MENU            ");
        System.out.println("=============================");
        System.out.println("1: Infix to Postfix          ");
        System.out.println("2: Postfix to Infix          ");
        System.out.println("0: Exit                      ");
        System.out.println("=============================");
        int choice = userChoice(0, 2);

        switch (choice) {
            case 0 :
                System.exit(0);
                break;
            case 1:
                infixPrompt();
                break;
            case 2:
                postfixPrompt();
                break;
        }
    }

    // I'll loop itong mga toh in the future, make sure nalang muna natin na gumagana yung mga utility methods.
    public static void infixPrompt() {
        Scanner input = new Scanner(System.in); // might put this scanner on a method
        System.out.println("\n*=*=*=*=*=*=*=*=*=*=*=*=*=*=*");
        System.out.println("       INFIX - POSTFIX       ");
        System.out.println("=============================");
        System.out.println("Infix Expression: ");
        String infix = input.nextLine();
        System.out.println("Postfix Expression: " + infixToPostfix(infix));
        toTableInfixToPostfix(infix);
    }

    public static void postfixPrompt() {
        Scanner input = new Scanner(System.in); // might put this scanner on a method
        System.out.println("\n*=*=*=*=*=*=*=*=*=*=*=*=*=*=*");
        System.out.println("       POSTFIX - INFIX       ");
        System.out.println("=============================");
        System.out.println("Post Expression: ");
        String postfix = input.nextLine();
        System.out.println("Infix Expression: " + postfixToInfix(postfix));
        toTablePostfixToInfix(postfix);
    }

    public static int userChoice(int minimum, int maximum) {
        Scanner input = new Scanner(System.in);
        String message = "Input number of choice: ";
        int choice;

        while (true) {
            try {
                System.out.print(message);
                choice = input.nextInt();
                if (choice >= minimum && choice <= maximum) {
                    return choice;
                } else {
                    throw new InputMismatchException();
                }
            } catch (InputMismatchException e) {
                message = "Input number from " + minimum + " to " + maximum + ": ";
            }
        }
    }

    /**
     * Method that converts an infix expression to postfix expression.
     *
     * ** Algorithm from module notes:
     *      *     PROCESS:
     *      *     postfixExpression = empty String
     *      *     operatorStack = empty stack
     *      *     while (not end of infixExpression) {
     *      *         symbol = next token
     *      *         if (symbol is an operand)
     *      *             concatenate symbol to postfixExpression
     *      *          else { // symbol is an operator
     *      *             while (not operatorStack.empty() &&
     *      *                 precedence(operatorStack.peek(),symbol) {
     *      *                 topSymbol = operatorStack.pop();
     *      *                 concatenate topSymbol to postfixExpression;
     *      *             } // end while
     *      *
     *      *             if (operatorStack.empty() || symbol != ‘)’ )
     *      *                 operatorStack.push(symbol);
     *      *             else // pop the open parenthesis and discard it
     *      *                 topSymbol = operatorStack.pop();
     *      *         } // end else
     *      *     } // end while
     *      *     // get all remaining operators from the stack
     *      *     while (not operatorStack.empty) {
     *      *         topSymbol = operatorStack.pop();
     *      *         concatenate topSymbol to postfixExpression
     *      *     } // end while
     *      *      return postfixExpression
     */
    public static String infixToPostfix(String infixExpression){
        //in development (refer to the algorithm)
        String postfixExpression = ""; //output
        LinkedStack<Character> operatorStack = new LinkedStack<Character>(); //stack
        char symbol, topSymbol;
        //implement algorithm and methods
        while(pointer != infixExpression.length()){ // //while (not end of infixExpression) {
            symbol = nextToken(infixExpression); //symbol = next token
            if(!isOperator(symbol)){  //if (symbol is an operand)
                postfixExpression += symbol; //concatenate symbol to postfixExpression
            } else { // else { // symbol is an operator
                while(!operatorStack.isEmpty() && precedence(operatorStack.peek(),symbol)){ //while (not operatorStack.empty() && precedence(operatorStack.peek(),symbol) {
                    topSymbol = operatorStack.pop(); //topSymbol = operatorStack.pop();
                    if(topSymbol != '('){
                        postfixExpression += topSymbol; // concatenate topSymbol to postfixExpression;
                    }
                } // } // end while
                if (operatorStack.isEmpty() || symbol != ')'){ // if (operatorStack.empty() || symbol != ‘)’ );
                    operatorStack.push(symbol); //operatorStack.push(symbol);
                } else { // pop the open parenthesis and discard it
                    topSymbol = operatorStack.pop(); //topSymbol = operatorStack.pop();
                }
            }  // end else
        } // end while

        // get all remaining operators from the stack
        while (!operatorStack.isEmpty()) { //while (not operatorStack.empty) {
            topSymbol = operatorStack.pop(); //topSymbol = operatorStack.pop();
            postfixExpression += topSymbol; //concatenate topSymbol to postfixExpression
        } // end while
        return postfixExpression;
    }


    /**
     * Method that converts a postfix expression to infic expression.
     */
    public static Integer postfixToInfix(String postfixExpression){
        LinkedStack<Integer> operandStack = new LinkedStack<Integer>(); //Integer for now
        char symbol;
        int operand1 = 0, operand2 = 0, value = 0;
        while(pointer!=postfixExpression.length()){
            symbol = nextToken(postfixExpression);
            if(!isOperator(symbol)){
                operandStack.push((int)symbol);
            } else {
                operand2 = (int)operandStack.pop();
                operand1 = (int)operandStack.pop();
                value = solve(operand1, operand2, String.valueOf(symbol));
                operandStack.push(value);
            }
        }
        return (operandStack.pop());
    }

    public static int solve(int operand1, int operand2, String symbol){
        switch(symbol){
            case "/":
                return operand1/operand2;//enter an exception for division by 0
            case "*":
                return operand1*operand2;
            case "+":
                return operand1+operand2;
            case"-":
                return operand1-operand2;
            case "$":
                return (int)Math.pow(operand1,operand2);

        }
        return 0;
    }

    /**
     * Method for extracting the symbol.
     */
    public static char nextToken(String expression){ // or extractSymbol?
        char symbol;
        symbol = expression.charAt(pointer);
        pointer++;
        return symbol;
    }

    /**
     * Method for checking if a character is an operand or operator.
     */
    public static boolean isOperator(char symbol){
        return symbol == '(' || symbol == ')' || symbol == '^' || symbol == '*' || symbol == '/' || symbol == '+' || symbol == '-';
    }


    /**
    precedence(operator1, operator2) returns TRUE if operator1 has
    precedence over operator2.
    precedence(operator1, operator2) returns FALSE if operator1 does not
    have precedence over operator2. Examples:
    precedence( *, + ) = true
    precedence( +, / ) = false
    precedence( +, ( ) = false
    precedence( (, * ) = false
     */
    public static boolean precedence(char operator1, char operator2){
        if (operator1==')' || operator2=='('){
            return false;
        }
        return precedence(operator1)>=precedence(operator2); // either greater than lang or >=
    }

    static int precedence(char c){
        switch (c){
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    /**
     * Method for the creation of the table that shows the symbol, postfixExpression, and operatorStack
     */
    public static void toTableInfixToPostfix(String infix){
        System.out.println("====================================================");
        System.out.println("Table of Infix to Postfix");
        System.out.printf("%5s %30s %30s", "Symbol","postfixExpression","operatorStack\n");
        for (int i =0; i < infix.length(); i++){
            System.out.printf("%5s %30s %30s",infix.charAt(i),"postfix","operator"+"\n");
        }
    }

    /**
     * Method that creates a table showing symbol, operand1, operand2, value, operandStack
     */
    public static void toTablePostfixToInfix(String postfix){
        System.out.println("====================================================");
        System.out.println("Table of Postfix to Infix");
        System.out.printf("%5s %20s %20s %20s %20s", "Symbol","operand1","operand2", "value", "operandStack");
        for (int i =0; i < postfix.length(); i++){
            System.out.printf("%5s %20s %20s %20s %20s",postfix.charAt(i),"operand1","operand2", "value"  , "operandStack"+"\n");
        }
    }

    //more methods here
}//end of InfixPostfix class
