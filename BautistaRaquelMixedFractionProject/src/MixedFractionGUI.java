
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

/**
 * This is a GUI program designed to solve fractions or Mixed Fractions.
 */

public class MixedFractionGUI {
    private JFrame frame;

    private JPanel mainPanel;
    private JPanel inputPanel;
    private JLabel inputLabel1;
    private JLabel inputLabel2;
    private JTextField inputTextField1;
    private JTextField inputTextField2;

    private JPanel buttonPanel;
    private JButton addButton;
    private JButton subtractButton;
    private JButton multiplyButton;
    private JButton divideButton;

    private JPanel checkBoxPanel;
    private JCheckBox reduce1;
    private JCheckBox reduce2;

    private JTextField displayTextField;

    public MixedFractionGUI(){
        ButtonsHandler handler = new ButtonsHandler();

        frame = new JFrame("Mixed Fraction GUI");
        inputLabel1 = new JLabel("Enter Fraction 1 (format must be n or n/d or w n/d)");
        inputLabel2 = new JLabel("Enter Fraction 2 (format must be n or n/d or w n/d)");
        inputTextField1 = new JTextField(20);
        inputTextField2 = new JTextField(20);

        frame.setLocation(380,250);

        addButton = new JButton("Add");
        addButton.addActionListener(handler);
        subtractButton = new JButton("Subtract");
        subtractButton.addActionListener(handler);
        multiplyButton = new JButton("Multiply");
        multiplyButton.addActionListener(handler);
        divideButton = new JButton("Divide");
        divideButton.addActionListener(handler);

        reduce1 = new JCheckBox("Reduce Fraction 1");
        reduce1.addActionListener(handler);

        reduce2 = new JCheckBox("Reduce Fraction 2");
        reduce2.addActionListener(handler);

        Font font = new Font("a",Font.BOLD,15);

        displayTextField = new JTextField();
        displayTextField.setEditable(false);
        displayTextField.setBackground(Color.darkGray);
        displayTextField.setForeground(Color.white);
        displayTextField.setFont(font);


        checkBoxPanel = new JPanel(new GridLayout(2,1));
        checkBoxPanel.add(reduce1);
        checkBoxPanel.add(reduce2);

        buttonPanel = new JPanel(new GridLayout(1,4));
        buttonPanel.add(addButton);
        buttonPanel.add(subtractButton);
        buttonPanel.add(multiplyButton);
        buttonPanel.add(divideButton);

        inputPanel = new JPanel(new GridLayout(2,2));
        inputPanel.add(inputLabel1);
        inputPanel.add(inputTextField1);
        inputPanel.add(inputLabel2);
        inputPanel.add(inputTextField2);

        mainPanel = new JPanel(new GridLayout(4,1));
        mainPanel.add(displayTextField);
        mainPanel.add(inputPanel);
        mainPanel.add(buttonPanel);
        mainPanel.add(checkBoxPanel);
        Container pane = frame.getContentPane();
        pane.add(mainPanel);
    }

    public static void main(String [] args){
        MixedFractionGUI sample;
        try {
            sample = new MixedFractionGUI();
            sample.launch();
        } catch (Exception x){
            x.printStackTrace();
        }

    }


