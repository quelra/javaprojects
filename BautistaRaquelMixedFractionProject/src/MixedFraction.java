import java.text.DecimalFormat;

/**
 * Name: BAUTISTA, Raquel S., VIADO, Jose Enrico M.
 * Date: January 17, 2020
 * Schedule: 9:30-11:00 AM T- Th
 * Room: D522
 *
 * This is a subclass of the superclass Fraction.
 * This extends the class Fraction.
 */
public class MixedFraction extends Fraction {

    /**
     * This data field holds the value of the MixedFraction's whole number part.
     */
    private int wholeNumber;  // additional data member, holds the whole number for the mixed fraction

    /**
     * This is the default contructor the sets the numerator to 0, denominator to 1, and whole number to 0.
     */
    MixedFraction() {
        super(0, 1);
        this.wholeNumber = 0;
    }

    /**
     * This is a constructor that produces a whole number value.
     *
     * @param wholeNumber is any integer.
     */
     MixedFraction(int wholeNumber) {
        super(0, 1);
        this.wholeNumber = wholeNumber;
    }

    /**
     * This constructor produces a mixed fraction with numerator, denominator, and whole number based from the inputted values.
     * example usage: MixedFraction mF = new MixedFraction(numerator, denominator, wholeNumber);
     *
     * @param numerator   contains the inputted integer as the object's numerator
     * @param denominator contains the inputted integer as the object's denominator
     * @param wholeNumber contains the inputted integer as the object's wholeNumber
     */
    MixedFraction(int wholeNumber, int numerator, int denominator ) {
        super(numerator, denominator);
        this.wholeNumber = wholeNumber;
    }

    /**
     * This constructor produces a mixed fraction with fraction and whole number based from the inputted values.
     *
     * @param fraction    fraction with its corresponding numerator and denominator
     * @param wholeNumber contains the inputted integer as the object's wholeNumber
     */
     MixedFraction(int wholeNumber,Fraction fraction ) {
        super(fraction.numerator, fraction.denominator);
        this.wholeNumber = wholeNumber;
    }

    /**
     * This constructor produces a mixed fraction based from an inputted fraction.
     *
     * @param fraction fraction with its corresponding numerator and denominator
     */
    public MixedFraction(Fraction fraction) {
        super(fraction.numerator, fraction.denominator);
        this.wholeNumber = 0;
    }

    /**
     * This method overrides the getNumerator from the superclass Fraction.
     */
    @Override
    public int getNumerator() {
        return this.numerator;
    }

    /**
     * This method overrides the getDenominator from the superclass Fraction.
     */
    @Override
    public int getDenominator() {
        return this.denominator;
    }

    /**
     * This method gets the object's whole number.
     *
     * @return returns the whole number part.
     */
    private int getWholeNumber() {
        return wholeNumber;
    }

    /**
     * This method returns the object's fraction part.
     *
     * @return returns the fraction part.
     */
    private Fraction getFractionPart() {
        return new Fraction(this.numerator, this.denominator);
    }

    /**
     * This override the setNumerator from the superclass Fraction.
     */
    @Override
    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    /**
     * This override the setDenominator from the superclass Fraction.
     *
     * @param denominator is a parameter that has the property to change the object's current denominator data field value.
     */
    @Override
    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    /**
     * The whole number setter.
     * This method sets a new value for the whole number part.
     *
     * @param wholeNumber is a parameter that has the property to change the object's current whole number data field value.
     */
    private void setWholeNumber(int wholeNumber) {
        this.wholeNumber = wholeNumber;
    }

