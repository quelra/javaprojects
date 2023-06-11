/**
 * @author Dalos “Dale” Miguel
 * Tested/Debugged/Modified by: Bautista, Raquel S.
 * Activity Start Date : January 31, 2020
 * Class Schedule and Room : 9:30-11:00 TF D522
.
This class is used to illustrate how the user-defined Reference Class Student may be used.
Template for a class record
 */
public class ClassRecord {
    private int numberOfStudents; // count of students included in the class record
    private Student[] arrayOfStudents; // to hold students included in the class record
    private String textDataFilename; // name of text file that contains the data for the students
    public ClassRecord(int n, Student[] s, String filename){
        numberOfStudents = n;
        arrayOfStudents = s;
        textDataFilename = filename;
    }
    /**
     *Sets number of students in the class record to a given number
     * */
    public void setNumberOfStudents(int number){
        numberOfStudents = number;
    }
    /**
     Sets the array of student included in the class record to a given array of Student
     */
    public void setArrayOfStudents(Student[] givenArray){
        arrayOfStudents= givenArray;
    }

    /**
     Sets to textFilename the name of the text data file where value of attributes of students in the class record are written
     */
    public void setTextDataFilename(String textFilename){
        textDataFilename = textFilename;
    }
    /**
     * Returns the count of students in the class record
     */
    public int getNumberOfStudents(){
        return numberOfStudents;
    }
    /**
     Returns the array of student objects included in the class record
     */
    public Student[] getArrayOfStudents(){
        return arrayOfStudents;
    }
    /**
     Returns the filename of the text data file that contains the values for the attributes of students included in the classrecord
     */
    public String getTextDataFilename(){
        return textDataFilename;
    }
    /**
     *Shows the list of students included in the class record in a line by line fashiom
     */
    public void showListOfStudents(){
        for (int index= 0; index < arrayOfStudents.length; index++){
            System.out.println(arrayOfStudents[index].toString());
        }
    }
} // end of ClassRecord class