    public void launch(){
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * 1. If the addButton is clicked
     *     1.a    If the inputs 1 and 2 are valid then read the two fractions and add the two fractions
     *              Check for the format of the result, so that redundant negative signs are omitted (ex. -1 -1/2) ( becomes -1 1/2)
     *         else if input 1 is invalid prompt message for fraction 1
     *         else if input 1 is invalid prompt message for fraction 2
     *         else if both are invalid prompt message for both fractions
     *
     * 2. Same algorithm for subtract, multiply, and divide except for the use of methods in calculation (subtract method for subtractButton,
     *      multiplyBy method for multiplyButton, divideBy method for divideButton).
     * 3. If reduce1 or reduce2 is clicked
     *      If valid
     *             read, convert to lowest term, disply
     *       else
     *             prompt message

     */
    class ButtonsHandler implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            Fraction mixed1 = new MixedFraction();
            Fraction mixed2 = new MixedFraction();
            MixedFraction result;

            try {
                if (e.getSource()== addButton){
                    if(isValid(inputTextField1.getText()) && isValid(inputTextField2.getText())){
                        mixed1 = new MixedFraction(readMixedFractionString(inputTextField1.getText()).toFraction());
                        mixed2 = new MixedFraction(readMixedFractionString(inputTextField2.getText()).toFraction());
                        result = mixed1.toMixedFraction().add(mixed2.toMixedFraction());

                        if(Pattern.matches("(-)+([1-9]\\d*)+\\s+(-)+[1-9]\\d*+/[1-9]\\d*",result.toString())) {
                            String newResult = "-" + result.inLowestTerm().toString().replaceAll("-", "");
                            System.out.println(newResult);
                            displayTextField.setText("The result is      " + newResult + "           or         " + result.toDouble() + "       in decimal.");
                        }else {
                            displayTextField.setText("The result is      " + result.inLowestTerm().toString() + "           or         " + result.toDouble() + "       in decimal.");
                        }
                    } else if(!isValid(inputTextField1.getText()) && isValid(inputTextField2.getText())){
                        errorPrompt(1);
                    } else if(!isValid(inputTextField2.getText()) && isValid(inputTextField1.getText())){
                        errorPrompt(2);
                    } else {
                        errorPrompt(0);
                    }
                }
                if (e.getSource()== subtractButton){
                    if(isValid(inputTextField1.getText()) && isValid(inputTextField2.getText())){
                        mixed1 = new MixedFraction(readMixedFractionString(inputTextField1.getText()).toFraction());
                        mixed2 = new MixedFraction(readMixedFractionString(inputTextField2.getText()).toFraction());
                        result = mixed1.toMixedFraction().subtract(mixed2.toMixedFraction());

                        if(Pattern.matches("(-)+([1-9]\\d*)+\\s+(-)+[1-9]\\d*+/[1-9]\\d*",result.toString())) {
                            String newResult = "-" + result.inLowestTerm().toString().replaceAll("-", "");
                            displayTextField.setText("The result is      " + newResult + "           or         " + result.toDouble() + "       in decimal.");
                        }else {
                            displayTextField.setText("The result is      " + result.inLowestTerm().toString() + "           or         " + result.toDouble() + "       in decimal.");
                        }
                    } else if(!isValid(inputTextField1.getText()) && isValid(inputTextField2.getText())){
                        errorPrompt(1);
                    } else if(!isValid(inputTextField2.getText()) && isValid(inputTextField1.getText())){
                        errorPrompt(2);
                    } else {
                        errorPrompt(0);
                    }
                }
                if (e.getSource()== multiplyButton){
                    if(isValid(inputTextField1.getText()) && isValid(inputTextField2.getText())){
                        mixed1 = new MixedFraction(readMixedFractionString(inputTextField1.getText()).toFraction());
                        mixed2 = new MixedFraction(readMixedFractionString(inputTextField2.getText()).toFraction());
                        result = mixed1.toMixedFraction().multiplyBy(mixed2.toMixedFraction());

                        if(Pattern.matches("(-)+([1-9]\\d*)+\\s+(-)+[1-9]\\d*+/[1-9]\\d*",result.toString())) {
                            String newResult = "-" + result.inLowestTerm().toString().replaceAll("-", "");
                            displayTextField.setText("The result is      " + newResult + "           or         " + result.toDouble() + "       in decimal.");
                        }else {
                            displayTextField.setText("The result is      " + result.inLowestTerm().toString() + "           or         " + result.toDouble() + "       in decimal.");
                        }

                    } else if(!isValid(inputTextField1.getText()) && isValid(inputTextField2.getText())){
                        errorPrompt(1);
                    } else if(!isValid(inputTextField2.getText()) && isValid(inputTextField1.getText())){
                        errorPrompt(2);
                    } else {
                        errorPrompt(0);
                    }
                }
                if (e.getSource()== divideButton){
                    if(isValid(inputTextField1.getText()) && isValid(inputTextField2.getText())){
                        mixed1 = new MixedFraction(readMixedFractionString(inputTextField1.getText()).toFraction());
                        mixed2 = new MixedFraction(readMixedFractionString(inputTextField2.getText()).toFraction());
                        result = mixed1.toMixedFraction().divideBy(mixed2.toMixedFraction());

                        if(Pattern.matches("(-)+([1-9]\\d*)+\\s+(-)+[1-9]\\d*+/[1-9]\\d*",result.toString())) {
                            String newResult = "-" + result.inLowestTerm().toString().replaceAll("-", "");
                            displayTextField.setText("The result is      " + newResult + "           or         " + result.toDouble() + "       in decimal.");
                        }else {
                            displayTextField.setText("The result is      " + result.inLowestTerm().toString() + "           or         " + result.toDouble() + "       in decimal.");
                        }
                    } else if(!isValid(inputTextField1.getText()) && isValid(inputTextField2.getText())){
                        errorPrompt(1);
                    } else if(!isValid(inputTextField2.getText()) && isValid(inputTextField1.getText())){
                        errorPrompt(2);
                    } else {
                        errorPrompt(0);
                    }
                }
                if (e.getSource()==reduce1){
                    if(isValid(inputTextField1.getText())){
                        mixed1 = readMixedFractionString(inputTextField1.getText());
                        result = mixed1.toMixedFraction().inLowestTerm();
                            displayTextField.setText("The result is      " + result.inLowestTerm().toString() + "           or         " + result.toDouble() + "       in decimal." );
                    } else {
                        errorPrompt(1);
                    }
                }
                if (e.getSource()==reduce2){
                    if(isValid(inputTextField2.getText())){
                        mixed2 = readMixedFractionString(inputTextField2.getText());
                        result = mixed2.toMixedFraction().inLowestTerm();
                            displayTextField.setText("The result is      " + result.inLowestTerm().toString() + "           or         " + result.toDouble() + "       in decimal." );
                    } else {
                        errorPrompt(2);
                    }
                }
            } catch (StringIndexOutOfBoundsException x1){
                displayTextField.setText("Please input a valid value.");
            }
        }

