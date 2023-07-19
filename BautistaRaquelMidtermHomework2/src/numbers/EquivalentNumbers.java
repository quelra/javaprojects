package numbers;
/**
 *A template for an object representing a whole number wiht it decimal, binary, octal, and hexadecimal form.
 **/
public class EquivalentNumbers implements NumberConverter{
    private double decimalNumber; //decimal number form
    private String hexadecimalString; //hexadecimal number form
    private String binaryString; //binary number form
    private String octalString; //octal number form


    /**
    *Constructs an object representing the number 0
     **/
    public EquivalentNumbers() {
        decimalNumber = 0;
        hexadecimalString = "0";
        binaryString = "0";
        octalString = "0";
    }

    /**
     * Constructs an object representing a q whole number a
    */
    public EquivalentNumbers(double a, String b, String c, String d) {
        decimalNumber = a;
        hexadecimalString = b;
        binaryString = c;
        octalString = d;
    }

    /**
    * Returns the decimal number form of an object of EquivalentNumbers
    */
    public double getDecimalNumber() {
        return decimalNumber;
    }

    /**
    * Returns the hexadecimal number form of an object of EquivalentNumbers
    */
    public  String getHexadecimalString(){
        return hexadecimalString;
    }

    /**
    * Returns the binary number form of an object of EquivalentNumbers
    */
    public String getBinaryString() {
    return binaryString;
}

    /**
    * Returns the octal number form of an object of EquivalentNumbers
    */
    public String getOctalString() {
    return octalString;
}

    /**
    * Sets the decimal number, then the hexadecimal number, binary number and octal number
    * are set based on the decimal number.
    */
    public void setDecimalNumber(double d) {
        decimalNumber = d;
        hexadecimalString = toHexadecimalString(decimalNumber);
        binaryString = toBinaryString(decimalNumber);
        octalString = toOctalString(decimalNumber);
    }

    /**
    * Sets the hexadecimal number, then the decimal number, binary number and octal number
    * are set based on the hexadecimal number.
    */
    public void setHexadecimalString(String n) {
        hexadecimalString = n;
        decimalNumber = hexadecimalToDecimal(hexadecimalString);
        binaryString = toBinaryString(decimalNumber);
        octalString = toOctalString(decimalNumber);
    }

    /**
    * Sets the octal number, then the decimal number, binary number and hexadecimal number
    * are set based on the octal number.
    */
    public void setOctalString(String n) {
        octalString = n;
        decimalNumber = octalToDecimal(octalString);
        binaryString = toBinaryString(decimalNumber);
        hexadecimalString = toHexadecimalString(decimalNumber);
    }

    /**
    * Sets the binary number, then the decimal number, octal number and hexadecimal number
    * are set based on the binary number.
    */
    public void setBinaryString(String b) throws Exception {
        binaryString = b;
        decimalNumber = binaryToDecimal(binaryString);
        octalString = toOctalString(decimalNumber);
        hexadecimalString = toHexadecimalString(decimalNumber);
    }



    public static String toBinaryString(double decimal) {
        String binary, fractionalBinary = ".";
        double fractional = decimal % 1, dividend;

        binary = "" + Integer.toBinaryString((int) (decimal));

        do {
            dividend = fractional * 2;
            fractional = dividend % 1;
            fractionalBinary = fractionalBinary + (int) dividend;
        } while (dividend % 1 != 0);

        if (decimal % 1 != 0) {
            binary = binary + fractionalBinary;
        }
        return binary;
    }
    public static String toOctalString(double decimal){
        String octal, fractionalOctal = ".";
        double fractional = decimal%1, dividend;
        octal = "" + Integer.toOctalString((int)(decimal));
        do {
            dividend = fractional * 8;
            fractional = dividend%1;
            fractionalOctal = fractionalOctal + (int)dividend;
        } while(dividend%1 != 0);
        if(decimal%1 != 0){
            octal = octal + fractionalOctal;
        }
        return octal;
    }

    public static String toHexadecimalString(double decimal){
        String hexa, fractionalHex = ".";
        double fractional = decimal%1, dividend;
        hexa = "" + Integer.toHexString((int)(decimal));
        do {
            dividend = fractional * 16;
            fractional = dividend%1;
            fractionalHex = fractionalHex + hexDigit((byte) dividend);
        } while(dividend%1 != 0);
        if(decimal%1 != 0){
            hexa = hexa + fractionalHex;
        }
        return hexa;
    }
    /**
     * Returns the hexadecimal digit corresponding to a given number in the range 0 to 15
     */
    public static char hexDigit(byte digit){
        char r = '0';
        switch (digit) {
            case 0:
                r = '0';
                break;
            case 1:
                r = '1';
                break;
            case 2:
                r = '2';
                break;
            case 3:
                r = '3';
                break;
            case 4:
                r = '4';
                break;
            case 5:
                r = '5';
                break;
            case 6:
                r = '6';
                break;
            case 7:
                r = '7';
                break;
            case 8:
                r = '8';
                break;
            case 9:
                r = '9';
                break;
            case 10:
                r = 'A';
                break;
            case 11:
                r = 'B';
                break;
            case 12:
                r = 'C';
                break;
            case 13:
                r = 'D';
                break;
            case 14:
                r = 'E';
                break;
            case 15:
                r = 'F';
                break;
        }
        return r;
    }

