/**
 * A Mixed Number has a fraction part and a whole number part
 */

public class MixedNumber {
    private int wholePart;
    private Fraction fractionPart;


    /**
     * This default constructor sets the whole number part to 0 and
    * the fraction part to 0/1
    */
    public MixedNumber(){
     wholePart = 0;
        fractionPart = new Fraction();
    }

    /**
     * Constructs a mixed number with a given whole part and fraction part
     */
    public MixedNumber(int w, Fraction f){
        wholePart = w;
        fractionPart = f;
    }

    /**
     * Constructs a mixed number with a given whole number part, numerator
     * of the fraction part and denominator of the fraction part.
     */
    public MixedNumber(int w, int  num, int den){
        wholePart =w;
        fractionPart = new Fraction(num,den);
    }

    /**
     * Sets the whole number part of a mixed number to a given whole number
     */
    public void setWholePart(int whole){
        wholePart = whole;
    }

    /**
     * Sts the fraction part of a mixed number to a given fraction
     */
    public void setFractionPart(Fraction fraction){
        fractionPart =fraction;
    }

    /**
     * Returns the fraction part of a  mixed number
     */
    public Fraction getFractionPart(){
        return fractionPart;
    }

    /**
     * Returns the whole part of a mixed number
     */
    public int getWholePart(){
        return wholePart;
    }

    /**
     * Returns a string represent a mixed number.
     * 2 and 1/3 is an example of a mixed number
     */
    public String toString(){
        String r = "";
        if(fractionPart.toDecimal()==0)
            r = wholePart + "";
        else
            r = wholePart + " " + fractionPart.toString();
        return r;
    }

    /**
     * Returns an improper fraction equivalent to a mixed number
     * For example, if the mixed number is 2 and 1/3, 7/3 is returned
     * because 2 and 1/3 is equal to 7/3/
     */
    public Fraction toFraction(){
        int num = fractionPart.getDenominator()*wholePart+ fractionPart.getNumerator();
        int den = fractionPart.getDenominator();
        return (new Fraction(num,den));  //replace the blank line by the correct expression
    }

    /**
     * Returns the sum of this mixed number and another mixed number
     * Algorithm
     * a. Convert this mixed number to an equivalent improper fraction
     * b. Convert the other mixed number to and equivalent improper fraction
     * c. add the two resulting fraction from steps a and b
     * d. convert the result of step c to a mixed number form
     * e. return the result of step d
     */
    public MixedNumber add(MixedNumber other){
        Fraction first = this.toFraction();
        Fraction second = other.toFraction();
        Fraction sum = first.add(second); //Replace the blank line..
        MixedNumber result = sum.toMixedNumber();
        return result;
    }

    /**
     * Returns the difference of this mixed number and another mixed number
     * a. Convert this mixed number to an equivalent improper fraction
     * b. Convert the other mixed number to and equivalent improper fraction
     * c. Subtract the result of step b from the result of step a
     * d. Convert the result of step c to a mixed number form
     * e. Return the result of step d
     */
    public MixedNumber subtract(MixedNumber other){
        Fraction first = this.toFraction();
        Fraction second = other.toFraction();
        Fraction dif = first.subtract(second);//Replace the blank line..
        MixedNumber result = dif.toMixedNumber();
        return result;
    }

    /**
     * Returns the product of this mixed number and another mixed number
     * a. Convert this mixed number to an equivalent improper fraction
     * b. Convert the other mixed number to an equivalent improper fraction
     * c. Multiply the result of step a by the result of step b
     * d. Convert the result of step c to a mixed number form
     * e. Return the result of step d
     */
    public MixedNumber multiplyBy(MixedNumber other){
        Fraction first = this.toFraction();
        Fraction second = other.toFraction();
        Fraction p = first.multiplyBy(second);
        MixedNumber result = p.toMixedNumber();
        return result;
    }

    /**
     * Returns the quotient of this mixed number and another mixed number.
     * a. Convert this mixed number to an equivalent improper fraction
     * b. Convert the other mixed number to and equivalent improper fraction
     * c. Divide the result of step a by the result of step b
     * d. Convert the result of step c to a mixed number form
     * e. Return the result of step d
     */
    public MixedNumber divideBy(MixedNumber other){
        Fraction first = this.toFraction();
        Fraction second = other.toFraction();
        Fraction q = first.divideBy(second);
        MixedNumber result = q.toMixedNumber();
        return result;
    }

    /**
     * Returns true of this Mixed Number has the same
     * decimal value as another mixed number
     */
    public boolean equals(MixedNumber another){
        return (this.toDecimal() == another.toDecimal());
    }

    /**
     * Returns the decimal value of this mixed number
     */
    public double toDecimal(){
        return (wholePart + 1.0*fractionPart.getNumerator()/fractionPart.getDenominator());
    }


}//end of MixedNumber class