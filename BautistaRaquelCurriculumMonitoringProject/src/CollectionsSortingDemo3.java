import java.lang.*;
import java.util.Scanner;
import java.util.Collections;
import java.util.ArrayList;

public class CollectionsSortingDemo3 {

    static Scanner keyboard =new Scanner(System.in);

    public static void main(String[] args) {
        CollectionsSortingDemo3 myTry;
        try {
            myTry = new CollectionsSortingDemo3();
            myTry.run();
        }  catch (Exception e) {
            e.printStackTrace();
        }
        System.exit(0);
    }

    public void run() throws Exception {

        ArrayList<SampleCourse2> courses = new ArrayList<SampleCourse2>(); //uses Sample Course2

        courses.add(new SampleCourse2("CS 111","Introduction to Computing",2.0f, (byte) 1, (byte) 1,90));
        courses.add(new SampleCourse2("CS 111L","Introduction to Computing (Lab)",1.0f, (byte) 1, (byte) 1,90));
        courses.add(new SampleCourse2("CS 112","Computer Programming 1",2.0f,(byte) 1, (byte) 1, 92));
        courses.add(new SampleCourse2("CS 112L","Computer Programming 1 (Lab)",1.0f,(byte) 1, (byte) 1, 92));
        courses.add(new SampleCourse2("CS 113","Discrete Structures",3.0f,(byte) 1, (byte) 1, 88));
        courses.add(new SampleCourse2("GMATH","Mathematics in the Modern World",3.0f,(byte) 1, (byte) 1, 91));

        System.out.println("\nCourses Entered:");
        showCourses(courses);

        Collections.sort(courses); //SampleCourse2 class uses the method compareTo to compare the descriptive title
        System.out.println("\nCourses Sorted Based on Descriptive Title:");
        showCourses(courses);
    } // end of run


    public void showCourses(ArrayList<SampleCourse2> courses){
        for (SampleCourse2 course: courses){
            System.out.println(course);
        }
    } // end of showCourses method

} // end of CollectionsSortingDemo3 class