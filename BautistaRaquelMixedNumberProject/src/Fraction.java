/**The Fraction class
 * A template for a fraction that has the form numerator/denominator
 */

public class Fraction {
//data members
    private int numerator; //holds the numerator of this fraction
    private int denominator; //holds the denominator of this fraction

    /**
     * Constructs a fraction with numerator=0 and denominator = 1
     * This constructor allows a Fraction with an equivalent numeric value of zero to
     * be created... This becomes the default constructor (since it has no arguments)...
     * Example of usage: Fraction f = new Fraction();
     *
     */
    public Fraction(){
        numerator = 0;
        denominator = 0;
        //this(0,1);
    }

    /**
     * This constructor creates a Fraction with the specified whole number as it initial value...
     * Example of usage: Fraction f = new Fraction(10);
     */
    public Fraction(int numerator){
        this.numerator = numerator;
    }

    /**
     * This constructor created a Fraction using the numerator and denominator
     * Example of usage: Fraction f = new Fraction(5,2);
     */
    public Fraction(int numerator, int denominator){
        this.numerator = numerator;
        this.denominator = denominator;
    }

    /**
     * Returns the value of the numerator of this fraction
     */
    public int getNumerator(){
        return numerator;
    }

    /**
     * Returns the value of the denominator of this fraction
     */
    public int getDenominator(){
        return denominator;
    }

    /**
     * Sets the value of the numerator of this fraction to n
     */
    public void setNumerator(int numerator){
        this.numerator = numerator;
    }

    /**
     * Sets the value of the denominator of this fraction to denominator
     */
    public void setDenominator(int denominator){
        this.denominator = denominator;
    }

    /** ---Other methods ---*/

    /**
     * Returns a string form of the fraction following the
     * format numerator/denominator
     */
    public String toString(){
        String result = "";
        if (numerator == 0)
            result = result + "0";
        else
            if (denominator == 1)
                result = result + numerator;
            else
                result = (numerator+ "/" + denominator);
         return result;
    }

    /**
     * Returns the reduced(simpliest) form of this fraction
     */
    public Fraction reduce(){
        Fraction r = new Fraction();
        int gCF = computeGCF();

        int newN = numerator/gCF;

        int newD = denominator/gCF;

        r.setNumerator(newN);
        r.setDenominator(newD);
        return r;
    }
    public Fraction reduce2(){
        int gCF = computeGCF();

        int newN = numerator/gCF;

        int newD = denominator/gCF;
        Fraction r = new Fraction(newN, newD);

        return r;
    }

    //Computes the greatest common factor of the numerator and denominator
    private int computeGCF(){
        int gCF = 1;
        int lesser =1;
        boolean found = false;
        lesser = computeLesser(Math.abs(numerator), Math.abs(denominator));
        for(int candidate = lesser; (candidate>=1 && !found);candidate--){
            if(Math.abs(numerator)%candidate==0 && Math.abs(denominator)%candidate==0){
                found = true;
                gCF = candidate;
            }
        }
        return gCF;
    }

    //Returns the lesser integer between n1 and n2
    private int computeLesser(int n1, int n2){
        int lesser = n1;
        if(n1<n2){
            lesser = n1;
        } else
            lesser = n2;
        return lesser;
    }

    /**
     * Returns the sum of this fraction and another fraction other
     */
    public Fraction add(Fraction other){
        int den = denominator*other.getDenominator();
        int num = den/denominator*numerator + den/other.getDenominator()*other.getNumerator();
        Fraction s = new Fraction(num,den);
        return s.reduce();
    }

    /**
     * Returns the difference of this fraction and another fraction other
     */
    public Fraction subtract(Fraction other){
        int den = denominator* other.getDenominator();
        int num = den/denominator*numerator-den/other.getDenominator()*other.getNumerator();
        Fraction d = new Fraction(num,den);
        return d.reduce();
    }

    /**
     * Returns the product of this fraction and another fraction other
     */
    public Fraction multiplyBy(Fraction other){
        int den = denominator*other.getDenominator();
        int num = numerator*other.getNumerator();
        Fraction p = new Fraction(num,den);
        return  p.reduce();
    }

    /**
     * Returns the quotient of this fraction and another fraction other
     */
    public Fraction divideBy(Fraction other){
        int den = denominator*other.getNumerator();
        int num = numerator*other.getDenominator();
        Fraction q = new Fraction(num,den);
        return q.reduce();
    }

    /**
     * Returns true if the two fractions are the same
     */
    public boolean equals(Fraction other){
        return (numerator==other.getNumerator() && denominator==other.getDenominator());
    }

    /**
     * Returns a floating point number that is equal to this fraction
     */
    public double toDecimal(){
        return (double) numerator/denominator;
    }

    /**
     * Returns a mixed number that is equivalent to this fraction
     */
    public MixedNumber toMixedNumber(){
        int whole = numerator/denominator;
        int numFractionPart = numerator%denominator;
        MixedNumber m = new MixedNumber(whole, new Fraction(numFractionPart,denominator));
        return m;
    }


}//end of Fraction class