    /**
     * The fraction setter.
     * This method sets a new value for both the numerator and denominator.
     *
     * @param numerator   has the property to change the object's current numerator
     * @param denominator has the property to change the object's current denominator
     */
    public void setFractionPart(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    /**
     * This override the toString method from the superclass Fraction.
     */
    @Override
    public String toString() {
        if (getWholeNumber() == 0) {
            if (getNumerator() == 0) return 0 + "";
            else if (getDenominator() == 1) return this.numerator + "";
            else return this.numerator + "/" + this.denominator;
        } else {
            if (getNumerator() == 0) return this.wholeNumber + "";
            else if (getDenominator() != 1) return this.wholeNumber + " " + this.numerator + "/" + this.denominator;
            else return this.numerator + this.wholeNumber + "";
        }
    }


    /**
     * The toFraction method.
     *
     * @return converts a MixedFraction to Fraction data type.
     */
    public Fraction toFraction() {
        return new Fraction(getFractionPart().getNumerator() + (getWholeNumber() * getFractionPart().getDenominator()), getFractionPart().getDenominator());
    }

    /**
     * The toMixedFraction method.
     *
     * @return converts a Fraction to MixedFraction data type.
     */
    @Override
    MixedFraction toMixedFraction() {
        int num = getNumerator();
        int den = getDenominator();
        int whole = num / den;
        int newNum = num % den;
        return new MixedFraction(whole,newNum, den);
    }

    /**
     * This method adds two inputted mixed fractions.
     *
     * @param anotherFraction holds the other mixed fraction.
     * @return the sum of the two fractions.
     */
    MixedFraction add(MixedFraction anotherFraction) {
        Fraction firstFraction = toFraction(), secondFraction = anotherFraction.toFraction(), result;
        int num1 = (getLCD(anotherFraction.getDenominator()) / firstFraction.getDenominator()) * firstFraction.getNumerator();
        int num2 = (getLCD(anotherFraction.getDenominator()) / secondFraction.getDenominator()) * secondFraction.getNumerator();
        result = new Fraction(num1 + num2, getLCD(anotherFraction.getDenominator()));
        return result.toMixedFraction();
    }



    /**
     * The subtract method.
     * This method subtracts the fractions inputted in its parameters.
     * @param anotherFraction holds the second fraction inputted from method call.
     * @return the difference of the two fractions.
     */
    MixedFraction subtract(MixedFraction anotherFraction) {
        Fraction firstFraction = toFraction(), secondFraction = anotherFraction.toFraction(), result;
        int num1 = (getLCD(anotherFraction.getDenominator()) / firstFraction.getDenominator()) * firstFraction.getNumerator();
        int num2 = (getLCD(anotherFraction.getDenominator()) / secondFraction.getDenominator()) * secondFraction.getNumerator();
        result = new Fraction(num1 - num2, getLCD(anotherFraction.getDenominator()));
        return result.toMixedFraction();
    }


    /**
     * The multiplyFractions method.
     * This method multiplies the fractions inputted in its parameters.
     * @param anotherFraction holds the second fraction inputted from method call.
     * @return the product of the two fractions.
     */
    MixedFraction multiplyBy(MixedFraction anotherFraction) {
        Fraction firstFraction = toFraction(), secondFraction = anotherFraction.toFraction(), result;
        result = new Fraction(firstFraction.getNumerator() * secondFraction.getNumerator(), firstFraction.getDenominator() * secondFraction.getDenominator());
        return result.toMixedFraction();
    }


    /**
     * The divideFractions method.
     * This method divides the fractions inputted in its parameters.
     * @param anotherFraction holds the second fraction inputted from method call.
     * @return the quotient of the two fractions.
     */
    MixedFraction divideBy(MixedFraction anotherFraction) {
        Fraction firstFraction = toFraction(), secondFraction = anotherFraction.toFraction(), result;
        MixedFraction convertToMix = new MixedFraction();
        result = new Fraction(firstFraction.getNumerator() * secondFraction.getDenominator(), firstFraction.getDenominator() * secondFraction.getNumerator());
        try {
            convertToMix = result.toMixedFraction();
        } catch (ArithmeticException ignored) { }
        return convertToMix;
    }


    /**
     * The simplifyFractions method.
     * This method simplifies the fractions inputted in its parameters into their simplest form.
     * @param firstFraction  holds the first fraction inputted from method call.
     * @param secondFraction holds the second fraction inputted from method call.
     * @return returns a string of characters which contains the simplified form of the inputted fraction in its parameters.
     */
    static String simplifyFractions(Fraction firstFraction, Fraction secondFraction) {
        if (firstFraction.inLowestTerm().toString().equals(firstFraction.toString()) && secondFraction.inLowestTerm().toString().equals(secondFraction.toString()))
            return "The Fractions " + firstFraction.toString() + " & " + secondFraction.toString() + " are already in their simplest notations.";
        else
            return "Simplified Form: " + firstFraction.inLowestTerm().toString() + " & " + secondFraction.inLowestTerm().toString() + ".";
    }

    /**
     * The toMixedFraction method.
     * @return converts a Fraction to MixedFraction data type.
     */
    @Override
    MixedFraction inLowestTerm() {
        int num = getNumerator(), den = getDenominator(), whole = getWholeNumber();
        if (den != 1) {
            if (num == 0) {
                return new MixedFraction(whole);
            } else if (num % getGCF() == 0 && den % getGCF() == 0) {
                if (num == den) return new MixedFraction(whole + 1);
                else if (den / getGCF() == 1) return new MixedFraction(whole,num / getGCF(), 1 );
                else if (den < 0) return new MixedFraction(whole,(num / getGCF()) * -1, (den / getGCF()) * -1 );
                else return new MixedFraction(whole,num / getGCF(), den / getGCF() );
            } else return new MixedFraction(whole, num, den );
        } else return new MixedFraction(num + whole);
    }

    /**
     * The toDouble method.
     *
     * @return returns a double derived from the Fraction.
     */
    @Override
    double toDouble() {
        return getWholeNumber() + ((double) getNumerator() / (double) getDenominator());
    }

    /**
     * The showInDecimal method.
     *
     * @return returns a formatted String that has 6 decimal places.
     */
    @Override
    String showInDecimal() {
        DecimalFormat f = new DecimalFormat("#0.000000");
        return f.format(toDouble());
    }
}
