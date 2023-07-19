
/**
 * @author Bautista, Raquel S.
 * 01/27/2020
 * 9:30-11:00 TF
 * D515
 */

/**
 * This is reference class for Fractions.
 */

public class Fraction {
    /**
     * Data members.
     * This part holds the numerator and denominator of the fraction.
     */
    private int numerator, denominator;

    /**
     * Default constructor that sets the numerator to 0 and denominator to 1
     */
    public Fraction() {
        numerator = 0;
        denominator = 1;
    }

    /**
     * This is a constructor for a whole number.
     * @param numerator
     */
    public Fraction(int numerator) { //For whole number
        this.numerator = numerator;
    }

    /**
     *This constructor prompts user to input numerator and denominator.
     * @param numerator
     * @param denominator
     */
    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }


    /**
     * Gets the value of the numerator.
     * @return numerator
     */
    public int getNumerator() {
        return numerator;
    }

    /**
     * Gets the value of the denominator.
     * @return denominator
     */
    public int getDenominator() {
        return denominator;
    }

    /**
     * Sets numerator inputted by user.
     * @param numerator
     */
    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    /**
     * Sets denominator inputted by user.
     * @param denominator
     */
    public void setDenominator(int denominator) {//input by user
        this.denominator = denominator;
    }

    //OTHERS

    /**
     * This method converts the fraction into its corresponding string version.
     * If the denominator is 1, it returns a whole number.
     * @return the string version of the fraction.
     */
    public String toString() {
        String stringVersion = (denominator == 1 ? "" + numerator : numerator + "/" + denominator);
        return stringVersion; //changes to string
    }

    /**
     * This method converts a fraction into its equivalent decimal form.
     * @return decimal form
     */
    public double toDouble(){
        double decimalForm = (double)getNumerator()/(double)getDenominator();
        return decimalForm;
    }
    /**
     * @param denom1
     * @param denom2
     * This method gets the greatest common denominator to be used in simplifying or reducing fractions.
     * @return
     */
    private int computeGCD(int denom1, int denom2) {
        int factor = denom2;
        while (denom2 != 0) {
            factor = denom2;
            denom2 = denom1 % denom2;
            denom1 = factor;
        }
        return denom1;
    }

    /**
     *This method gets the least common denominator of the fractions to be used in arithmetic operations.
     * @param denom1
     * @param denom2
     * @return lcd of the fractions
     */
    private int computeLCD(int denom1, int denom2) {
        int factor = denom1;
        while ((denom1 % denom2 != 0)) {
            denom1 += factor;
        }
        return denom1;
    }

    //ARITHMETIC OPERATIONS

    /**
     * This method adds two fractions.
     * It first gets the lcd of the two fractions.
     * Creates two fractions for the converted fractions.
     * It converts the two fractions based from their corresponding lcd.
     * Creates new fraction for the sum.
     * Adds the numerators.
     * Sets the lcd as the denominator of the sum.
     * @param b
     * @return sum
     */
    public Fraction add(Fraction b) {
        int lcd = computeLCD(denominator, b.denominator);
        Fraction convertedFractionA = new Fraction();
        Fraction convertedFractionB = new Fraction();
        convertedFractionA = convert(lcd);
        convertedFractionB = b.convert(lcd);
        Fraction sum = new Fraction();
        sum.numerator = convertedFractionA.numerator + convertedFractionB.numerator;//calculate sum
        sum.denominator = lcd;
        sum = sum.reduce();//reduce the resulting fraction
        return sum;
    }

    /**
     * This method subtracts two fractions.
     * Gets the lcd first.
     * Converts the fractions and creates new fractions based from the lcd.
     * Creates new fraction for the difference.
     * Subtracts the numerators.
     * Sets the lcd as the denominator of the difference.
     * @param b
     * @return difference
     */
    public Fraction subtract(Fraction b) {
        int lcd = computeLCD(denominator, b.denominator);
        Fraction convertedFractionA = convert(lcd);
        Fraction convertedFractionB = b.convert(lcd);
        Fraction difference = new Fraction();
        difference.numerator = convertedFractionA.numerator - convertedFractionB.numerator;  //calculate difference
        difference.denominator = lcd;
        return difference.reduce();
    }

    /**
     * This method multiplies two fractions.
     * Creates new fraction for the product.
     * Multiplies the two numerators.
     * Multiplies the two denominators.
     * @param b
     * @return the reduced product
     */
    public Fraction multiply(Fraction b) {
        Fraction product = new Fraction();
        product.numerator = numerator * b.numerator;  //calculate product
        product.denominator = denominator * b.denominator;
        return product.reduce();
    }

    /**
     * This method divides two fractions.
     * Creates new Fraction for the quotient.
     * Multiplies the numerator to the denominator of the other fraction and vice versa.
     * @param b
     * @return the reduced quotient
     */
    public Fraction divide(Fraction b) {
        Fraction quotient = new Fraction();
        quotient.numerator = numerator * b.denominator;    //calculate result
        quotient.denominator = denominator * b.numerator;
        return quotient.reduce();
    }

    /**
     * This method converts a fractions based from the lcd.
     * Divides the lcd to the denominator and multiplies it to the numerator.
     * Sets the lcd as the denominator.
     * @param lcd
     * @return converted fraction
     */
    private Fraction convert(int lcd) {
        Fraction converted = new Fraction();
        int factor = lcd / denominator;
        converted.numerator = numerator * factor;
        converted.denominator = lcd;
        return converted;
    }

    /**
     * This method reduces a fraction.
     * Creates new fraction.
     * Compare the numerator and denominator.
     * Gets gcd.
     * Divides numerator by the gcd
     * Divides denominator by the gcd
     * @return the reduced fraction.
     */
    public Fraction reduce() {
        Fraction reduced = new Fraction();
        int gcd = 0;
        if (numerator > denominator) {
            gcd = computeGCD(numerator, denominator);
        } else if (numerator < denominator) {
            gcd = computeGCD(denominator, numerator);
        } else {
            gcd = numerator;
        }
        reduced.numerator = numerator / gcd;
        reduced.denominator = denominator / gcd;
        return reduced;
    }

}




