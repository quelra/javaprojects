/**
 * @author Dalos “Dale” Miguel
 * Tested/Debugged/Modified by: Bautista, Raquel S.
 * Activity Start Date : January 31, 2020
 * Class Schedule and Room : 9:30-11:00 TF D522
 *
 * A template for a student object intended for a class record of a university professor at Saint Louis University.
 */
public class Student {
    // data members (a.k.a. attributes )
    private String idNo; // A student has an ID number
    private String name; // A student has a name
    private String program; // A student has a course
    private byte year; // A student has a year level
    private int prelimRawScore; // A student has Class standing score for the entire prelims period
    private int perfectPrelimRawScore;
    private double prelimExamScore; // A student has a Raw Score for the prelim examination
    private double perfectPrelimExamScore;
    private byte prelimGrade; // A student has a grade for the prelims period
    private int midtermRawScore; // A student has a Class standing score for the entire midterms period
    private int perfectMidtermRawScore;
    private double midtermExamScore; // A student has a Raw Score for the midterm examination
    private double perfectMidtermExamScore;
    private byte midtermGrade; // A student has a grade for the midterms period
    private int finalRawScore; // A student has a Class standing score for the entire finals period
    private int perfectFinalRawScore;
    private double finalExamScore; // A student has a Raw Score for the final examination
    private double perfectFinalExamScore;
    private byte tentativeFinalGrade; // A student has a grade for the finals period
    private byte finalGrade; // A student has a final grade that is computed out of the prelim, midterm and tentative final grades
    private boolean passedFlag; // A student is associated a "passed" or "failed" remark based on a cutoff final grade
    private double prelimPercent;
    private double midtermPercent;
    private double finalsPercent;


// The following is the default constructor of the user-defined Student class
    /**
     Constructs a student object with ID number=20xxyy, name = Dela Cruz Juan A., program = BSIT, year=1,
     prelimRawScore=0, prelimExamScore=0, prelimGrade=50, midtermRawScore=0, midtermExamScore=0,
     midtermGrade=50,
     finalRawScore=0, finalExamScore=0, tentativeFinalGrade=50,
     finalGrade = (prelimGrade+midtermGrade+ tentativeFinalGrade)/3, passedFlag = false
     */
    public Student() {
        idNo = "20xxyy";
        name = "Dela Cruz Juan A.";
        program = "BSIT";
        year = 1;
        prelimRawScore = 0;
        perfectPrelimRawScore = 0;
        prelimExamScore = 0;
        perfectPrelimExamScore = 0;
        prelimGrade = 50;
        midtermRawScore = 0;
        perfectMidtermRawScore = 0;
        midtermExamScore = 0;
        perfectMidtermExamScore = 0;
        midtermGrade = 50;
        finalRawScore = 0;
        perfectFinalRawScore = 0;
        finalExamScore = 0;
        perfectFinalExamScore = 0;
        tentativeFinalGrade = 50;
        finalGrade = (byte) ((prelimGrade + midtermGrade + tentativeFinalGrade)/3 + 0.5);
        passedFlag = false;
        prelimPercent = 0;
        midtermPercent = 0;
        finalsPercent = 0;

    }
// The following are the constructors with parameters of the user-defined Student class.
// Because there are more than one constructors, the constructor is said to be overloaded.
    /**
     Constructs a student object with ID number= a given String id, name = a given name, program = a given program,
     year level= a given year, prelimRawScore=0, prelimExamScore=0, prelimGrade=50, midtermRawScore=0,
     midtermExamScore=0, midtermGrade=50, finalRawScore=0, finalExamScore=0, tentativeFinalGrade=50,
     finalGrade = (prelimGrade+midtermGrade+ tentativeFinalGrade)/3 + 0.5, passedFlag = false
     */
    public Student(String id, String name, String program, byte year) {
        idNo = id;
        this.name = name;
        this. program = program;
        this.year = year;
        prelimRawScore = 0;
        perfectPrelimRawScore = 0;
        prelimExamScore = 0;
        perfectPrelimExamScore = 0;
        prelimGrade = 50;
        midtermRawScore = 0;
        perfectMidtermRawScore = 0;
        midtermExamScore = 0;
        perfectMidtermExamScore = 0;
        midtermGrade = 50;
        finalRawScore = 0;
        perfectFinalRawScore = 0;
        finalExamScore = 0;
        perfectFinalExamScore = 0;
        tentativeFinalGrade = 50;
        finalGrade = (byte) ((prelimGrade + midtermGrade + tentativeFinalGrade)/3 + 0.5);
        passedFlag = false;
        prelimPercent = 0;
        midtermPercent = 0;
        finalsPercent = 0;
    }
    /**
     Constructs a student object with given ID number, name, program, year level, prelimRawScore, prelimExamScore,
     midtermRawScore, midtermExamScore, midtermGrade, finalRawScore, finalExamScore,
     prelimGrade = ((prelimRawScore * 50 +50) + (prelimExamScore*50 +50))/2,
     midtermGrade = ((midtermRawScore * 50 +50) + (midtermExamScore*50 +50))/2
     tentativeFinalGrade = ((finalRawScore * 50 +50) + (finalExamScore*50 +50))/2,
     finalGrade = (prelimGrade + midtermGrade + tentativeFinalGrade)/3,
     passedFlag = true if finalGrade is at least 75 and false otherwise.
     */

