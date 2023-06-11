/**

 * @author Dalos “Dale” Miguel
 * Tested/Debugged/Modified by: Bautista, Raquel S.
 * Activity Start Date : January 31, 2020
 * Class Schedule and Room : 9:30-11:00 TF D522
 *
 * A sample program that involves dealing with grades of students by a university professor at Saint Louis University.
This class is used to illustrate how the user-defined Reference Class Student may be used.
 * */
import java.io.FileWriter;
import java.io.PrintWriter;
import java.lang.*;
import java.util.Scanner;
public class TestStudent {
    public static void main(String[] args){
        TestStudent myTest;
        try {
            myTest = new TestStudent();
            myTest.run();
        }catch (Exception exception){
            exception.printStackTrace();
        }
        System.exit(0);
    }
    /**
     Create and shows a record of one student
     */
    public void run(){
        Student student=null;
        student = readStudent();
        displayStudentRecordWithAppropriateLabels(student);

    }
    /**
     Returns a student object that is constructed after accepting the values for the instance variables of a Student.
     1. Construct an object of the Scanner class that will be used to read data from the keyboard
     2. Declare a variable of type Student and initialize the variable to a null object
     3. Read the id number of the student
     4. Read the name of the student
     5. Read the program of the student
     6. Read the year level of the student
     7. Read the total score of the student for the requirements for the prelims
     8. Read the score of the student for the prelim exam
     9. Read the total score of the student for the requirements for the midterms
     10. Read the score of the student for the midterm exam
     11. Read the total score of the student for the requirements for the finals
     12. Reade the score of the student for the final exams
     13. Construct a student object by using the data that were read
     14. Return the student object
     */
    public Student readStudent(){
        Scanner scanner = new Scanner(System.in);
        Student student= null;
        System.out.println("STUDENT DETAILS");
        System.out.print("Enter id number of the student: ");
        String id = scanner.nextLine();
        System.out.print("Enter name of student: ");
        String name = scanner.nextLine();
        System.out.print("Enter program of student: ");
        String program = scanner.nextLine();
        System.out.print("Enter year level of student: ");
        byte year = readValidYearLevel((byte)5);
        System.out.println("PRELIMS");
        System.out.print("Enter perfect prelim raw score:");
        int perfectPScore = scanner.nextInt();
        System.out.print("Enter student's raw score for prelims: ");
        int pScore = readValidRawScore(0,perfectPScore);
        System.out.print("Enter perfect prelim exam score: ");
        double perfectPExamScore = scanner.nextDouble();
        System.out.print("Enter student's prelim exam score: ");
        double pExamScore = readValidExamScore(0,perfectPExamScore);
        System.out.println("MIDTERMS");
        System.out.print("Enter perfect midterm raw score: ");
        int perfectMScore  = scanner.nextInt();
        System.out.print("Enter student's raw score for midterms: ");
        int mScore = readValidRawScore(0,perfectMScore);
        System.out.print("Enter perfect midterm exam score: ");
        double perfectMExamScore = scanner.nextDouble();
        System.out.print("Enter student's midterm exam score: ");
        double mExamScore = readValidExamScore(0,perfectMExamScore);
        System.out.println("FINALS");
        System.out.print("Enter perfect finals raw score: ");
        int perfectFScore = scanner.nextInt();
        System.out.print("Enter student's raw score for finals: ");
        int fScore = readValidRawScore(0,perfectFScore);
        System.out.print("Enter perfect finals exam score: ");
        double perfectFExamScore = scanner.nextDouble();
        System.out.print("Enter student's final exam score: ");
        double fExamScore = readValidExamScore(0,perfectFExamScore);
        System.out.println("PERCENTAGE");
        System.out.println("Prelim(%): ");
        double prelimPercent = scanner.nextDouble();
        System.out.println("Midterm(%): ");
        double midtermPercent = scanner.nextDouble();
        System.out.println("Finals(%): ");
        double finalsPercent = scanner.nextDouble();

        student = new Student(id,name,program,year,pScore,perfectPScore,pExamScore,perfectPExamScore,mScore,perfectMScore,
                mExamScore,perfectMExamScore,fScore,perfectFScore,fExamScore,perfectFExamScore,prelimPercent,midtermPercent,finalsPercent);
        return student;
    }

