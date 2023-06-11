/**
 Abstract class CurriculumDisplayer prescribes that the class has
 an ArrayList of Course objects and that there are methods for
 displaying the courses for each school term, for displaying the
 courses with corresponding grades for each school term,
 for editing the value of an attribute of a course, and for
 entering a grade for a course
 */
import java.io.*;
import java.util.*;

public abstract class CurriculumDisplayer  {
    protected ArrayList<SampleCourse> courses;  // for storing Course objects included in a curriculum

    /**
     *returns an ArrayList that is populated with Course objects
     *where the Course objects are constructed for data read from
     *a text file of Course details
     */
    public abstract ArrayList<SampleCourse> readData(String filename) throws FileNotFoundException;

    /**
     *displays a typical checklist where Course objects in an ArrayList
     * that are assigned for year level y
     * and school school term t are shown
     **/
    public abstract void showChecklistPerTerm(ArrayList<SampleCourse>courses, int y, int t);

    /**
     *displays a checklist where Course objects in and ArrayList
     *that are assigned for year level y and school term t with
     *valid grades are shown
     **/
    public abstract void showChecklistPerTermWithGrades(ArrayList<SampleCourse> courses, int y, int t);

    /**
     *returns the index of the location of a Course with a given courseNumber
     *  if the course exists in a given ArrayList but returns -1 if a Course with
     *  the given courseNumber is not in the given Array
     **/
    public abstract int isFound(String courseNumber, ArrayList<SampleCourse> courses);

    /**
     *updates the given ArrayList of Course objects by editing the attributes of
     * a course with a given course number
     **/
    public abstract void editCourse(ArrayList<SampleCourse> courses, String courseNumber) throws Exception;

    /**
     *updates the given ArrayList of Course objects after editing a grade attribute of
     * a course with a given course number
     **/
    public abstract void enterGrade(ArrayList<SampleCourse> courses, String courseNumber) throws Exception;

} // end of CurriculumDisplayer class