    public Student(String id, String name, String program, byte year, int prelimRawScore, double prelimExamScore, int midtermRawScore, double midtermExamScore, int finalRawScore, double finalExamScore ) {
        idNo = id;
        this.name = name;
        this. program = program;
        this.year = year;
        this.prelimRawScore = prelimRawScore;
        this.prelimExamScore = prelimExamScore;
        prelimGrade = (byte) (((prelimRawScore/100.0 * 50 +50) + (prelimExamScore/100*50 +50))/2 + 0.5 );
        if (prelimGrade == 100)

            prelimGrade = 99;
        if (prelimGrade < 65)


            prelimGrade = 65;
        this.midtermRawScore = midtermRawScore;
        this.midtermExamScore = midtermExamScore;
        midtermGrade = (byte) (((midtermRawScore/100.0 * 50 +50) + (midtermExamScore/100*50 +50))/2 + 0.5);
        if (midtermGrade == 100 )

            midtermGrade = 99;
        if (midtermGrade < 65 )



            midtermGrade = 65;
        this.finalRawScore = finalRawScore;
        this.finalExamScore = finalExamScore;
        tentativeFinalGrade = (byte) (((finalRawScore/100.0 * 50 +50) + (finalExamScore/100*50 +50))/2 +0.5 );
        if (tentativeFinalGrade == 100 )


            tentativeFinalGrade = 99;
        if (tentativeFinalGrade < 65 )


            tentativeFinalGrade = 65;
        finalGrade = (byte) ( (prelimGrade + midtermGrade + tentativeFinalGrade)/3 + 0.5);
        if (finalGrade <65)


            finalGrade = 65;
        if (finalGrade == 100 )
            finalGrade = 99;


        passedFlag = ( finalGrade >= 75? true: false);
    }
    /**
     Constructs a student object with given ID number, name, program, year level, prelimRawScore, prelimExamScore,
     midtermRawScore, midtermExamScore, midtermGrade, finalRawScore, finalExamScore,
     prelimGrade = ((prelimRawScore/100 * 50 +50) + (prelimExamScore/100*50 +50))/2 + 0.5, (adding 0.5 is for rounding it off)
     midtermGrade = ((midtermRawScore/100 * 50 +50) + (midtermExamScore/100*50 +50))/2 + 0.5
     tentativeFinalGrade = ((finalRawScore/100 * 50 +50) + (finalExamScore/100*50 +50))/2 + 0.5,
     finalGrade = (prelimGrade + midtermGrade + tentativeFinalGrade)/3 + 0.5,
     passedFlag = true if finalGrade is at least 75 and false otherwise.

     *Modifications:
     *1.The computation for prelimGrade, midtermGrade, tentativeFinalGrade, finalGrade was debugged and modified.
     * 2. Simplified passedFlag expression.
     */
    public Student(String id, String name, String program, byte year, int prelimRawScore, int perfectPrelimRawScore, double prelimExamScore, double perfectPrelimExamScore, int
            midtermRawScore, int perfectMidtermRawScore, double midtermExamScore, double perfectMidtermExamScore, int finalRawScore, int perfectFinalRawScore, double finalExamScore,
                   double perfectFinalExamScore, double prelimPercent, double midtermPercent, double finalsPercent) {
        idNo = id;
        this.name = name;
        this. program = program;
        this.year = year;
        this.prelimRawScore = prelimRawScore;
        this.perfectPrelimRawScore = perfectPrelimRawScore;
        this.prelimExamScore = prelimExamScore;
        this.perfectPrelimExamScore = perfectPrelimExamScore;
        prelimGrade = (byte) (((((double)prelimRawScore/100)*50 +50) + ((prelimExamScore/100)*50 +50))/2 + 0.5);
        this.midtermRawScore = midtermRawScore;
        this.perfectMidtermRawScore = perfectMidtermRawScore;
        this.midtermExamScore = midtermExamScore;
        this.perfectMidtermExamScore = perfectMidtermExamScore;
        midtermGrade = (byte) (((((double)midtermRawScore/100) * 50 +50) + ((midtermExamScore/100)*50 +50))/2 + 0.5);
        this.finalRawScore = finalRawScore;
        this.perfectFinalRawScore = perfectFinalRawScore;
        this.finalExamScore = finalExamScore;
        this.perfectFinalExamScore = perfectFinalExamScore;
        tentativeFinalGrade = (byte) (((((double)finalRawScore/100) * 50 +50) + ((finalExamScore/100)*50 +50))/2 + 0.5);
        if (prelimPercent == 0){
            finalGrade = (byte) ( (double)(prelimGrade + midtermGrade + tentativeFinalGrade)/3 + 0.5);
        } else {
            finalGrade = (byte) ((double) (prelimGrade * (prelimPercent / 100) + midtermGrade * (midtermPercent / 100) + tentativeFinalGrade * (finalsPercent / 100)) + 0.5);
        }
        passedFlag = (finalGrade >= 75);
        this.prelimPercent = prelimPercent;
        this.midtermPercent = midtermPercent;
        this.finalsPercent = finalsPercent;
    }
    /**
     Constructs a student object with given ID number, name, program, year level, prelimRawScore, prelimExamScore,
     midtermRawScore, midtermExamScore, midtermGrade, finalRawScore, finalExamScore, prelimGrade, midtermGrade,
     tentativeFinalGrade, finalGrade, passedFlag)
     */
    public Student(String id, String name, String program, byte year, int prelimRawScore, int perfectPrelimRawScore, double prelimExamScore,
                   double perfectPrelimExamScore, byte prelimGrade, int midtermRawScore, int perfectMidtermRawScore,
                   double midtermExamScore, double perfectMidtermExamScore, byte midtermGrade, int finalRawScore,
                   int perfectFinalRawScore, double finalExamScore, double perfectFinalExamScore,
                   byte tentativeFinalGrade, byte finalGrade, boolean passedFlag,double prelimPercent, double midtermPercent, double finalsPercent ) {
        idNo = id;
        this.name = name;
        this. program = program;
        this.year = year;
        this.prelimRawScore = prelimRawScore;
        this.perfectPrelimRawScore = perfectPrelimRawScore;
        this.prelimExamScore = prelimExamScore;
        this.perfectPrelimExamScore = perfectPrelimExamScore;
        this.prelimGrade = prelimGrade;
        this.midtermRawScore = midtermRawScore;
        this.perfectMidtermRawScore = perfectMidtermRawScore;
        this.midtermExamScore = midtermExamScore;
        this.perfectMidtermExamScore = perfectMidtermExamScore;
        this.midtermGrade = midtermGrade;
        this.finalRawScore = finalRawScore;
        this.perfectFinalRawScore = perfectFinalRawScore;
        this.finalExamScore = finalExamScore;
        this.perfectFinalExamScore = perfectFinalExamScore;
        this.tentativeFinalGrade = tentativeFinalGrade;
        this.finalGrade = finalGrade;
        this.passedFlag = passedFlag;
        this.prelimPercent = prelimPercent/100;
        this.midtermPercent = midtermPercent/100;
        this.finalsPercent = finalsPercent/100;
    }
// The following are the getter (a.k.a. accessor) methods
    /**
     *Returns the id number of a student
     **/
    public String getIdNo() {
        return idNo;
    }
    /**
     *Returns the name of a student
     **/
    public String getName() {
        return name;
    }
    /**
     *Returns the course of a student
     **/
    public String getProgram() {
        return program;
    }
    /**
     *Returns the year level of a student
     **/
    public byte getYear() {
        return year;
    }
    /**
     *Returns the total raw score of the student on all prelim activities except the prelim exam
     */
    public int getPrelimRawScore(){
        return prelimRawScore;
    }

