/**
 *An application that reads from a textfile the data on courses
 *for a curriculum for a student .
 *
 *The data for one course are comma separated and are
 *  placed in in one line of the textfile.  The data
 *  are written orderly following the arrangement:
 *  year,term,course number, descriptive title, units, grade.
 *  For example; 2,1,PE 3,Individual/Dual Sports/Games,2,87
 *  is the line saying PE 3 is course number,
 *  PE 3 is a course for year level 2(second year),
 *  PE 3 is for term 1(first semester),
 *  PE 3 has the descriptive title Individual/Dual Sports/Games,
 *  PE 3 has 2 units
 *  PE 3 has the grade 87.
 *
 *The data read are used in constructing course objects.
 *The course objects are stored in an ArrayList.
 *
 *In the preparation of the data file, it is assumed
 *  that elective courses are assigned the
 *  course numbers Elective1, Elective2, etc.
 *
 *In the preparation of the data file, a 0 grade is assigned
 *  to each course that is not yet finished when the data
 *  file is created. Hence, if the grade assigned to a course is 0,
 *  it is implied that the student never enrolled the course yet.
 *
 *The valid year levels are 1=first yr,2=second yr,3=third yr and 4=fourth yr
 *The valid school terms are 1=first sem,2=second sem,3=short term
 *The valid number of units is an integer from 1 to 9.
 *The valid grade is an integer from 0 to 99.


 Notes:
 Algorithm for Checklist display


 displays a typical checklist where courses in an ArrayList of
 Course that are assigned for each school term from 1 to t under
 each year level from 1 to y are shown

 Input: ArrayList of Course objects, number of year levels,
 number of terms per year level
 Output: Screen display of courses for each term from term 1 to term t
 under the each of the year from year 1 to year y

 Assumptions:
 There is a method that gives the descriptive word equivalent
 to a given number representing a term
 There is a method that gives the descriptive word equivalent
 to a given number representing a year level.

 1. Receive the ArrayList of course, the number of year levels
 and the number of terms per year level
 2. For each of year from 1 to y
 2.1. for each term from 1 to t
 2.1.1. Print the needed labels. Call the methods to print word equivalent to year and
 word equivalent to term
 2.1.2. for each element(Course object) of the ArrayList
 2.1.2.1.if year and term attributes of the element(Course object)
 are equal to the current values of year and term
 2.1.2.1.1.print a formatted string representation of the
 element(Course Object)
 2.1.3. Pause and wait the users cue to continue
 ...
 **/


import java.util.*;
import java.io.*;

public class BSCSCurriculumMonitoringApplication extends CurriculumDisplayer{
    private static Scanner filePointer = null;
    private PrintWriter outputStream;
    private String sourceFile ="BSCSCurriculumData1.txt";
    private String targetPrintFile="BSCSCurriculumData1.txt";

    public static void main(String[] args){
        BSCSCurriculumMonitoringApplication program;
        try{
            program = new BSCSCurriculumMonitoringApplication();
            program.run();
        } catch (FileNotFoundException e1){
            System.out.println("The text file does not exist");
            System.out.println(e1.getMessage());
            e1.printStackTrace();
        } catch (Exception x){
            x.printStackTrace();
        } finally {
            filePointer.close();
        }
        System.exit(0);
    }

    /**
     *returns the number of lines of text in a textfile
     **/
    public int countLines(String filename) throws FileNotFoundException{
        filePointer = new Scanner(new File(filename));
        int count = 0;
        while (filePointer.hasNextLine()){
            String line = filePointer.nextLine(); // remove line and move pointer
            count = count + 1;
        }
        filePointer.close();
        return count;
    }

    // method invoked by main method
    public void run() throws Exception {
        Scanner keyboard = new Scanner(System.in);
        int nElements = countLines(sourceFile);
        // the ArrayList should have as many cells as there are lines in the source textfile
        courses = new ArrayList<SampleCourse>(nElements);  // instantiate the array declared in parent class
        String number = "";
        courses = readData(sourceFile);
        int choice=0;
        while (choice != 6) {
            showMenu();
            choice = readChoice(1,6);
            switch (choice){
                case 1: showChecklistPerTerm(courses,4,3);
                    break;
                case 2:
                    showChecklistPerTermWithGrades(courses,4,3);
                    break;

                case 3:
                    number = "";
                    System.out.print("Enter the course number of the course for which a grade will be entered: ");
                    number = keyboard.nextLine();
                    enterGrade(courses, number);
                    break;

                case 4:
                    number = "";
                    System.out.print("Enter the course number of the course to be edited: ");
                    number = keyboard.nextLine();
                    editCourse(courses, number);
                    break;

                case 5:
                    Collections.sort(courses, Collections.reverseOrder());
                    System.out.println("\nCourses Sorted Based on Grades:");
                    showChecklistPerTermWithGrades(courses,4,3);

                case 6:
                    System.out.println("..Thank you. ");

            } // end of switch
        }  // end of while
    } // end of run

