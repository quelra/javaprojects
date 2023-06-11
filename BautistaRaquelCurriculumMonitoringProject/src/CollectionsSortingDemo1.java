import java.lang.*;
import java.util.Scanner;
import java.util.Collections;
import java.util.ArrayList;

public class CollectionsSortingDemo1 {

    static Scanner keyboard =new Scanner(System.in);

    public static void main(String[] args) {
        CollectionsSortingDemo1 myTry;
        try {
            myTry = new CollectionsSortingDemo1();
            myTry.run();
        }  catch (Exception e) {
            e.printStackTrace();
        }
        System.exit(0);
    }

    public void run() throws Exception {

        ArrayList<SampleCourse> courses = new ArrayList<SampleCourse>();

        courses.add(new SampleCourse("CS 111","Introduction to Computing",2.0f, (byte) 1, (byte) 1,90));
        courses.add(new SampleCourse("CS 111L","Introduction to Computing (Lab)",1.0f, (byte) 1, (byte) 1,90));
        courses.add(new SampleCourse("CS 112","Computer Programming 1",2.0f,(byte) 1, (byte) 1, 92));
        courses.add(new SampleCourse("CS 112L","Computer Programming 1 (Lab)",1.0f,(byte) 1, (byte) 1, 92));
        courses.add(new SampleCourse("CS 113","Discrete Structures",3.0f,(byte) 1, (byte) 1, 88));
        courses.add(new SampleCourse("GMATH","Mathematics in the Modern World",3.0f,(byte) 1, (byte) 1, 91));

        System.out.println("\nCourses Entered:");
        showCourses(courses);

        Collections.sort(courses); //will sort it by grade because the method compareTo in the SampleCourse Class compare the grade
        System.out.println("\nCourses Sorted Based on Grades:");
        showCourses(courses);
    } // end of run


    public void showCourses(ArrayList<SampleCourse> courses){
        for (SampleCourse course: courses){
            System.out.println(course);
        }
    } // end of showCourses method

} // end of CollectionsSortingDemo1 class