    /**
     * Returns perfect score for prelim.
     */
    public int getPerfectPrelimRawScore(){
        return perfectPrelimRawScore;
    }
    /**
     *Returns the raw score of the student for the prelim exam
     */
    public double getPrelimExamScore(){
        return prelimExamScore;
    }

    public double getPerfectPrelimExamScore(){
        return perfectPrelimExamScore;
    }
    /**
     *Returns the prelim grade of the student
     */

    public byte getPrelimGrade(){
        return prelimGrade;
    }
    /**
     *Returns the total raw score of the student on all midterm activities except the midterm exam
     */
    public int getMidtermRawScore(){
        return midtermRawScore;
    }

    public  int getPerfectMidtermRawScore(){
        return perfectMidtermRawScore;
    }
    /**
     *Returns the raw score of the student for the midterm exam
     */
    public double getMidtermExamScore(){
        return midtermExamScore;
    }

    public double getPerfectMidtermExamScore(){
        return  perfectMidtermExamScore;
    }
    /**
     *Returns the midterm grade of the student
     */
    public byte getMidtermGrade(){
        return midtermGrade;
    }
    /**
     *Returns the total raw score of the student on all final activities except the final exam
     */
    public int getFinalRawScore(){
        return finalRawScore;
    }

    public int getPerfectFinalRawScore(){
        return perfectFinalRawScore;
    }
    /**
     *Returns the raw score of the student for the final exam
     */
    public double getFinalExamScore(){
        return finalExamScore;
    }