    /**
     *Read and returns a valid choice. A valid choice is an integer
     *  in the range low to high
     **/
    private int readChoice(int low, int high){
        int choice=0;
        while (choice < low || choice > high){
            choice = readInt("Enter a number ");
            if (choice< low || choice > high){
                System.out.println("The number must be from "+low+ " to " + high +".");
            }
        }
        return choice;
    }



    /**
     *Reads and returns a valid integer from the keyboard
     **/
    public int readInt(String prompt){
        Scanner keyboard = new Scanner(System.in);
        int value=0;
        boolean noProblem = false;
        do {
            try {
                System.out.print(prompt + ":");
                value = Integer.parseInt(keyboard.nextLine());
                noProblem = true;
            } catch (Exception e ){
                System.out.print("You entered an invalid integer. Please enter an integer: ");
            }
        } while (!noProblem);

        return value;
    }

    /**
     *Reads and returns a valid floating point number from the keyboard
     **/
    public float readFloat(String prompt){
        Scanner keyboard = new Scanner(System.in);
        float value=0;
        boolean noProblem = false;
        do {
            try {
                System.out.print(prompt + ":");
                value = Float.parseFloat(keyboard.nextLine());
                noProblem = true;
            } catch (Exception e ){
                System.out.print("You entered an invalid floating point number. Please enter a floating point number: ");
            }
        } while (!noProblem);

        return value;
    }


    /**
     *Shows the main menu for this application
     **/
    public void showMenu(){
        System.out.println("Monitoring of my Progress in my BSCS Curriculum");
        System.out.println("<Raquel Bautista>");
        System.out.println("================================================");
        System.out.println("<1> Show subjects for each school term");
        System.out.println("<2> Show subjects with grades for each term");
        System.out.println("<3> Enter grades for subjects recently finished");
        System.out.println("<4> Edit a course");
        System.out.println("<5> Show subjects with grades from highest to lowest");
        System.out.println("<6> Quit");
    }

    /**
     *returns an ArrayList of Course that is populated with Course objects
     *where the Course objects are constructed for data read from
     *a textfile of Course details
     */
    public ArrayList<SampleCourse> readData(String filename) throws FileNotFoundException{
        ArrayList<SampleCourse>  listOfCourses = new ArrayList<SampleCourse>(countLines(filename));
        String lineOfText="";
        int lineNumber=0;
        try {
            filePointer = new Scanner( new File(filename));
            while ( filePointer.hasNextLine() ){
                lineNumber += 1;
                lineOfText = filePointer.nextLine();
                String[] data = lineOfText.split(",");
                byte year = Byte.parseByte(data[0].trim());
                byte term = Byte.parseByte(data[1].trim());
                String number = data[2];
                String title = data[3];
                float units = Float.parseFloat(data[4].trim());
                int grade = Integer.parseInt(data[5]);
                SampleCourse c = new SampleCourse(number,title,units,year,term,grade);
                listOfCourses.add(c);
            }
        } catch (Exception e2){
            System.out.println("There is a problem in the data read from line " + lineNumber + " of the data file.");
            System.out.println("The program execution needed to terminate.");
            System.out.println("Please fixed the problem on the data file.");
            e2.printStackTrace();
        }
        return listOfCourses;
    }

    /**
     *returns the word form of a year level
     *if (year == 1) return "First Year"
     *if (year == 2) return "Second Year"
     *if (year == 3) return "Third Year"
     *if (year == 4) return "Fourth Year"
     **/
    public String yearInWord(byte y){
        switch (y){
            case 1: return "First Year";
            case 2: return "Second Year";
            case 3: return "Third Year";
            case 4: return "Fourth Year";
        }
        return "Unknown year";
    }

    /**
     *returns the word form of a school term
     *if (term == 1) return "First Semester"
     *if (term == 2) return "Second Semester"
     *if (term == 3) return "Short Term"
     **/
    public String termInWord(byte t){
        switch (t){
            case 1: return "First Semester";
            case 2: return "Second Semester";
            case 3: return "Short Term";
        }
        return "Unknown year";
    }


