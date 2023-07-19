package Part3;

import java.util.LinkedList;
import java.util.List;
/**
 * This class defines a polynomial as a linked list of terms.
 */
public class Polynomial {
    private List<Term> terms; // data member to reference a List of terms representing a polynomial
    /**
     * This constructor creates a LinkedList with no Terms
     */
    public Polynomial() throws Exception {
        terms = new LinkedList<Term>();
    }
    /**
     * This method adds a Term to the polynomial such that the terms are arranged following a
     * decreasing order of coefficients.
     * This method inserts a Term in the polynomial at the appropriate location if the degree of the
     * term is not equal to a degree of an existing Term.
     * If the degree of the Term is equal to a degree of an existing Term, the coefficient of the
     * existing Term is updated by adding the coefficient of the Term being added. If the updated
     * coefficient equals zero, the Term is removed from the polynomial.
     */
    public void addTerm(Term newTerm) throws Exception {
        int ctr;
        boolean found = false;
        Term currTerm = null;
        for (ctr = 0; ctr < terms.size(); ctr++) { // size method of LinkedList is used
            currTerm = terms.get(ctr); // get method of LinkedList is used
            if (currTerm.getDegree() <= newTerm.getDegree()) {
                found = true;
                break;
            }
        }
        if (!found) {
            terms.add(newTerm); // add method of List is used
        } else {
            if (currTerm.getDegree() < newTerm.getDegree()) {
                terms.add(ctr, newTerm); // alternative add method of List is used
            } else {
                currTerm.setCoef(currTerm.getCoef() + newTerm.getCoef());
                if (currTerm.getCoef() == 0) {
                    terms.remove(ctr); // remove method of the List class is used
                }
            }
        }
    }
    /**
     * This method formats a polynomial into a string of the following sample form:
     * 3x^2 - 5X + 3
     * This may need improvement...
     */
    public String toString() {
        String s = "";
        if (terms == null) return "0";
        for (int ctr = 0; ctr < terms.size(); ctr++) {
            Term currTerm = terms.get(ctr);
            if (currTerm.getCoef() > 0) {
                if (ctr != 0) {
                    s = s + " +";
                }
            } else {
                s = s + " -";
            }
            if (currTerm.getCoef() != 1 || currTerm.getDegree() == 0) {
                s = s + " " + Math.abs(currTerm.getCoef());
            }
            switch (currTerm.getDegree()) {
                case 0 :
                    break;
                case 1 :
                    s = s + (terms.get(0)).getLiteral();
                    break;
                default :
                    s = s + (terms.get(0)).getLiteral() + "^" + currTerm.getDegree();
            }
        }
        return s;
    }
    /**
     * This method evaluates the value of the polynomial if its literal is substituted
     * by the specified integer value.
     */
    public double evaluate(double value) throws Exception{
        double sum = 0;
        for (int ctr = 0; ctr < terms.size(); ctr++) {
            Term currTerm = terms.get(ctr);
            sum += currTerm.getCoef() * Math.pow(value, currTerm.getDegree());
        }
        return sum;
    }
    /**
     * This method sets this polynomial
     */
    public void setTerms(LinkedList<Term> t) {
        terms = t;
    }
    /**
     *This method returns this polynomial
     */
    public List<Term> getTerms() {
        return terms;
    }
    /**
     * This method adds a polynomial to this polynomial
     * 1. Create new Polynomial object
     * 2. Add the terms of this Polynomial to the new Polynomial object
     * 3. Add the terms of otherPolynomial to the new Polynomial object
     * 4. Return the new Polynomial
     */
    public Polynomial add(Polynomial otherPolynomial) throws Exception {
        Polynomial sP = new Polynomial();
        Polynomial sp2 = new Polynomial();

//        terms = getTerms();
        for(int j=0; j<terms.size(); j++){
            sP.addTerm(terms.get(j));
        }

        for(int i=0; i<otherPolynomial.getTerms().size(); i++){
           // sP.addTerm(otherPolynomial.getTerms().get(i));
        }

        return sP;
    }
    /**
     * This method subtracts a polynomial from this polynomial
     */
    public Polynomial subtract(Polynomial otherPolynomial) throws Exception {
        Polynomial dP = new Polynomial();

        return dP;

        // to do
    }
//    /**
//     * This method multiplies a polynomial to this polynomial.
//     * The method assumes that the polynomials have the same literals and
//     * it follows the prescription of the Term class.
//     */
//    public Polynomial multiply(Polynomial otherPolynomial) throws Exception {
//        // to do
//    }
//    /**
//     * This method divides this polynomial by another polynomial
//     */
//    public Quotient divide(Polynomial divisor) throws Exception {
//        // to do
//    }
}
