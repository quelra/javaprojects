//import java.util.Stack;
//
//public class InfixToPostFix {
//
//    private static int pointer = 0;
//
//    static String infixToPostFix(String expression){
//
//        String result = "";
//        Stack<Character> stack = new Stack<>();
//        for (int i = 0; i <expression.length() ; i++) {
//            char c = expression.charAt(i);
//
//            //check if char is operator
//            if(precedence(c)>0){
//                while(stack.isEmpty()==false && precedence(stack.peek())>=precedence(c)){
//                    result += stack.pop();
//                }
//                stack.push(c);
//            }else if(c==')'){
//                char x = stack.pop();
//                while(x!='('){
//                    result += x;
//                    x = stack.pop();
//                }
//            }else if(c=='('){
//                stack.push(c);
//            }else{
//                //character is neither operator nor (
//                result += c;
//            }
//        }
//        for (int i = 0; i <=stack.size() ; i++) {
//            result += stack.pop();
//        }
//        return result;
//    }
//
//    public static void main(String[] args) {
//        String exp = "A+B*(C^D-E)";
//        System.out.println("Infix Expression: " + exp);
//        System.out.println("Postfix Expression: " + infixToPostFix(exp));
//
//        System.out.println("Precedence: " + precedence('*','+'));
//        System.out.println("Precedence: " + precedence('+','/'));
//        System.out.println("Precedence: " + precedence('+','('));
//        System.out.println("Precedence: " + precedence('(','*'));
//        System.out.println("Precedence: " + precedence('+','*'));
//        System.out.println("Precedence: " + precedence('-','+'));
//        System.out.println("Precedence: " + precedence('-','('));
//
//    }
//
////public class MidtermDraftCodes {
////
////    /**
////     precedence(operator1, operator2) returns TRUE if operator1 has
////     precedence over operator2.
////     precedence(operator1, operator2) returns FALSE if operator1 does not
////     have precedence over operator2. Examples:
////     precedence( *, + ) = true
////     precedence( +, / ) = false
////     precedence( +, ( ) = false
////     precedence( (, * ) = false
////     */
//    public static boolean precedence(char operator1, char operator2){
//        if (operator1==')' || operator2=='('){
//            return false;
//        }
//        return precedence(operator1)>=precedence(operator2); // either greater than lang or >=
//    }
//
//    static int precedence(char c){
//        switch (c){
//            case '+':
//            case '-':
//                return 1;
//            case '*':
//            case '/':
//                return 2;
//            case '^':
//                return 3;
//        }
//        return -1;
//    }
//
//    public static Integer postfixToInfix(String postfixExpression){
//        LinkedStack<Integer> operandStack = new LinkedStack<Integer>(); //Integer for now
//        char symbol;
//        int operand1 = 0, operand2 = 0, value = 0;
//        while(pointer!=postfixExpression.length()){
//            symbol = nextToken(postfixExpression);
//            if(!isOperator(symbol)){
//                operandStack.push((int)symbol);
//            } else {
//                operand1 = (int)operandStack.pop();
//                operand2 = (int)operandStack.pop();
//                value = solve(operand1, operand2, String.valueOf(symbol));
//                operandStack.push(value);
//            }
//        }
//        return (operandStack.pop());
//    }
//
//    public static char nextToken(String expression){ // or extractSymbol?
//        char symbol;
//        symbol = expression.charAt(pointer);
//        pointer++;
//        return symbol;
//    }
//
//    /**
//     * Method for checking if a character is an operand or operator.
//     */
//    public static boolean isOperator(char symbol){
//        return symbol == '(' || symbol == ')' || symbol == '^' || symbol == '*' || symbol == '/' || symbol == '+' || symbol == '-';
//    }
//    public static int solve(int operand1, int operand2, String symbol){
//        switch(symbol){
//            case "/":
//                return operand1/operand2;//enter an exception for division by 0
//            case "*":
//                return operand1*operand2;
//            case "+":
//                return operand1+operand2;
//            case"-":
//                return operand1-operand2;
//            case "**":
//                return (int)Math.pow(operand1,operand2);
//
//        }
//        return 0;
//    }
//
//
//    /**
//     precedence(operator1, operator2) returns TRUE if operator1 has
//     precedence over operator2.
//     precedence(operator1, operator2) returns FALSE if operator1 does not
//     have precedence over operator2. Examples:
//     precedence( *, + ) = true
//     precedence( +, / ) = false
//     precedence( +, ( ) = false
//     precedence( (, * ) = false
//     */
//    public static boolean precedence(char operator1, char operator2){
//        if (operator1==')' || operator2=='('){
//            return false;
//        }
//        return precedence(operator1)>=precedence(operator2); // either greater than lang or >=
//    }
//
//    public static int precedence(char c){
//        switch (c){
//            case '+':
//            case '-':
//                return 1;
//            case '*':
//            case '/':
//                return 2;
//            case '^':
//                return 3;
//        }
//        return -1;
//    }
//
//    /**
//     * Method for the creation of the table that shows the symbol, postfixExpression, and operatorStack
//     */
//    public static void toTableInfixToPostfix(String infix){
//        System.out.println("====================================================");
//        System.out.println("Table of Infix to Postfix");
//        System.out.printf("%5s %30s %30s", "Symbol","postfixExpression","operatorStack\n");
//        for (int i =0; i < infix.length(); i++){
//            System.out.printf("%5s %30s %30s",infix.charAt(i),"postfix","operator"+"\n");
//        }
//    }
//
//    /**
//     * Method that creates a table showing symbol, operand1, operand2, value, operandStack
//     */
//    public static void toTablePostfixToInfix(String postfix){
//        System.out.println("====================================================");
//        System.out.println("Table of Postfix to Infix");
//        System.out.printf("%5s %20s %20s %20s %20s", "Symbol","operand1","operand2", "value", "operandStack");
//        for (int i =0; i < postfix.length(); i++){
//            System.out.printf("%5s %20s %20s %20s %20s",postfix.charAt(i),"operand1","operand2", "value"  , "operandStack"+"\n");
//        }
//    }
//
//
//}
////
////    public static int precedence(char symbol){
////        switch (symbol){
////            case '+':
////            case '-':
////                return 1;
////            case '*':
////            case '/':
////                return 2;
////            case '^':
////                return 3;
////        }
////        return -1;
////    }
////}
