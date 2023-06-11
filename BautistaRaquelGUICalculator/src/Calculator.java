import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This is a program for a GUI Calculator which enables users to perform basic arithmetic operations.
 */
public class Calculator extends JFrame{
    private JFrame frame;

    private JTextField displayTextField, inputTextField, simplifiedExp;

    private JLabel nameLabel;

    private JButton clearB, eraseB, equalsB, dotB, exitB, CEB;
    private JButton divideB, multiplyB, subtractB, addB;
    private JButton b7, b8, b9, b4, b5, b6, b1, b2, b3, b0;
    private JButton xSquare, xCube, raiseTo, sin, cos, tan, squareRoot, log, mod, pi, factorial;

    private JPanel screenPanel;
    private JPanel buttonPanel;
    private JPanel mainPanel;

    /**
     * The main method for the program. Creates a Calculator object named program and launches it.
     * @param args
     */
    public static void  main(String[] args){

        Calculator program;
        try{
            program = new Calculator();
            program.launch();
        }catch (Exception x){
            x.printStackTrace();
        }
    }

    /**
     * Sets the frame to be visible.
     */
    public void launch(){
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * This contains adn organizes the components and containers of the GUI program.
     * 1. Instantiate frame, event handler, text fields (displayTextField, inputTextField and simplifiedEx)
     *      displayTextField shows all the values and operators inputted
     *      inputTextField is for current inputs by the user
     *      simplifiedEx is the simplified version of the displayTextField to used for the final computation
     * 2. Instantiate and add ActionListeners to buttons (clear, erase, equals, dot, exit, CE, divide, multiply, subtract, add,
     *      7,8,9,4,5,6,1,2,3,0, x^2, x^3, x^y, sin, cos, tan, squareRoot, log,pi,factorial)
     * 3. Instantiate panels screenPanel and add components displayTextField and inputTextField)
     * 4. Instantiate buttonPanel and add components.
     * 5. Instantiate mainPanel and add screenPanel and buttonPanel.
     *
     * designs were also included
     */
    public Calculator(){

        frame = new JFrame("Calculator");
        ButtonsHandler handler = new ButtonsHandler();

        nameLabel = new JLabel("by Raquel Bautista");
        nameLabel.setForeground(Color.lightGray);
        nameLabel.setHorizontalAlignment(JLabel.RIGHT);
        nameLabel.setVerticalAlignment(JLabel.TOP);

        Font font1 = new Font("a",Font.BOLD,15);
        Font font2 = new Font("c", Font.PLAIN,15);
        Font font3 = new Font("a",Font.BOLD,30);
        Font font4 = new Font("a", Font.BOLD,15);
        Font font5 = new Font("a", Font.BOLD,10);

        displayTextField = new JTextField(10);
        displayTextField.setFont(font1);
        displayTextField.setEditable(false);
        displayTextField.setBackground(Color.DARK_GRAY);
        displayTextField.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
        displayTextField.setForeground(Color.white);
        displayTextField.setHorizontalAlignment(JTextField.RIGHT);

        simplifiedExp = new JTextField(10);
        simplifiedExp.setFont(font5);
        simplifiedExp.setEditable(false);
        simplifiedExp.setBackground(Color.DARK_GRAY);
        simplifiedExp.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
        simplifiedExp.setForeground(Color.gray);
        simplifiedExp.setHorizontalAlignment(JTextField.RIGHT);

        inputTextField = new JTextField(20);
        inputTextField.setEditable(false);
        inputTextField.setBackground(Color.DARK_GRAY);
        inputTextField.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
        inputTextField.setForeground(Color.white);
        inputTextField.setFont(font3);
        inputTextField.setHorizontalAlignment(JTextField.RIGHT);

        clearB = new JButton("C");
        clearB.setFont(font2);
        clearB.setBackground(Color.lightGray);
        clearB.addActionListener(handler);

        eraseB = new JButton("\u2190");
        eraseB.setFont(font2);
        eraseB.setBackground(Color.lightGray);
        eraseB.addActionListener(handler);

        equalsB = new JButton("=");
        equalsB.setFont(font2);
        equalsB.setBackground(Color.lightGray);
        equalsB.addActionListener(handler);

        dotB = new JButton(".");
        dotB.setFont(font2);
        dotB.setBackground(Color.lightGray);
        dotB.addActionListener(handler);

        exitB = new JButton("Exit");
        exitB.setFont(font2);
        exitB.setBackground(Color.lightGray);
        exitB.addActionListener(handler);

        CEB = new JButton("CE");
        CEB.setFont(font2);
        CEB.setBackground(Color.lightGray);
        CEB.addActionListener(handler);

        divideB = new JButton("\u00F7");
        divideB.setFont(font2);
        divideB.setBackground(Color.lightGray);
        divideB.addActionListener(handler);

        multiplyB = new JButton("x");
        multiplyB.setFont(font2);
        multiplyB.setBackground(Color.lightGray);
        multiplyB.addActionListener(handler);

        subtractB = new JButton("-");
        subtractB.setFont(font2);
        subtractB.setBackground(Color.lightGray);
        subtractB.addActionListener(handler);

        addB = new JButton("+");
        addB.setFont(font2);
        addB.setBackground(Color.lightGray);
        addB.addActionListener(handler);

        b7 = new JButton("7");
        b7.setFont(font4);
        b7.setBackground(Color.lightGray);
        b7.addActionListener(handler);

        b8 = new JButton("8");
        b8.setFont(font4);
        b8.setBackground(Color.lightGray);
        b8.addActionListener(handler);

        b9 = new JButton("9");
        b9.setFont(font4);
        b9.setBackground(Color.lightGray);
        b9.addActionListener(handler);

        b4 = new JButton("4");
        b4.setFont(font4);
        b4.setBackground(Color.lightGray);
        b4.addActionListener(handler);

        b5 = new JButton("5");
        b5.setFont(font4);
        b5.setBackground(Color.lightGray);
        b5.addActionListener(handler);

        b6 = new JButton("6");
        b6.setFont(font4);
        b6.setBackground(Color.lightGray);
        b6.addActionListener(handler);

        b1 = new JButton("1");
        b1.setFont(font4);
        b1.setBackground(Color.lightGray);
        b1.addActionListener(handler);

        b2 = new JButton("2");
        b2.setFont(font4);
        b2.setBackground(Color.lightGray);
        b2.addActionListener(handler);

        b3 = new JButton("3");
        b3.setFont(font4);
        b3.setBackground(Color.lightGray);
        b3.addActionListener(handler);

        b0 = new JButton("0");
        b0.setFont(font4);
        b0.setBackground(Color.lightGray);
        b0.addActionListener(handler);

        // xSquare, xCube, raiseTo, sin, cos, tan, squareRoot, log, mod, pi, factorial;
        xSquare = new JButton("x\u00B2");
        xSquare.setBackground(Color.lightGray);
        xSquare.setFont(font2);
        xSquare.addActionListener(handler);

        xCube = new JButton("x\u00B3");
        xCube.setBackground(Color.lightGray);
        xCube.setFont(font2);
        xCube.addActionListener(handler);

        raiseTo = new JButton("^");
        raiseTo.setBackground(Color.lightGray);
        raiseTo.setFont(font2);
        raiseTo.addActionListener(handler);

        sin = new JButton("sin");
        sin.setBackground(Color.lightGray);
        sin.setFont(font2);
        sin.addActionListener(handler);

        cos = new JButton("cos");
        cos.setBackground(Color.lightGray);
        cos.setFont(font2);
        cos.addActionListener(handler);

        tan = new JButton("tan");
        tan.setBackground(Color.lightGray);
        tan.setFont(font2);
        tan.addActionListener(handler);

        squareRoot = new JButton("\u221A");
        squareRoot.addActionListener(handler);
        squareRoot.setBackground(Color.lightGray);
        squareRoot.setFont(font2);

        log = new JButton("log");
        log.setBackground(Color.lightGray);
        log.setFont(font2);
        log.addActionListener(handler);

        mod = new JButton("");
        mod.setBackground(Color.lightGray);
        mod.setFont(font2);
        mod.addActionListener(handler);

        pi = new JButton("\u03C0");
        pi.setBackground(Color.lightGray);
        pi.setFont(font2);
        pi.addActionListener(handler);

        factorial = new JButton("n!");
        factorial.setBackground(Color.lightGray);
        factorial.setFont(font2);
        factorial.addActionListener(handler);

        screenPanel = new JPanel();
        screenPanel.setLayout(new GridLayout(4,1));
        screenPanel.setBackground(Color.DARK_GRAY);
        screenPanel.add(nameLabel);
        screenPanel.add(simplifiedExp);
        screenPanel.add(displayTextField);
        screenPanel.add(inputTextField);

        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(6,5));
        buttonPanel.setBorder(BorderFactory.createLineBorder(Color.BLUE));