        /**
        * Returns the decimal number corresponding to a given binary number.
        */
        public double binaryToDecimal(String b) throws Exception {
            double result = 0;
            if (!isValidBinaryString(b))
                throw new Exception("Invalid Binary Number");

            if(hasDecimalPoint(b)){
                String data[] = b.split(".");
                for (int i = 0; i < data[0].length(); i++) {
                    result += Integer.parseInt("" + data[0].charAt(i) * Math.pow(2, (int) (data[0].length() - 1 - i)));
                }
                for (int i = 0; i < data[1].length(); i++) {
                    result += Integer.parseInt("" + data[1].charAt(i) * Math.pow(2, (int) (-data[1].length() -i)));
                }
            } else{
                for (int i = 0; i < b.length(); i++) {
                    result += Integer.parseInt("" + b.charAt(i) * Math.pow(2, (int) (b.length() - 1 - i)));
                }
            }
            return result;
        }

        public boolean hasDecimalPoint(String a){
            boolean hasDecimal = false;
            for(int i = 0; i<a.length(); i++){
                if(a.charAt(i)=='.'){
                    hasDecimal = true;
                }
            }
            return hasDecimal;
        }

        /**
        * Returns the decimal number corresponding to a given hexadecimal number
        */
        public double hexadecimalToDecimal(String h) {
            double result = 0;
            for (int i = 0; i < h.length(); i++) {
                switch (h.charAt(i)) {
                    case '0':
                    case '1':
                    case '2':
                    case '3':
                    case '4':
                    case '5':
                    case '6':
                    case '7':
                    case '8':
                    case '9':
                        result += Integer.parseInt("" + h.charAt(i)) * Math.pow(16, (int) (h.length() - 1 - i));
                        break;
                    case 'a':
                    case 'A':
                        result += 10 * Math.pow(16, (int) (h.length() - 1 - i));
                        break;
                    case 'b':
                    case 'B':
                        result += 11 * Math.pow(16, (int) (h.length() - 1 - i));
                        break;
                    case 'c':
                    case 'C':
                        result += 12 * Math.pow(16, (int) (h.length() - 1 - i));
                        break;
                    case 'd':
                    case 'D':
                        result += 13 * Math.pow(16, (int) (h.length() - 1 - i));
                        break;
                    case 'e':
                    case 'E':
                        result += 14 * Math.pow(16, (int) (h.length() - 1 - i));
                        break;
                    case 'f':
                    case 'F':
                        result += 15 * Math.pow(16, (int) (h.length() - 1 - i));
                        break;
                }
            }
            if (hasDecimalPoint(h)) {
                String data[] = h.split(".");
                for (int i = 0; i < data[1].length(); i++) {
                    switch (data[1].charAt(i)) {
                        case '0':
                        case '1':
                        case '2':
                        case '3':
                        case '4':
                        case '5':
                        case '6':
                        case '7':
                        case '8':
                        case '9':
                            result += Integer.parseInt("" + data[1].charAt(i) * Math.pow(16, (int) (-data[1].length() - i)));
                            break;
                        case 'a':
                        case 'A':
                            result += 10 * Math.pow(16, (int) (-data[1].length() - i));
                            break;
                        case 'b':
                        case 'B':
                            result += 11 * Math.pow(16, (int) (-data[1].length() - i));
                            break;
                        case 'c':
                        case 'C':
                            result += 12 * Math.pow(16, (int) (-data[1].length() - i));
                            break;
                        case 'd':
                        case 'D':
                            result += 13 * Math.pow(16, (int) (-data[1].length() - i));
                            break;
                        case 'e':
                        case 'E':
                            result += 14 * Math.pow(16, (int) (-data[1].length() - i));
                            break;
                        case 'f':
                        case 'F':
                            result += 15 * Math.pow(16, (int) (-data[1].length() - i));
                            break;
                    }
                }
            }
            return (result);
        }

        /**
        * Returns the decimal number corresponding to a given octal number.
        */
        public double octalToDecimal(String n) {
            double result = 0;
            for (int i = 0; i < n.length(); i++) {
                result += Integer.parseInt("" + n.charAt(i)) * Math.pow(8, (int) (n.length() - 1 - i));
            }
            if(hasDecimalPoint(n)){
                String data[] = n.split(".");
                for (int i = 0; i < data[1].length(); i++) {
                    result += Integer.parseInt("" + data[1].charAt(i) * Math.pow(8, (int) (-data[1].length() - i)));
                }
            }
            return (result);
        }

        /**
        * Returns a string showing a whole number with its decimal, binary, octal, and hexadecimal form.
        */
        public String toString() {
            return ("Decimal Value = " + decimalNumber + "\nBinary Value = " + binaryString + "\nOctal Value = " +
                octalString + "\nHexadecimal Value = " + hexadecimalString);
        }

        /**
        * Returns true if this number is equivalent to another number.
        */
        public boolean equals(EquivalentNumbers another) {
            return (this.decimalNumber == another.getDecimalNumber());
        }

        public boolean isValidBinaryString(String s) {
            boolean result = true;
            for (int index = 0; index < s.length() && result; index++) {
                if (s.charAt(index) != '0' && s.charAt(index) != '1' && s.charAt(index) != '.')
                    result = false;
            }
            return result;
        }
}


