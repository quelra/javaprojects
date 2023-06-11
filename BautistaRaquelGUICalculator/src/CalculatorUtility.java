/**
 *This is a class for other methods to be used in Calculator class.
 */

public class CalculatorUtility {

    /**
     * This is specificallly intended for multiple inputs.
     * sample:
     *      8 / 9 * 2 + 6 - 5 * 3 - 3
     *      0.8888888888888888 * 2 + 6 - 5 * 3 - 3
     *      1.7777777777777777 + 6 - 5 * 3 - 3
     *      1.7777777777777777 + 6 - 15.0 - 3
     *      7.777777777777778 - 15.0 - 3
     *      -7.222222222222222 - 3
     *      -10.222222222222221
     *
     * 1. Split the parameter value and put in an array data
     * 2. if the length of the array is 1 or 2, return the value of data[0]
     * 3. Check for multiplication or division operators first then solve the values around it
     * 4. Replace the solved ones with the result in the string value then split it again
     * 5. If there no more division or multiplication operators then proceed to the addition and subtraction operators
     * 6. repeat no 4. until the final result is achieved
     *
     *
     * @param value
     * @return
     */
    public static double solveArithmetic(String value){
        System.out.println(value);
        String[] data = value.split("\\s+");

        double result = 0;

        if(data.length == 1 | data.length == 2){
            return Double.parseDouble(data[0]);
        }

        int length = data.length;

        try {
            do{
                for (int i = 1; i < data.length; i += 2) {

                    int newLength = data.length;
                    if(i>=newLength) {
                        break;
                    }
                    while (data[i].equals("/") || data[i].equals("*")) {
                        if (data[i].equals("*")) {
                            result = Double.parseDouble(data[i - 1]) * Double.parseDouble(data[i + 1]);
                            value = value.replaceAll(data[i - 1] + "\\s\\*\\s" + data[i + 1], String.valueOf(result));
                            System.out.println(value);
                            data = value.split("\\s+");
                        } else if (data[i].equals("/")) {
                            result = Double.parseDouble(data[i - 1]) / Double.parseDouble(data[i + 1]);
                            value = value.replaceAll(data[i - 1] + "\\s\\/\\s" + data[i + 1], String.valueOf(result));
                            System.out.println(value);
                            data = value.split("\\s+");
                        }
                    }
                }

                int i = 1;
                while (data[i].equals("+") || data[i].equals("-")) {
                    if (data[i].equals("+")) {
                        result = Double.parseDouble(data[i - 1]) + Double.parseDouble(data[i + 1]);
                        value = value.replaceAll(data[i - 1] + "\\s\\+\\s" + data[i + 1], String.valueOf(result));
                        System.out.println(value);
                        data = value.split("\\s+");
                    } else {
                        result = Double.parseDouble(data[i - 1]) - Double.parseDouble(data[i + 1]);
                        value = value.replaceAll(data[i - 1] + "\\s\\-\\s" + data[i + 1], String.valueOf(result));
                        System.out.println(value);
                        data = value.split("\\s+");
                    }
                }

            } while(length > 2);

        }catch (ArrayIndexOutOfBoundsException Ignored) {
        }
        return result;
    } //end of solveArithmetic method

    /**
     * This method is used to solve the values of scientific operators such as sqr(), cube(), log(), sin(), cos(), tan(), sqrt(), x!, x^y).
     * and returns the result.
     * 1. Check for the keywords such as sqr(, cube(, log(, sin(, cos(, tan(, √(, !, ^
     * 2. if it matches then calculate result based from the operator
     * @param others
     * @return
     */
    public static double solveOtherOperators(String others){
        double result = 0;

        if(others.startsWith("sqr(")){
            result =  Math.pow(Double.parseDouble(others.substring(4,others.length()-1)),2);
        } else if(others.startsWith("cube(")){
            result =  Math.pow(Double.parseDouble(others.substring(5,others.length()-1)),3);
        } else if(others.startsWith("log(")){
            double input = Double.parseDouble(others.substring(4,others.length()-1));
            result =  Math.log10(input);
        } else if(others.startsWith("sin(")){
            double input = Double.parseDouble(others.substring(4,others.length()-1));
            result =  Math.sin(Math.toRadians(input));
        } else if(others.startsWith("cos(")){
            double input = Double.parseDouble(others.substring(4,others.length()-1));
            result =  Math.cos(Math.toRadians(input));
        } else if(others.startsWith("tan(")){
            double input = Double.parseDouble(others.substring(4,others.length()-1));
            result =  Math.tan(Math.toRadians(input));
        } else if(others.startsWith("\u221A(")){
            result = Math.sqrt(Double.parseDouble(others.substring(2,others.length()-1)));
        } else if(others.endsWith("!")){
            double input1 = Double.parseDouble(others.substring(0,others.length()-1));
            for(double i=input1-1;i>0;i--){
                result = (float) (input1*i);
                input1 = result;
            }
        } else if(others.contains("^")){
            String[]data = others.replace(" ^ "," ").split(" ");
            double input1 = Double.parseDouble(data[0]);
            double input2 = Double.parseDouble(data[1]);
            result = Math.pow(input1,input2);
        } else {
            result = Double.parseDouble(others);
        }

        return result;
    }//end of solveOtherOperators

}//end of Calculator Utility class