    /**
     *displays a typical checklist where courses in an ArrayList of
     * Course that are assigned for year level 1 to y
     *  and school term from 1 to t are shown
     **/
    public void showChecklistPerTerm(ArrayList<SampleCourse> courses, int y, int t){
        Scanner keyboard= new Scanner(System.in);
        for (byte year = 1; year <=y; year++){
            for (byte term=1; term <=t; term++){
                System.out.println("------------------------------------------------------------------------------------------------------");
                System.out.println("Year = " + yearInWord(year) + "  Term = " + termInWord(term));
                System.out.printf("%-13s%-55s%-6s%n","Course No", "Descriptive title", "Units");
                System.out.println("------------------------------------------------------------------------------------------------------");
                for (int index=0; index<courses.size(); index++){
                    if(courses.get(index).getYearLevel()==year && courses.get(index).getTerm()==term)
                        System.out.printf("%-13s%-55s%-5.1f%n", courses.get(index).getNumber(),courses.get(index).getTitle(),courses.get(index).getUnits());
                }
                System.out.println();
                System.out.println("Press enter key to see courses for the next term.");
                keyboard.nextLine();
            }
        }

    }

    /**
     *displays a checklist where courses in an ArrayList of Course
     *that are assigned for year level 1 to y and school term from 1 to t
     *with valid grades are shown
     **/
    public void showChecklistPerTermWithGrades(ArrayList<SampleCourse> courses, int y, int t){
        Scanner keyboard = new Scanner(System.in);
        for (byte year = 1; year <=y; year++){
            for (byte term=1; term <=t; term++){
                System.out.println("------------------------------------------------------------------------------------------------");
                System.out.println("Year = " + yearInWord(year) + "  Term = " + termInWord(term));
                System.out.printf("%-13s%-55s%-6s%-6s%n","Course Number", "Descriptive title", "Units", "Grade");
                System.out.println("------------------------------------------------------------------------------------------------");
                for (int index=0; index<courses.size(); index++){
                    if(courses.get(index).getYearLevel()==year && courses.get(index).getTerm()==term){
                        System.out.printf("%-13s%-55s%-5.1f", courses.get(index).getNumber(),courses.get(index).getTitle(),courses.get(index).getUnits());
                        if (courses.get(index).getGrade()==0)
                            System.out.println("Not yet finished");
                        else
                            System.out.printf("%d%n",courses.get(index).getGrade());
                    }
                }
                System.out.println();
                System.out.println("Press enter key to see courses for the next term.");
                keyboard.nextLine();
            }
        }
    }

    /**
     *returns the index of the location of a course with a given courseNumber
     *  if the course exists in a given Array but returns -1 if a course with
     *  the given courseNumber does not belong to the given ArrayList
     **/
    public int isFound(String courseNumber, ArrayList<SampleCourse> courses){
        for(int index=0; index<courses.size(); index++){
            if (courses.get(index).getNumber().equals(courseNumber))
                return index;
        }
        return -1;
    }

    /**
     *updates the Array of Course by editing the attributes of
     * a course with a given course number
     **/
    public void editCourse(ArrayList<SampleCourse> courses, String courseNumber) throws Exception{
        int location = isFound(courseNumber, courses);
        if (location == -1)
            System.out.println("The course number entered is not in the curriculum.");
        else {
            editACourse(courses.get(location));
            printToFile(courses, targetPrintFile);
        }

    }

    /**
     *updates the Array of Course after editing a grade attribute of
     * a course with a given course number
     **/
    public void enterGrade(ArrayList<SampleCourse> courses, String courseNumber) throws Exception{
        int location = isFound(courseNumber, courses);
        if (location == -1)
            System.out.println("The course number entered is not in the curriculum.");
        else {
            enterACourseGrade(courses.get(location));
            printToFile(courses, targetPrintFile);
        }
    }

    /**
     *reads and returns 'y' or 'n'
     **/
    private char readYesOrNo(String prompt){
        Scanner keyboard = new Scanner(System.in);
        char ans='x';
        while (Character.toLowerCase(ans) != 'y' && Character.toLowerCase(ans) != 'n' ){
            System.out.print(prompt+": ");
            ans = keyboard.nextLine().charAt(0);
            if (Character.toLowerCase(ans) != 'y' && Character.toLowerCase(ans) != 'n' ){
                System.out.println("You have to type y or n.");
            }
        }
        return Character.toLowerCase(ans);
    }