    /**
     *Returns a valid year level that is entered through the keyboard where the valid year level is a whole
     * number in the range 1 to a given highestPossibleYear.
     *1. Construct an object of the Scanner class that will be used to read values from the keyboard
     *2. Declare year as a variable of type byte with an initial value of 0
     *3. Declare validValueIsRead as a boolean variable with an initial value of false
     *4. while validValuedIsRead is false
     * 4.1. Accept a string from the keyboard
     * 4.2. Convert the accepted string to a byte and assign it to year
     * 4.2.1. If the accepted string cannot be converted to a byte, print an error message and repeat step 4
     * 4.3. set validValueIsRead to true
     * 4.4. if the value of year is not in the range 1 to highestPossibleYear
     * 4.4.1. Print a message on the screen informing the user that the year must be a number from 1 to highestPossibleYear
     * 4.4.2. Set validValueIsRead = false
     * 4.4.3. Repeat step 4
     *5. Return year
     */
    public byte readValidYearLevel(byte highestPossibleYear){
        Scanner scanner = new Scanner(System.in);
        byte year=0;
        boolean validValueIsRead = false;
        while ( !validValueIsRead ){
            try {
                year = Byte.parseByte(scanner.nextLine());
                validValueIsRead = true;
                if (year < 1 || year > highestPossibleYear) {
                    System.out.println("You have to enter a number from 1 to " + highestPossibleYear+".");
                    validValueIsRead = false;
                }
            } catch (NumberFormatException nfe){
                System.out.println("You have entered an invalid number. You have to enter a number from 1 to " +
                        highestPossibleYear + ".");
                validValueIsRead = false;
            }
        } // end of while
        return year;
    } // end of readValidYearLevel
    /**
     *Returns a valid raw score that is entered through the keyboard where the valid score is a whole
     * number in the range minimum to a maximum.
     *1. Construct an object of the Scanner class that will be used to read values from the keyboard
     *2. Declare score as a variable of type int with an initial value of 0
     *3. Declare validValueIsRead as a boolean variable with an initial value of false
     *4. while validValuedIsRead is false
     * 4.1. Accept a string from the keyboard
     * 4.2. Convert the accepted string to an integer and assign it to score
     * 4.2.1. If the accepted string cannot be converted to an integer, print an error message and repeat step 4
     * 4.3. set validValueIsRead to true
     * 4.4. if the value of score is not in the minimum to maximum
     * 4.4.1. Print a message on the screen informing the user that the score must be a number from minimum to maximum
     * 4.4.2. Set validValueIsRead = false
     * 4.4.3. Repeat step 4
     *5. Return score
     */
    public int readValidRawScore(int minimum, int maximum){
        Scanner scanner = new Scanner(System.in);
        int score=0;
        boolean validValueIsRead = false;
        while ( !validValueIsRead ){
            try {
                score = Integer.parseInt(scanner.nextLine());
                validValueIsRead = true;
                if (score < minimum || score > maximum) {
                    System.out.println("You have to enter a number from " +minimum + " to " + maximum+".");
                    validValueIsRead = false;
                }
            } catch (NumberFormatException nfe){
                System.out.println("You have entered an invalid number. You have to enter a number from "+minimum+ " to " + maximum + ".");
                        validValueIsRead = false;
            }
        } // end of while
        return score;
    } // end of readValidRawScore