        /**
         *
         */


        /**
         * @author Raquel Bautista
         * This method reads a string inputted by the user then assigns values for whole part, numerator, and denominator of a mixed fraction.
         * 1. Use the method extractNumber() to extract the digits and change it into space separated string.
         * 2. Split the string that contains the extracted digits using space(" ").
         * 3. Store in a string array.
         * 4. if the array length is ==1
         *          assign the value in the first index as whole part
         *          numerator and denominator remains 0
         *    if the array length is ==2
         *          assign the value in the first index as numerator
         *          assign the value in the second index as denominator
         *          whole remains 0
         *    if the array length is ==3
         *          first index == whole part
         *          second index == numerator
         *          3rd index == denominator
         *  5. Assign whole, numerator, denominator to a new MixedFraction
         *  6. @return the new MixedFraction
         */
        public MixedFraction readMixedFractionString (String string){
            String data[] = extractNumber(string).split(" ");
            int whole = 0, numerator = 0, denominator = 1;

            if(data.length==1){
                whole = Integer.parseInt(data[0]);
            } else if(data.length==2){
                numerator = Integer.parseInt(data[0]);
                denominator = Integer.parseInt(data[1]);
            } else if(data.length==3){
                whole = Integer.parseInt(data[0]);
                numerator = Integer.parseInt(data[1]);
                denominator = Integer.parseInt(data[2]);
            }

            return new MixedFraction(whole,numerator,denominator);
        }

        /**
         * This method replaces "/" with a space" " and returns only the digits separated by spaces" ".
         * example usage:  String n = extractNumber("1 1/2");
         *                 thus, n is now equal to "1 1 2".
         *
         * @param string
         * @return
         */
        private String extractNumber(String string){
            string = string.replaceAll("/", " ");
            string = string.trim();
            string = string.replaceAll(" +", " ");
            if(string.equals(" ")){
                return "-1";
            }
            return string;
        }

        /**
         * @author Raquel Bautista
         * This method checks the validity of an inputted Mixed Fraction by the user.
         * Returns true if the input is a valid mixed fraction (with formats w or n/d or w n/d)
         * false if otherwise.
         * @param input
         * @return
         */
        private boolean isValid(String input){
            String regex = "^([+-]?([0]|[1-9]\\d*)+/[1-9]\\d*+|[+-]?([0]|[1-9]\\d*)+(\\s([0]|[1-9]\\d*)+/[1-9]\\d*+)?)$";
            return Pattern.matches(regex,input);
        }

        /**
         * @author Raquel Bautista
         * This method shows an error prompt message to the user if one or both the fractions are invalid.
         * If the parameter num is equal to zero, it means both fractions are invalid.
         * Otherwise one of the fractions is invalid. The specific invalid fraction depends on the num (e.g 1 or 2).
         * @param num
         */
        private void errorPrompt(int num){
            if(num==0){
                displayTextField.setText("Invalid Fractions");
            } else {
                displayTextField.setText("Fraction " + num + " is invalid.");
            }
        }
    }
}
