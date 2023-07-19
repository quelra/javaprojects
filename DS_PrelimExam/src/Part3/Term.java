package Part3;

/**
 The Term class is a template for a term of an algebraic polynomial that involves only one literal.
 3x^2 is an example of a term
 where: 3 is the numerical coefficient,
 x is the literal coefficient and
 2 is the degree
 */
public class Term implements Comparable<Term> {
    private double coef; // data member to hold numerical coefficient of a term
    private int degree; // data member to hold the degree of a term
    private char literal; // data member to hold the literal coefficient of a term
    /**
     * This a constructor that sets coefficient to 0, degree to 0 and literal to x.
     */
    public Term() {
        coef = 0;
        degree = 0;
        literal = 'x';
    }
    /**
     * This is a constructor that sets values of the coefficient, literal, and degree
     * to the integer coef, character literal and integer degree specified during instantiation
     */
    public Term(double coef, char literal, int degree) {
        this.coef = coef;
        this.literal = literal;
        this.degree = degree;
    }
    /**
     * This method sets the value of the numerical coefficient to the specified integer coef
     */
    public void setCoef(double coef) {
        this.coef = coef;
    }
    /**
     * This method sets the value of the literal coefficient to the specified character literal
     */
    public void setLiteral(char literal) {
        this.literal = literal;
    }
    /**
     * This method sets the value of the degree to the specified integer degree
     */
    public void setDegree(int degree) {
        this.degree = degree;
    }
    /**
     * This method returns the numerical coefficient of the term
     */
    public double getCoef() {
        return this.coef;
    }
    /**
     * This method returns the literal coefficient of the term
     */
    public char getLiteral() {
        return this.literal;
    }
    /**
     * This method returns the degree of the term
     */
    public int getDegree() {
        return this.degree;
    }
    /**
     * When comparing two terms of a polynomial, the term with a
     * higher degree should precede the term with a lower degree
     */
    public int compareTo(Term another) {
        if (this.getDegree() == another.getDegree()) {
            return 0;
        } else if (this.getDegree() > another.getDegree()) {
            return -1;
        } else {
            return 1;
        }
    }
    /**
     * This method returns a string representation of the term
     * that follows a format with the example 3x^2
     */
    public String toString() {
        return (coef + literal + "^" + degree);
    }
}