        // xSquare, xCube, raiseTo, sin, cos, tan, squareRoot, log, mod, pi, factorial;
        buttonPanel.add(xSquare);
        buttonPanel.add(xCube);
        buttonPanel.add(sin);
        buttonPanel.add(cos);
        buttonPanel.add(tan);

        buttonPanel.add(raiseTo);
        buttonPanel.add(clearB);
        buttonPanel.add(CEB);
        buttonPanel.add(eraseB);
        buttonPanel.add(squareRoot);

        buttonPanel.add(log);
        buttonPanel.add(b7);
        buttonPanel.add(b8);
        buttonPanel.add(b9);
        buttonPanel.add(divideB);

        buttonPanel.add(mod);
        buttonPanel.add(b4);
        buttonPanel.add(b5);
        buttonPanel.add(b6);
        buttonPanel.add(multiplyB);

        buttonPanel.add(pi);
        buttonPanel.add(b1);
        buttonPanel.add(b2);
        buttonPanel.add(b3);
        buttonPanel.add(subtractB);

        buttonPanel.add(factorial);
        buttonPanel.add(dotB);
        buttonPanel.add(b0);
        buttonPanel.add(equalsB);
        buttonPanel.add(addB);


        mainPanel = new JPanel(new GridLayout(2,1));
        mainPanel.add(screenPanel);
        mainPanel.add(buttonPanel);
        Container pane = frame.getContentPane();
        pane.add(mainPanel);
    }

    /**
     * The event handler / listeners for the buttons.
     *
     * 1. exit button exits the window
     * 2. clear button sets the value of input1=0, input2=0,currentOperator="", currentResult=0, displaytextField="",inputTextField="".
     * 3. CE button clears only the inputtedTextField
     * 4. erase button removes the last inputted value
     * 5. number buttons (1,2,3,4,5,6,7,8,9,0) concatenates the value to the inputTextField
     * 6. if an operator is not yet entered then the inputted digit becomes input1
     *      else becomes input2 .
     * 7. processArithmetic and processArithmetic2 are used to keep track of the currentResult while the equals button
     *  is not yet entered(only limited to 2 inputs)
     * 8. the solveArithmetic and solveOtherOperators are used to solve for multiple inputs including inputs with scientific operators
     * 9. The operator buttons (/,*,-,+) sets the specific value of the currentOperator and processes it.
     * 10. The scientific operators buttons (x^2, x^3, x^y, sin, cos, tan, squareroot, pi, log, factorial) concatenates the
     *      said operator together with their values and solves it using the methods in the CalculatorUtility.
     *      The solved values are shown in the simplifiedExp TextFieldd while the concatenated ones are shown in the displayTextField.
     * 11. equals button displays the result to the inputTextField, clears the displayTextField, clears the simplifiedEx TextField, sets input1 the value of the result
     *     , set currentOperator="", and sets input2 =0.
     * 12. dot button adds a dot to the inputTextField to indicate a decimal number.
     */
    class ButtonsHandler implements ActionListener{
        double input2 =0, input1 =0;
        double currentResult=0;
        long currentResult1 = 0;
        String currentOperator="";
        boolean changeOpBasis = true, changeOperator = false, arithmeticPossible1 = false, addInput = true;

        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == exitB) {
                System.exit(0);
            }
            if (e.getSource() == clearB) {
                input2 = 0;
                input1 = 0;
                currentOperator = "";
                currentResult = 0;
                currentResult1 = 0;
                displayTextField.setText("");
                inputTextField.setText("");
                simplifiedExp.setText("");
                addInput = true;
            }
            if (e.getSource() == CEB) {
                inputTextField.setText("");
                addInput = true;
            }
            if(e.getSource() == eraseB){
                int length = inputTextField.getText().length();
                try {
                    inputTextField.setText(inputTextField.getText().substring(0, length - 1));
                } catch (Exception ex){
                    ex.getMessage();
                }
                addInput = true;
            }

            if (e.getSource() == b7) {
                if(!addInput){
                    simplifiedExp.setText("");
                    displayTextField.setText("");
                    inputTextField.setText("");
                    addInput = true;
                }
                input('7');
            }
            if (e.getSource() == b8) {
                if(!addInput){
                    simplifiedExp.setText("");
                    displayTextField.setText("");
                    inputTextField.setText("");
                    addInput = true;
                }
                input('8');
            }
            if (e.getSource() == b9) {
                if(!addInput){
                    simplifiedExp.setText("");
                    displayTextField.setText("");
                    inputTextField.setText("");
                    addInput = true;
                }
                input('9');
            }
            if (e.getSource() == b4) {
                if(!addInput){
                    simplifiedExp.setText("");
                    displayTextField.setText("");
                    inputTextField.setText("");
                    addInput = true;
                }
                input('4');
            }
            if (e.getSource() == b5) {
                if(!addInput){
                    simplifiedExp.setText("");
                    displayTextField.setText("");
                    inputTextField.setText("");
                    addInput = true;
                }
                input('5');
            }
            if (e.getSource() == b6) {
                if(!addInput){
                    simplifiedExp.setText("");
                    displayTextField.setText("");
                    inputTextField.setText("");
                    addInput = true;
                }
                input('6');
            }
            if (e.getSource() == b1) {
                if(!addInput){
                    simplifiedExp.setText("");
                    displayTextField.setText("");
                    inputTextField.setText("");
                    addInput = true;
                }
                input('1');
            }
            if (e.getSource() == b2) {
                if(!addInput){
                    simplifiedExp.setText("");
                    displayTextField.setText("");
                    inputTextField.setText("");
                    addInput = true;
                }
                input('2');
            }
            if (e.getSource() == b3) {
                if(!addInput){
                    simplifiedExp.setText("");
                    displayTextField.setText("");
                    inputTextField.setText("");
                    addInput = true;
                }
                input('3');
            }
            if (e.getSource() == b0) {
                if(!addInput){
                    simplifiedExp.setText("");
                    displayTextField.setText("");
                    inputTextField.setText("");
                    addInput = true;
                }
                input('0');
            }

            if (currentOperator.equals("") && !inputTextField.getText().equals("") ) {
                input1 = Float.parseFloat(inputTextField.getText());

            }
            else if (!currentOperator.equals("") && !inputTextField.getText().equals("")){
                input2 = Float.parseFloat(inputTextField.getText());
                arithmeticPossible1 = true;
            }
            currentResult = processArithmetic(input1, currentOperator, input2);
            currentResult1= processArithmetic2(input1, currentOperator, input2);


            /**DIVIDE BUTTON
            If the divide button is clicked,
                    1. if there was a previously entered operator but not division and the inputTextField is empty,
                        assign "/" as currentOperator
                        modify simplifiedExp and displayTextField
                        call method processOperator
                    2. else if the currentOperator is already "/" and inputTextField is empty
                        currentOperator = "/" (this is to avoid repetition of the operator when clicked multiple times)
                    3. else
                         currentOperator = "/";
                         processOperator(currentOperator);
                    4. addInput becomes true (to allow the new inputted number to be concatenated)
             */
            if (e.getSource() == divideB) {
                if(currentOperator!="/" && inputTextField.getText().equals("") && currentOperator!=""){
                    currentOperator = "/";
                    simplifiedExp.setText(simplifiedExp.getText().substring(0,simplifiedExp.getText().length()-3));
                    displayTextField.setText(displayTextField.getText().substring(0,displayTextField.getText().length()-3));
                    processOperator(currentOperator);
                } else if(currentOperator=="/" && inputTextField.getText().equals("")) {
                    currentOperator = "/";
                } else {
                    currentOperator = "/";
                    processOperator(currentOperator);
                }
                addInput = true;

            }
            /**MULTIPLY BUTTON
             1. if there was a previously entered operator but not multiplication and the inputTextField is empty,
                assign "*" as currentOperator
                modify simplifiedExp and displayTextField
                 call method processOperator
             2. else if the currentOperator is already "*" and inputTextField is empty
                 currentOperator = "*" (this is to avoid repetition of the operator when clicked multiple times)
             3. else
                currentOperator = "*";
                processOperator(currentOperator);
             4. addInput becomes true (to allow the new inputted number to be concatenated)
             */
            if (e.getSource() == multiplyB) {
                if(currentOperator!="*" && inputTextField.getText().equals("") && currentOperator!=""){
                    currentOperator = "*";
                    simplifiedExp.setText(simplifiedExp.getText().substring(0,simplifiedExp.getText().length()-3));
                    displayTextField.setText(displayTextField.getText().substring(0,displayTextField.getText().length()-3));
                    processOperator(currentOperator);
                } else if(currentOperator=="*" && inputTextField.getText().equals("")){
                    currentOperator = "*";
                } else {
                    currentOperator = "*";
                    processOperator(currentOperator);
                }
                addInput = true;
            }
            /**SUBTRACT BUTTON
             1. if there was a previously entered operator but not subtraction and the inputTextField is empty,
                assign "-" as currentOperator
                modify simplifiedExp and displayTextField
                call method processOperator
             2. else if the currentOperator is already "-" and inputTextField is empty
                currentOperator = "-" (this is to avoid repetition of the operator when clicked multiple times)
             3. else
                currentOperator = "-";
                 processOperator(currentOperator);
             4. addInput becomes true (to allow the new inputted number to be concatenated)
             */
            if (e.getSource() == subtractB)    {
                if(currentOperator!="-" && inputTextField.getText().equals("") && currentOperator!=""){
                    currentOperator = "-";
                    simplifiedExp.setText(simplifiedExp.getText().substring(0,simplifiedExp.getText().length()-3));
                    displayTextField.setText(displayTextField.getText().substring(0,displayTextField.getText().length()-3));
                    processOperator(currentOperator);
                } else if(currentOperator=="-" && inputTextField.getText().equals("")){
                    currentOperator = "-";
                } else {
                    currentOperator = "-";
                    processOperator(currentOperator);
                }
                addInput = true;

            }
            /**ADD BUTTON
             1. if there was a previously entered operator but not addition and the inputTextField is empty,
                assign "+" as currentOperator
                modify simplifiedExp and displayTextField
                 call method processOperator
             2. else if the currentOperator is already "+" and inputTextField is empty
                currentOperator = "+" (this is to avoid repetition of the operator when clicked multiple times)
             3. else
                currentOperator = "+";
                processOperator(currentOperator);
             4. addInput becomes true (to allow the new inputted number to be concatenated)
             */
            if (e.getSource() == addB) {
                if(currentOperator!="+" && inputTextField.getText().equals("") && currentOperator!=""){
                    currentOperator = "+";
                    simplifiedExp.setText(simplifiedExp.getText().substring(0,simplifiedExp.getText().length()-3));
                    displayTextField.setText(displayTextField.getText().substring(0,displayTextField.getText().length()-3));
                    processOperator(currentOperator);
                } else if(currentOperator=="+" && inputTextField.getText().equals("")){
                    currentOperator = "+";
                } else {
                    currentOperator = "+";
                    processOperator(currentOperator);
                }
                addInput = true;
            }

            /** EQUALS
             * 1. Get the string value of the simplifiedExp and calculate and final result using the solveArithmetic method in the
             *      CalculatorUtility class
             * 2. Reset the text fields displayTextField and simpliedExp
             * 3. input1 gets the value of currentResult, currentOperator = "", input2 = 0, addInput = false;
             *
             */
            if (e.getSource() == equalsB) {
                currentResult = CalculatorUtility.solveArithmetic(simplifiedExp.getText()+inputTextField.getText());
                displayTextField.setText("");
                simplifiedExp.setText("");

                try {
                    if ((long) currentResult == 0) {
                        inputTextField.setText("" + currentResult % 1); //So it only shows the decimal portion
                    } else {
                        inputTextField.setText("" + (long) currentResult + "" + String.valueOf(currentResult % 1).replaceFirst("(\\+|\\-)?+0.", "."));  //Concatenate the long data type of currentResult to its fraction part using the double type of currentResult
                    }
                } catch (Exception Ignored) {
                }

                input1 = currentResult;
                currentOperator = "";
                input2 = 0;
                addInput = false;
            }


            //Concatenates the value of pi to the inputTextField
            if (e.getSource() == pi){
                inputTextField.setText(""+Math.PI);
                addInput = false;
            }

            //concatenates "." to the inputTextField to indicate decimal point
            if (e.getSource() == dotB) {
                inputTextField.setText(inputTextField.getText() + ".");
            }

            /** SQUARED
             *   1. if the inputTextField is empty
             *          concatenate the calculated value of 0^2 to the simplifiedExp
             *          concatenate the expression to the displayTextField
             *   3. else
             *           concatenate the calculated value of x^2 to the simplifiedExp
             *           concatenate the expression to the displayTextField
             *   4. set the inputTextField and currentOperator to ""
             *   5. set addInput to false so the displays or text fields will automatically
             *      reset when new values or numbers are entered and no operator is not entered
             */

            if (e.getSource() == xSquare){
                if(inputTextField.getText().equals("")){
                    simplifiedExp.setText(simplifiedExp.getText() +  CalculatorUtility.solveOtherOperators("sqr(0)"));
                    displayTextField.setText(displayTextField.getText() + "sqr(0)");
                }else {
                    simplifiedExp.setText(simplifiedExp.getText() +  CalculatorUtility.solveOtherOperators("sqr(" +  inputTextField.getText() +")"));
                    displayTextField.setText(displayTextField.getText() + "sqr(" +  inputTextField.getText() +")");

                }
                inputTextField.setText("");
                currentOperator="";
                addInput=false;
            }

            /** CUBE
             *   1.if the inputTextField is empty
             *          concatenate the calculated value of 0^3 to the simplifiedExp
             *          concatenate the expression "cube(0)" to the displayTextField
             *   3. else
             *           concatenate the calculated value of x^3 to the simplifiedExp
             *           concatenate the expression to the displayTextField
             *   4. set the inputTextField and currentOperator to ""
             *   5. set addInput to false so the displays or text fields will automatically
             *      reset when new values or numbers are entered and no operator is not entered
             */
            if (e.getSource() == xCube){
                if(inputTextField.getText().equals("")){
                    simplifiedExp.setText(simplifiedExp.getText() + CalculatorUtility.solveOtherOperators("cube(0)"));
                    displayTextField.setText(displayTextField.getText() + "cube(0)");
                }else {
                    simplifiedExp.setText(simplifiedExp.getText() + CalculatorUtility.solveOtherOperators("cube(" + inputTextField.getText() + ")"));
                    displayTextField.setText(displayTextField.getText() + ("cube(" + inputTextField.getText() + ")"));
                }
                inputTextField.setText("");
                currentOperator="";
                addInput=false;
            }

            /** SIN
             *   1.if the inputTextField is empty
             *          concatenate the calculated value of "sin(0)" to the simplifiedExp
             *          concatenate the expression ""sin(0)"" to the displayTextField
             *   3. else
             *           concatenate the calculated value of "sin(x)" to the simplifiedExp
             *           concatenate the expression "sin(x)" to the displayTextField
             *   4. set the inputTextField and currentOperator to ""
             *   5. set addInput to false so the displays or text fields will automatically
             *      reset when new values or numbers are entered and no operator is not entered
             */
            if (e.getSource() == sin){
                if(inputTextField.getText().equals("")){
                    simplifiedExp.setText(simplifiedExp.getText() + CalculatorUtility.solveOtherOperators("sin(0)"));
                    displayTextField.setText(displayTextField.getText() +  ("sin(0)"));
                }else {
                    simplifiedExp.setText(simplifiedExp.getText() + CalculatorUtility.solveOtherOperators("sin("+ inputTextField.getText() + ")"));
                    displayTextField.setText(displayTextField.getText() +  ("sin("+ inputTextField.getText() + ")"));
                }
                inputTextField.setText("");
                currentOperator="";
                addInput = false;
            }

            /** COS
             *   1.if the inputTextField is empty
             *          concatenate the calculated value of "cos(0)" to the simplifiedExp
             *          concatenate the expression "cos(0)" to the displayTextField
             *   3. else
             *           concatenate the calculated value of "cos(x)" to the simplifiedExp
             *           concatenate the expression "cos(x)" to the displayTextField
             *   4. set the inputTextField and currentOperator to ""
             *   5. set addInput to false so the displays or text fields will automatically
             *      reset when new values or numbers are entered and no operator is not entered
             */
            if (e.getSource() == cos){
                if(inputTextField.getText().equals("")){
                    simplifiedExp.setText(simplifiedExp.getText() + CalculatorUtility.solveOtherOperators("cos(0)"));
                    displayTextField.setText(displayTextField.getText() +  ("cos(0)"));
                }else {
                    simplifiedExp.setText(simplifiedExp.getText() + CalculatorUtility.solveOtherOperators("cos("+ inputTextField.getText() + ")"));
                    displayTextField.setText(displayTextField.getText() +  ("cos("+ inputTextField.getText() + ")"));
                }
                inputTextField.setText("");
                currentOperator="";
                addInput = false;
            }

            /** TAN
             *   1.if the inputTextField is empty
             *          concatenate the calculated value of "tan(0)" to the simplifiedExp
             *          concatenate the expression "tan(0)" to the displayTextField
             *   3. else
             *           concatenate the calculated value of "tan(x)" to the simplifiedExp
             *           concatenate the expression "tan(x)" to the displayTextField
             *   4. set the inputTextField and currentOperator to ""
             *   5. set addInput to false so the displays or text fields will automatically
             *      reset when new values or numbers are entered and no operator is not entered
             */
            if (e.getSource() == tan){
                if(inputTextField.getText().equals("")){
                    simplifiedExp.setText(simplifiedExp.getText() + CalculatorUtility.solveOtherOperators("tan(0)"));
                    displayTextField.setText(displayTextField.getText() +  ("tan(0)"));
                }else {
                    simplifiedExp.setText(simplifiedExp.getText() + CalculatorUtility.solveOtherOperators("tan("+ inputTextField.getText() + ")"));
                    displayTextField.setText(displayTextField.getText() +  ("tan("+ inputTextField.getText() + ")"));
                }
                inputTextField.setText("");
                currentOperator="";
                addInput = false;
            }

            /** SQUAREROOT
             *   1.if the inputTextField is empty
             *          concatenate the calculated value of "\u221A(0)" to the simplifiedExp
             *          concatenate the expression ""\u221A(0)"" to the displayTextField
             *   3. else
             *           concatenate the calculated value of "\u221A(x)" to the simplifiedExp
             *           concatenate the expression "\u221A(x)" to the displayTextField
             *   4. set the inputTextField and currentOperator to ""
             *   5. set addInput to false so the displays or text fields will automatically
             *      reset when new values or numbers are entered and no operator is not entered
             */
            if (e.getSource() == squareRoot){
                if(inputTextField.getText().equals("")){
                    simplifiedExp.setText(simplifiedExp.getText() + CalculatorUtility.solveOtherOperators("\u221A(0)"));
                    displayTextField.setText(displayTextField.getText() +  ("\u221A(0)"));
                }else {
                    simplifiedExp.setText(simplifiedExp.getText() + CalculatorUtility.solveOtherOperators("\u221A("+ inputTextField.getText() + ")"));
                    displayTextField.setText(displayTextField.getText() +  ("\u221A("+ inputTextField.getText() + ")"));
                }
                 inputTextField.setText("");
                currentOperator="";
                addInput = false;
            }

            /** LOG
             *   1.if the inputTextField is empty
             *          concatenate the calculated value of "log(0)" to the simplifiedExp
             *          concatenate the expression ""log(0)"" to the displayTextField
             *   3. else
             *           concatenate the calculated value of "log(x)" to the simplifiedExp
             *           concatenate the expression "log(x)" to the displayTextField
             *   4. set the inputTextField and currentOperator to ""
             *   5. set addInput to false so the displays or text fields will automatically
             *      reset when new values or numbers are entered and no operator is not entered
             */
            if (e.getSource() == log){
                if(inputTextField.getText().equals("")){
                    simplifiedExp.setText(simplifiedExp.getText() + CalculatorUtility.solveOtherOperators("log(0)"));
                    displayTextField.setText(displayTextField.getText() +  ("log(0)"));
                    inputTextField.setText("Invalid input.");
                } else{
                    simplifiedExp.setText(simplifiedExp.getText() + CalculatorUtility.solveOtherOperators("log("+ inputTextField.getText() + ")"));
                    displayTextField.setText(displayTextField.getText() +  ("log("+ inputTextField.getText() + ")"));
                }
                inputTextField.setText("");
                currentOperator="";
                addInput = false;
            }

            /** FACTORIAL
             *   1.if the inputTextField is empty
             *          concatenate the calculated value of "0!" to the simplifiedExp
             *          concatenate the expression "0!" to the displayTextField
             *   3. else
             *           concatenate the calculated value of "x!" to the simplifiedExp
             *           concatenate the expression "x!" to the displayTextField
             *   4. set the inputTextField and currentOperator to ""
             *   5. set addInput to false so the displays or text fields will automatically
             *      reset when new values or numbers are entered and no operator is not entered
             */
            if (e.getSource() == factorial){
                if(inputTextField.getText().equals("")) {
                    simplifiedExp.setText(simplifiedExp.getText() + CalculatorUtility.solveOtherOperators("0!"));
                    displayTextField.setText(displayTextField.getText() +  ("0!"));
                } else{
                    simplifiedExp.setText(simplifiedExp.getText() + CalculatorUtility.solveOtherOperators(inputTextField.getText() + "!"));
                    displayTextField.setText(displayTextField.getText() +  (inputTextField.getText() + "!"));
                }
                inputTextField.setText("");
                currentOperator="";
                addInput = false;
            }
        }

        /**
         * This method adds an input to the inputTextField which was pressed by the user.
         * @param i value of the button pressed by the user
         */
        private void input(char i){

            inputTextField.setText(inputTextField.getText()+i);
        }

        /**
         * This method performs after an operator is clicked.
         * 1. Negates changeOperator making boolean changeOperator either equal or not equal to changeOpBasis
         * 2. Concatenate the operator to the displayTextField
         * 3. Clear the inputTextField
         * 4. If the user has clicked an operator more than once then the input1 gets the value of currentResult and changeOpBasis negates.
         *      changeOperator is initially false while changeOpBasis is initially true. This is in order to have an initial result while the equals button
         *      is not yet pressed and if the user has used more than one operators.
         *      e.g 8+8 (currentResult = 16)
         *          8+8+8 (input1 = 16, input2 = 8, currentResult = 24)
         */
        private void processOperator(String op) {
            changeOperator = !changeOperator;
            simplifiedExp.setText(simplifiedExp.getText() + inputTextField.getText() + " " + op + " ");
            displayTextField.setText(displayTextField.getText() + inputTextField.getText() + " " + op + " ");
            inputTextField.setText("");
            if (changeOperator != changeOpBasis) {
                input1 = currentResult;
                changeOpBasis = !changeOpBasis;
            }
        }

        /**
         * 1. This performs the arithmetic operations using the parameters input1, operator, and input2.
         * 2. The result depends on the value of operator such as '/', '*', '-', '+' for division, multiplication, subtraction and addition respectively.
         * 3. If the operator is empty then the result gets the value of input1.
         * 4. @return Returns the result of the operation.
         * @return
         */
        public double processArithmetic(double input1, String op, double input2) {
            double r = 0;

            switch (op){
                case "/": r = (input1/input2);break;
                case "*": r =  (input1*input2);break;
                case "-": r =  (input1-input2);break;
                case "+": r =  (input1+input2);break;
                case "": r =  input1;break;
                case "\u00B2": r =  Math.pow(input1,2);break;
                case "\u00B3": r =  Math.pow(input1,3);break;
                case "^": r =  Math.pow(input1,input2);break;
                case "sin": r =  Math.sin(input1);break;
                case "cos": r =  Math.cos(input1);break;
                case "tan": r =  Math.tan(input1);break;
                case "\u221A": r =  Math.sqrt(input1);break;
                case "log": if(input1==0){
                        inputTextField.setText("Invalid input.");
                    }
                    r =  Math.log(input1);
                    break;
                case "mod":
                    r = input1%input2;
                    break;
                case "!":
                    for(double i=input1-1;i>0;i--){
                        r =  (input1*i);
                        input1 = r;
                    }

            }
            return r;
        }

        /**
         * 1. This performs the arithmetic operations using the parameters input1, operator, and input2.
         * 2. The result depends on the value of operator such as '/', '*', '-', '+' for division, multiplication, subtraction and addition respectively.
         * 3. If the operator is empty then the result gets the value of input1.
         * 4. @return Returns the result of the operation.
         * @return
         */
        private long processArithmetic2(double input1, String op, double input2) {
            long r = 0;

            switch (op){
                case "/": r = (long) (input1/input2);break;
                case "*": r = (long) (input1*input2);break;
                case "-": r = (long) (input1-input2);break;
                case "+": r = (long) (input1+input2);break;
                case "": r = (long) input1;break;
                case "\u00B2": r = (long) Math.pow(input1,2);break;
                case "\u00B3": r = (long) Math.pow(input1,3);break;
                case "^": r = (long) Math.pow(input1,input2);break;
                case "sin": r = (long) Math.sin(input1);break;
                case "cos": r = (long) Math.cos(input1);break;
                case "tan": r = (long) Math.tan(input1);break;
                case "\u221A": r = (long) Math.sqrt(input1);break;
                case "log":
                    if(input1==0){
                        inputTextField.setText("Invalid input.");
                    }
                    r = (long) Math.log(input1);
                    break;
                case "mod":
                    r = (long) (input1%input2);
                    break;
                case "!":
                    for(double i=input1-1;i>0;i--){
                        r = (long) (input1*i);
                        input1 = r;
                    }

            }
            return r;
        }

    }
} //end of Calculator class