    /**
     *Returns a course object that is the result of modifying
     *   a given course object
     **/
    private SampleCourse editACourse(SampleCourse oldCourse){
        Scanner keyboard = new Scanner(System.in);
        SampleCourse newCourse = oldCourse;
        boolean gradeStringChanged = false;
        char response='x';
        String input="";
        System.out.println("Year for " + newCourse.getNumber() + " is " + newCourse.getYearLevel()+".");
        System.out.println("Term for " + newCourse.getNumber() + " is " + newCourse.getTerm()+".");
        System.out.println("Descriptive Title for " + newCourse.getNumber() + " is " + newCourse.getTitle()+".");
        System.out.println("Units for " + newCourse.getNumber() + " is " + newCourse.getUnits()+".");
        System.out.println("Grade for " + newCourse.getNumber() + " is " + newCourse.getGrade()+".");
        response= readYesOrNo("Do you need to edit the year <y/n>?");
        if (response == 'y')
            newCourse.setYearLevel((byte) readChoice(1,4));
        response= readYesOrNo("Do you need to edit the term?<y/n>");
        if (response == 'y')
            newCourse.setTerm((byte) readChoice(1,4));
        response= readYesOrNo("Do you need to edit the course number?<y/n>");
        if (response == 'y'){
            String newValue1="";
            while (newValue1.equals("")){
                System.out.print("Enter the new course number: ");
                newValue1 = keyboard.nextLine();
            }
            newCourse.setNumber(newValue1);
        }
        response= readYesOrNo("Do you need to edit the course descriptive title?<y/n>");
        if (response == 'y'){
            String newValue2="";
            while (newValue2.equals("")){
                System.out.print("Enter the new descriptive title: ");
                newValue2 = keyboard.nextLine();
            }
            newCourse.setTitle(newValue2);
        }
        response= readYesOrNo("Do you need to edit the number of units?<y/n>");
        if (response == 'y'){
            newCourse.setUnits(readFloat("Enter New Number of Units: "));
        }
        response= readYesOrNo("Do you need to edit the grade  for the course?<y/n>");
        if (response == 'y'){
            int newGrade = readInt("Enter new grade");
            newCourse.setGrade(newGrade);
        }

        System.out.println("The following is the summary of the new course data.");
        System.out.println(newCourse.toString());
        response = readYesOrNo("Do you want to make the changes permanent?<y/n>");
        if (response == 'y')
            return newCourse;
        else
            return oldCourse;
    }

    /**
     *Returns a course object that is the result after modifying the grade for
     *   a given course object
     **/
    private SampleCourse enterACourseGrade(SampleCourse oldCourse) throws Exception{
        Scanner keyboard = new Scanner(System.in);
        SampleCourse newCourse = oldCourse;
        char response='x';
        System.out.println("Year for " + newCourse.getNumber() + " is " + newCourse.getYearLevel()+".");
        System.out.println("Term for " + newCourse.getNumber() + " is " + newCourse.getTerm()+".");
        System.out.println("Descriptive Title for " + newCourse.getNumber() + " is " + newCourse.getTitle()+".");
        System.out.println("Units for " + newCourse.getNumber() + " is " + newCourse.getUnits()+".");
        System.out.println("Grade for " + newCourse.getNumber() + " is " + newCourse.getGrade()+".");
        System.out.print("Enter the new grade for " + newCourse.getNumber()+": ");
        int newGrade = Integer.parseInt(keyboard.nextLine());
        newCourse.setGrade(newGrade);
        System.out.println("The following is the summary of the new course data.");
        System.out.println(newCourse.toString());
        response = readYesOrNo("Do you want to make the changes permanent?<y/n>");
        if (newCourse.getNumber().equals("CSE")) {
            System.out.println("You have to edit the course so that the course number is changed from CSE to the actual course number");
            System.out.println("Choose the option to edit the course and enter the necessary changes. Otherwise, your grade for the elective course will not be recorded properly.");
            System.out.print("Press enter to continue.");
            keyboard.nextLine();
        }
        if (response == 'y')
            return newCourse;
        else
            return oldCourse;
    }

    /**
     *Writes the courses in a given Array of courses to a data file
     **/
    private void printToFile(ArrayList<SampleCourse> courses, String fileName) throws Exception{
        PrintWriter writer = new PrintWriter(new FileWriter(fileName));
        for (int index=0; index<courses.size(); index++){
            writer.println(courses.get(index).toString());
        }
        writer.close();
    }

}  // end of BSCSCurriculumMonitoringApplication class