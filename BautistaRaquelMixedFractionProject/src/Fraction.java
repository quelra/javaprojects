import java.text.DecimalFormat;

/**
 * Name: BAUTISTA, Raquel S., VIADO, Jose Enrico M.
 * Date: January 17, 2020
 * Schedule: 9:30-11:00 AM T- Th
 * Room: D522
 *
 * The Fraction class.
 * A template for a fraction that has the form numerator/denominator.
 */
class Fraction {

    /**
     * This data field holds the numerator of the Fraction.
     */
    int numerator; // holds the numerator of this fraction

    /**
     * This data field holds the denominator of the Fraction.
     */
    int denominator; // holds the denominator of this fraction

    /**
     * This is the default constructor which constructs a fraction with a total value of zero.
     */
    Fraction() {
        this.numerator = 0;
        this.denominator = 1;
    }
    // end of Fraction default constructor method

    /**
     * This is a constructor that produces a whole number value.
     * @param numerator is any number that can represent a fraction's numerator.
     */
    private Fraction(int numerator) {
        this.numerator = numerator;
        this.denominator = 1;
    }

    /**
     * Constructs a fraction depending on the user's input.
     * This constructor allows a Fraction with an equivalent numeric value of zero to
     * be created…
     * * Example of usage: Fraction f = new Fraction(int numerator, int denominator);
     * @param numerator contains the inputted integer value as the object's numerator.
     * @param denominator contains the inputted integer value as the object's denominator.
     **/
    Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }
    // end of Fraction constructor method

    /**
     * This method sets a new value for the object's numerator.
     * @param numerator is a parameter that has the property to change the object's current numerator data field value.
     * into the value that is inputted at the setNumerator() method call.
     */
    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }
    // end of setNumerator setter method

    /**
     * This method acquires the object's numerator.
     * @return returns the object's numerator.
     */
    public int getNumerator() {
        return numerator;
    }
    // end of getNumerator getter method

    /**
     * This method sets a new value for the object's denominator.
     * @param denominator is a parameter that has the property to change the object's current denominator data field value.
     * into the value that is inputted at the setNumerator() method call.
     */
    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }
    // end of setDenominator setter method


    /**
     * This method acquires the object's denominator.
     * @return returns the object's denominator.
     */
    public int getDenominator() {
        return denominator;
    }
    // end of getDenominator getter method

    /**
     * This method compiles the numerator and denominator data fields to create a fraction.
     * @return returns the inputted numerator and denominator as a fraction in string form.
     */
    public String toString() {
        if (getDenominator() != 1) return getNumerator() + "/" + getDenominator();
        else if (getNumerator() == 0) return 0 + "";
        else return getNumerator() + "";
    }
    // end of showFraction method


    /**
     * This method converts the fraction into a double.
     * @return returns a double derived from the Fraction.
     */
    double toDouble() {
        return (double) getNumerator() / (double) getDenominator();
    }

    /**
     * This method converts the double-converted fraction into its decimal form in 6 decimal places.
     * @return returns a formatted String that has 6 decimal places
     */
    String showInDecimal() {
        DecimalFormat f = new DecimalFormat("#0.000000");
        return f.format(toDouble());
    }

    /**
     * This method converts the fraction in lowest term and converts into a readable string.
     * @return returns the converted fraction in string form.
     */
    Fraction inLowestTerm() {
        if (getDenominator() != 1) {
            if (getNumerator() == 0) {
                return new Fraction();
            } else if (getNumerator() % getGCF() == 0 && getDenominator() % getGCF() == 0) {
                if (getNumerator() == getDenominator()) return new Fraction(1, 1);
                else {
                    if (getDenominator() / getGCF() == 1) return new Fraction(getNumerator() / getGCF(), 1);
                    else if (getDenominator() < 0) return new Fraction((getNumerator() / getGCF()) * -1, (getDenominator() / getGCF()) * -1);
                    else return new Fraction(getNumerator() / getGCF(), getDenominator() / getGCF());
                }
            } else return new Fraction(getNumerator(), getDenominator());
        } else return new Fraction(getNumerator());
    }
    // end of inLowestTerm method

    /**
     * This method calculates the Greatest Common Factor of the numerator and denominator data fields.
     * This method is necessary to be able to reduce fractions to their lowest notations.
     * The resulting int value GCF can be used not only in reducing fractions to their lowest notations but on other cases as well.
     * @return returns an int data type value which is the GCF.
     */
    int getGCF() {
        int num = Math.abs(getNumerator()), den = Math.abs(getDenominator());
        int GCF = Math.min(num, den);

        for (int i = GCF; i >= 1; i--) {
            if (num % i == 0 && den % i == 0) {
                GCF = i;
                break;
            } else GCF = Math.min(num, den);
        }
        return GCF;
    }
    // end of getGCF method


    /**
     * This method processes two fractions inputted as parameters to return a value which is termed as the Least Common Denominator.
     * The purpose of this method is for other methods to be able to perform operations easily for fractions with different denominators.
     *
     * @param otherDenominator holds the other fraction inputted from method call.
     * @return returns an integer value which is termed as the Least Common Denominator to be used to calculate all fractions easily.
     */
    int getLCD(int otherDenominator) {
        if (getDenominator() == otherDenominator) return getDenominator();
        else return getDenominator() * otherDenominator;
    }
    // end of getLCD method

    /**
     * This method adds the fractions inputted in its parameters.
     *
     * @param anotherFraction holds the other fraction inputted from method call.
     * @return returns the sum of the two fractions.
     */
    Fraction add(Fraction anotherFraction) {
        int num1 = (getLCD(anotherFraction.getDenominator()) / getDenominator()) * getNumerator();
        int num2 = (getLCD(anotherFraction.getDenominator()) / anotherFraction.getDenominator()) * anotherFraction.getNumerator();
        int den = getLCD(anotherFraction.getDenominator());
        return new Fraction((num1 + num2), den);
    }
    // end of addFractions method

    /**
     * This method subtracts the fractions inputted in its parameters.
     *
     * @param anotherFraction holds the other fraction inputted from method call.
     * @return returns the difference of the two fractions.
     */
    Fraction subtract(Fraction anotherFraction) {
        int num1 = (getLCD(anotherFraction.getDenominator()) / getDenominator()) * getNumerator();
        int num2 = (getLCD(anotherFraction.getDenominator()) / anotherFraction.getDenominator()) * anotherFraction.getNumerator();
        int den = getLCD(anotherFraction.getDenominator());
        return new Fraction((num1 - num2), den);
    }
    // end of subtractFractions method

    /**
     * This method multiplies the fractions inputted in its parameters.
     *
     * @param anotherFraction holds the other fraction inputted from method call.
     * @return returns the product of the two fractions.
     */
    Fraction multiplyBy(Fraction anotherFraction) {
        return new Fraction(getNumerator() * anotherFraction.getNumerator(), getDenominator() * anotherFraction.getDenominator());
    }
    // end of multiplyFractions method

    /**
     * This method divides the fractions inputted in its parameters.
     *
     * @param anotherFraction holds the other fraction inputted from method call.
     * @return returns the quotient of the two fractions.
     */
    Fraction divideBy(Fraction anotherFraction) {
        return new Fraction(getNumerator() * anotherFraction.getDenominator(), getDenominator() *anotherFraction.getNumerator());
    }
    // end of divideFractions method

    /**
     * This method simplifies the fractions inputted in its parameters into their simplest form.
     *
     * @param firstFraction holds the first fraction inputted from method call.
     * @param secondFraction holds the second fraction inputted from method call.
     * @return returns a string of characters which contains the simplified form of the inputted fraction in its parameters.
     */
    static String simplifyFractions(Fraction firstFraction, Fraction secondFraction) {
        if (firstFraction.inLowestTerm().toString().equals(firstFraction.toString()) && secondFraction.inLowestTerm().toString().equals(secondFraction.toString()))
            return "The Fractions " + firstFraction.toString() + " & " + secondFraction.toString() + " are already in their simplest notations.";
        else
            return "Simplified Form: " + firstFraction.inLowestTerm().toString() + " & " + secondFraction.inLowestTerm().toString() + ".";
    }
    // end of simplifyFractions method

    /**
     * This method converts a Fraction to MixedFraction data type.
     * @return returns the converted Fraction into a MixedFraction.
     */
    MixedFraction toMixedFraction() {
        int num = getNumerator();
        int den = getDenominator();
        int whole, newNum;
        try {
            whole = num / den;
            newNum = num % den;
        } catch (ArithmeticException a) {
            whole = 0;
            newNum = 0;
        }

        return new MixedFraction( whole,newNum, den);
    }

}
// end of Fraction class