    /**
     *Returns a valid exam score that is entered through the keyboard where the valid exam score is a floating point
     * number in the range minimum to a maximum.
     *1. Construct an object of the Scanner class that will be used to read values from the keyboard
     *2. Declare score as a variable of type double with an initial value of 0
     *3. Declare validValueIsRead as a boolean variable with an initial value of false
     *4. while validValuedIsRead is false
     * 4.1. Accept a string from the keyboard
     * 4.2. Convert the accepted string to a double and assign it to score
     * 4.2.1. If the accepted string cannot be converted to a double, print an error message and repeat step 4
     * 4.3. set validValueIsRead to true
     * 4.4. if the value of score is not in the minimum to maximum
     * 4.4.1. Print a message on the screen informing the user that the score must be a number from minimum to maximum
     * 4.4.2. Set validValueIsRead = false
     * 4.4.3. Repeat step 4
     *5. Return score
     */
    public double readValidExamScore(double minimum, double maximum){
        Scanner scanner = new Scanner(System.in);
        double score=0;
        boolean validValueIsRead = false;
        while ( !validValueIsRead ){
            try {
                score = Double.parseDouble(scanner.nextLine());
                validValueIsRead = true;
                if (score < minimum || score > maximum) {
                    System.out.println("You have to enter a number from " +minimum + " to " + maximum+".");
                    validValueIsRead = false;
                }
            } catch (NumberFormatException nfe){
                System.out.println("You have entered an invalid number. You have to enter a number from "+minimum+ " to " + maximum + ".");
                        validValueIsRead = false;
            }
        } // end of while
        return score;
    } // end of readValidRawScore
    /**
     Displays the attribute values of a given student object with descriptive labels
     1. Receive a student object
     2. Show the id number of the student
     3. Show name of the student
     4. Show the program of the student
     5. Show the student's total raw score for the prelim requirements
     6. Show the student's prelim examination score
     7. Show the student's total raw score for the midterm requirements
     8. Show the student's midterm examination score
     9. Show the student's total raw score for the finals period
     10. Show the student's final examination score
     11. Show the student's Prelim Grade
     12. Show the student's Midterm Grade
     13. Show the student's Tentative Final Grade
     14. Show the student's Final Grade
     */
    public void displayStudentRecordWithAppropriateLabels(Student student){
        System.out.println("\n------------------------------------------------------------------------");
        System.out.printf("%-25s%-40s%n","ID Number : ", student.getIdNo());
        System.out.printf("%-25s%-40s%n","Name of Student : ",student.getName());
        System.out.printf("%-25s%-40s%n","Program : ",student.getProgram());
        System.out.printf("%-25s%-40d%n","Year Level : ",student.getYear());
        System.out.println("\nPeriodic total scores for all requirements");
        System.out.printf("%-10s%-6d%-10s%-6d%-10s%-6d%n","Prelims : ",student.getPrelimRawScore(), "Midterms : ",student.getMidtermRawScore(),"Finals : ",student.getFinalRawScore());
        System.out.println("\nPeriodic Examination Scores");
        System.out.printf("%-10s%-6.0f%-10s%-6.0f%-10s%-6.0f%n","Prelims : ",student.getPrelimExamScore(),"Midterms: ",student.getMidtermExamScore(),"Finals: ",student.getFinalExamScore());
        System.out.println("\nPeriodic Grades");
        System.out.printf("%-10s%-6d%-10s%-6d%-10s%-6d%n","Prelims : ",student.getPrelimGrade(),"Midterms: ",student.getMidtermGrade(),"Finals: ",student.getTentativeFinalGrade());
        System.out.printf("%n%-15s%-5d%15s","FINAL GRADE : ",student.getFinalGrade(),"Remarks : ");
        if (student.getPassedFlag())
            System.out.println("PASSED");
        else
            System.out.println("FAILED");
        System.out.println("\n===================================================");
    }
    public String writeToFile(Student[] students) {
        Scanner keyboard = new Scanner(System.in);
        PrintWriter fileWriter = null;
        String filename="";
        System.out.println("The values of the fields for student objects that are created after reading the contents of the textdata file will be written in another text data file.");
        System.out.print("Please carefully type the name of the file where the field values of students will be written<example:classlist1.txt> :");
        filename = keyboard.nextLine();
        try {
            fileWriter = new PrintWriter(new FileWriter(filename));
            for (int index= 0; index < students.length; index++){
                fileWriter.println(students[index].toString());
            }
            System.out.println("Data for the created student objects have been successfully written in " + filename +".");
        } catch (Exception ex){
            ex.printStackTrace();
        } finally {
            fileWriter.close();
        }
        return filename;
    } // end of writeToFile method
}