    public double getPerfectFinalExamScore(){
        return perfectFinalExamScore;
    }
    /**
     *Returns the tentative final grade of the student
     */
    public byte getTentativeFinalGrade(){
        return tentativeFinalGrade;
    }
    /**
     *Returns the final grade of the student
     */
    public byte getFinalGrade(){
        return finalGrade;
    }
    /**
     *Returns the remark, passed or failed, for the student
     */
    public boolean getPassedFlag(){
        return passedFlag;
    }

    public double getPrelimPercent(){
        return prelimPercent;
    }

    public double getMidtermPercent(){
        return midtermPercent;
    }

    public  double getFinalsPercent(){
        return finalsPercent;
    }


// The following are the setter (a.k.a. mutator) methods
    /**
     *Sets the id number of a student to a given String s
     **/
    public void setIdNo(String s) {
        idNo = s;
    }
    /**
     *Sets the name of a student to a given String name
     **/
    public void setName(String name) {
        this.name = name;
    }

    /**
     *Sets the course of a student to a given String course
     **/
    public void setProgram(String program) {
        this.program = program;
    }
    /**
     *Sets the year level of a student to a given int n
     **/
    public void setYear(byte n) {
        year = n;
    }
    /**
     *Sets the total raw score of the student on all prelim activities except the prelim exam to a given score
     */
    public void setPrelimRawScore(int score){
        prelimRawScore = score;
    }
    /**
     *Sets the raw score of the student for the prelim exam to a given score
     */
    public void setPrelimExamScore(double score){
        prelimExamScore = score;
    }
    /**
     *Sets the prelim grade of the student to a given grade
     */
    public void setPrelimGrade(byte grade){
        prelimGrade = grade;
    }
    /**
     *Sets the total raw score of the student on all midterm activities except the midterm exam to a given score
     */
    public void setMidtermRawScore(int score){
        midtermRawScore = score;
    }
    /**
     *Sets the raw score of the student for the midterm exam to a given score
     */
    public void setMidtermExamScore(double score){
        midtermExamScore = score;
    }
    /**
     *Sets the midterm grade of the student to a given grade
     */
    public void setMidtermGrade(byte grade){
        midtermGrade = grade;
    }
    /**
     *Sets the final grade of the student to a given garde
     */
    public void setFinalGrade(byte grade){
        finalGrade = grade;
    }
    /**
     *Sets the remark, passed or failed, for the student to a given value
     */
    public void setPassedFlag(boolean flagValue){
        passedFlag = flagValue;
    }
// The following is the definition of the toString method of the user-defined Student class
    /**
     * Returns a comma separated string that shows all the attribute values of the student
     **/
    public String toString() {
        return ( idNo + "," + name + ", " + program + "," + year + "," + prelimRawScore + "/" + perfectPrelimRawScore + ","  + prelimExamScore + "/" + perfectPrelimExamScore
                + "," + prelimGrade +","+ midtermRawScore + "/" + perfectMidtermRawScore + "," + midtermExamScore + "/" +
                perfectMidtermExamScore + "," + midtermGrade + "," + finalRawScore + "/" + perfectFinalRawScore + "," +
                finalExamScore + "/" + perfectFinalExamScore + "," + tentativeFinalGrade + "," + finalGrade + "," + passedFlag + "," + prelimPercent + "," + midtermPercent + "," + finalsPercent );
    }
} // end of Student class
