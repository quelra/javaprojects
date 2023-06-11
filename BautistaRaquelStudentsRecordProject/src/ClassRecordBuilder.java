

/**
 Executable class used to make a class record for a class (group of students)
 This class will also allow the user to make updates/entries to the class record


 Input: text file containing the initial list of students belonging to the class (i.e. class checklist)
 Output: Class Record ( object of class record that has numberOfStudents, arrayOfStudents and textDataFilename


 */
        import java.lang.*;
        import java.util.Scanner;
        import java.io.*;

public class ClassRecordBuilder{

    public static void main(String[] args) {
        ClassRecordBuilder program;
        try {
            program = new ClassRecordBuilder();
            program.run();
        } catch (FileNotFoundException exception1){
            System.out.println("The filename entered is not valid. No such file. ");
        } catch (Exception x){
            x.printStackTrace();
        }
        System.exit(0);
    } // end of main method

    /**
     do


     1. Show the menu for the application
     2. Accept the user's choice (1,2,3,4,5) of task to do
     3. If choice is 1, invoke makeANewClassRecord
     else
     if choice is 2, invoke showAllStudentsInTheClassrecord
     else
     if choice is 3, invoke showStudentsOneAtATime
     else
     if choice is 4, invoke activateAnExistingClassRecord and give the activated class record to updateAClassRecord
     else
     close the application
     while choice is not corresponding to quit
     */
    public void run() throws FileNotFoundException{
        String checklistFilename="";
        String filenameOfTextDataFile = "";
        Student[] students = null;
        int numberOfStudents = 0;
        ClassRecord classRecord = null;
        Scanner keyboard = new Scanner(System.in);
        Scanner filePointer = null;
        String commaSeparatedLineOfString="";
        PrintWriter fileWriter = null;
        char areYouReady = 'x';
        byte choice = (byte) 0;

        do {
            showMenu();
            choice = readChoice((byte) 1, (byte) 5);
            switch (choice){
                case 1:
                    classRecord = makeANewClassRecord();
                    System.out.println("You may choose to quit the application. Upon running, you may use option 2,3 or 4 immediately. ");
                    System.out.println("If you do not choose to quit, you may use the newly created classrecord. ");
                    break;
                case 2:
                    System.out.println("This menu option may be used only after you have executed menu option 1.");
                    System.out.println("The required input text data file should have been created by using option 1 of the menu.");
                    areYouReady = promptForReadiness();
                    if ( areYouReady == 'y') {
                        displayRecordsFromAClassRecord();
                    } else {
                        System.out.println("Sorry! There no available data to be shown. ");
                    }
                    break;
                case 3:
                    System.out.println("This menu option may be used only after you have executed menu option 1.");
                    System.out.println("The required input text data file should have been created by using option 1 of the menu.");
                    areYouReady = promptForReadiness();
                    if (areYouReady == 'y') {
                        viewStudentRecordsOneByOne();
                    } else {
                        System.out.println("Sorry! There no available data to be shown. ");
                    }
                    break;
                case 4:
                    System.out.println("This menu option may be used only after you have executed menu option 1 or 4.");
                    System.out.println("The required input text data file should have been created by using option 1 or a previous use of option 4 of the menu.");
                    areYouReady = promptForReadiness();
                    if (areYouReady == 'y') {
                        classRecord = activateAnExistingClassRecord();
                        classRecord = updateAClassRecord(classRecord);
                        System.out.println("If you want to work with a different classrecord, Quit the application first. Upon running, you may use option 2,3 or 4 immediately. ");
                    } else {
                        System.out.println("Sorry! There no available data to be subjected for update. ");
                    }
                    break;
                case 5:
                    System.out.println("You have chosen to quit. The application closes after you press enter. Thank you.");
            } // end of switch case
            System.out.print("Please press enter to continue...");
            keyboard.nextLine();
        } while ( choice != 5);
    } // end of run method


// Invoke by the run method if choice is 1

    private ClassRecord makeANewClassRecord() throws FileNotFoundException{
        Scanner keyboard = new Scanner(System.in);
        ClassRecord classRecord= null;
        String checklistFilename ="";
        String filenameOfTextDataFile = "";
        int numberOfStudents=0;
        Student[] students = null;
        char response='x';


        System.out.println("The selected task needs an input text data file that contains id numbers, names, programs and year levels of students in one class");
        response = promptForReadiness();
        if (Character.toLowerCase(response) == 'y') {
            System.out.println("The class record will be created after you enter the name of the text data file containing id numbers, names, prograams and year levels.");
            System.out.print("Press carefully type the file name <example, classlist1.txt>: ");
            checklistFilename = keyboard.nextLine();
            numberOfStudents = countLinesInATextFile(checklistFilename);


            students = new Student[numberOfStudents];
            students = createStudentObjects(numberOfStudents, checklistFilename);
            filenameOfTextDataFile = writeToFile(students);
            classRecord = new ClassRecord(numberOfStudents, students, filenameOfTextDataFile );
            System.out.println("A class record has been created.");
            System.out.println("You, now, have data that may be used for menu options 2, 3 or 4 ");
        }
        else {
            System.out.println("Sorry, you need to quit the program execution. Prepare the input text data file first.");
        }
        return classRecord;


    } // ned of MakeANewClassRecord method

// Invoke by the run method if choice is 4


    private ClassRecord activateAnExistingClassRecord() throws FileNotFoundException {
        Scanner keyboard = new Scanner(System.in);
        ClassRecord classRecord = null;
        Scanner filePointer = null;

        String filenameOfTextDataFile = "";
        int numberOfStudents = 0;
        Student[] arrayOfStudents = null;

        System.out.println("Student objects will be constructed out of the comma separated values from the input text data file.");
        System.out.print("Please carefully enter the name of the text data file for an existing classrecord <ex. classrecord1.txt> : ");
        filenameOfTextDataFile = keyboard.nextLine();
        numberOfStudents = countLinesInATextFile(filenameOfTextDataFile);
        arrayOfStudents = new Student[numberOfStudents];

        String commaSeparatedLineOfStrings="";

        int lineNumber=0;
        int index=0;

        try {
            filePointer = new Scanner( new File(filenameOfTextDataFile));
            while ( filePointer.hasNextLine() ){

                lineNumber += 1;
                commaSeparatedLineOfStrings = filePointer.nextLine();
                String[] data = commaSeparatedLineOfStrings.split(",");
                String id = data[0];
                String name = data[1];
                String program = data[2];
                byte year = Byte.parseByte(data[3]);

                String[] data4 = data[4].split("/");
                int pScore = Integer.parseInt(data4[0]);
                int ppScore = Integer.parseInt(data4[1]);

                String[] data5 = data[5].split("/");
                double pExam = Double.parseDouble(data5[0]);
                double ppExam = Double.parseDouble(data5[1]);
                byte pGrade = Byte.parseByte(data[6]);

                String[] data7 = data[7].split("/");
                int mScore = Integer.parseInt(data7[0]);
                int pmScore = Integer.parseInt(data7[1]);

                String[] data8 = data[8].split("/");
                double mExam = Double.parseDouble(data8[0]);
                double pmExam = Double.parseDouble(data8[1]);
                byte mGrade = Byte.parseByte(data[9]);

                String[] data10 = data[10].split("/");
                int fScore = Integer.parseInt(data10[0]);
                int pfScore = Integer.parseInt(data10[1]);

                String[] data11 = data[11].split("/");
                double fExam = Double.parseDouble(data11[0]);
                double pfExam = Double.parseDouble(data11[1]);
                byte tFGrade = Byte.parseByte(data[12]);

                byte fGrade = Byte.parseByte(data[13]);
                boolean remark = Boolean.parseBoolean(data[14]);

                double prelimPercent = Double.parseDouble(data[15]);
                double midtermPercent = Double.parseDouble(data[16]);
                double finalsPercent = Double.parseDouble(data[17]);

                Student student = new Student(id, name, program, year, pScore, ppScore, pExam, ppExam, pGrade, mScore, pmScore, mExam, pmExam, mGrade, fScore, pfScore, fExam, pfExam, tFGrade, fGrade, remark, prelimPercent, midtermPercent, finalsPercent);
                arrayOfStudents[index]= student;
                index += 1;
            }
        } catch (Exception e2){
            System.out.println("There is a problem in the data read from line " + lineNumber + " of the data file.");
            System.out.println("Sorry, the program execution needs to terminate in order to ensure thr correctness of data involve.");
                    System.out.println("Please fixed the problem on the data file.");
            e2.printStackTrace();
        } finally {
            filePointer.close();
        }

        classRecord = new ClassRecord(numberOfStudents, arrayOfStudents, filenameOfTextDataFile);
        return classRecord;
    } // end of activateAnExistingClassRecord method


    /**
     *Returns y or n, which ever is entered through the keyboard
     * */


    private char promptForReadiness(){
        char entry='x';
        Scanner keyboard = new Scanner(System.in);
        System.out.println("The program will continue if you have the required input text data file");
        do {
            System.out.print("Have you already created the required text data file<Yes, No>? :");
            entry = readYesOrNo();
        } while (entry != 'y' && entry != 'n');
        return entry;
    } // end promptForReadiness method


    /**
     Returns the filename of a text data file where values of attributes of students in an array of Student are written in a line by
     line fashion
     */

    public String writeToFile(Student[] students) {
        Scanner keyboard = new Scanner(System.in);
        PrintWriter fileWriter = null;
        String filename="";
        System.out.println("The values of the fields for student objects that are created after reading the contents of the text data file will be written in another text data file.");
                System.out.print("Please carefully type the name of the file where the field values of students will be written<example: classrecord1.txt> :");
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

    /**
     Returns an array of student objects using the data read from an input data text file
     */


    public Student[] createStudentObjects(int numberOfStudents, String inputFilename){
        Scanner filePointer = null;
        String commaSeparatedLineOfString = "";
        Student[] students;

        int index = 0;
        System.out.println("Objects of Students are created out of the comma separated strings of number, name, program and year level that are read from an input data file");;

//Determine the size of the array of student objects ( as many as the number of lines in the input text data file
        int numberOfLines = numberOfStudents;


//Instantiate the array of Student objects
        students = new Student[numberOfLines];


// Construct the student objects and populate the array of Student objects

        try {
            filePointer = new Scanner(new File(inputFilename));
            while (filePointer.hasNextLine()){


                commaSeparatedLineOfString = filePointer.nextLine();
                String[] data = commaSeparatedLineOfString.split(",");
                String id = data[0];
                String name = data[1];
                String program = data[2];
                byte year = Byte.parseByte(data[3]);
                Student student = new Student(id, name, program, year);
                students[index] = student;
                index = index + 1;


            } // end of while
        } catch (NumberFormatException nfe){
            System.out.println(nfe.getMessage());


        } catch (FileNotFoundException tfe){
            System.out.println(tfe.getMessage());
            System.out.println("No student object was placed in the list of students ");


        } finally {

            filePointer.close();
        }
        return students;


    }// end of createStudentObjects method

// Method to be invoked by run method when choice is 4

    private ClassRecord updateAClassRecord(ClassRecord record){
        Scanner keyboard = new Scanner(System.in);
        ClassRecord modifiedClassRecord = null;
        Student[] modifiedListOfStudents = new Student[record.getNumberOfStudents()];



        modifiedListOfStudents = copyList(record.getArrayOfStudents());
        String id = "";
        String nameOfDataFileUpdated= record.getTextDataFilename();
        System.out.println("You have chosen to edit a student record. ");
        do {
            System.out.print("Please enter the ID number of the student whose record will be updated: ");
            id = keyboard.nextLine();
            if (id.length() < 1){
                System.out.println("Invalid ID Number! Please enter a valid ID Number. ");
            }
        } while (id.length() < 1);
        modifiedListOfStudents = modifyListOfStudents(modifiedListOfStudents, id);
        System.out.println("The data file of the classrecord called " + nameOfDataFileUpdated +" needs updating. ");
        System.out.println("Please give " + nameOfDataFileUpdated + " as your answer to the following prompt for a filename entry.");
        System.out.print("Press enter to continue...");
        keyboard.nextLine();
        nameOfDataFileUpdated = writeToFile(modifiedListOfStudents);
        System.out.println("Data modifications have been recorded in the data file called "+ nameOfDataFileUpdated+ ".");
        modifiedClassRecord = new ClassRecord(record.getNumberOfStudents(),modifiedListOfStudents,nameOfDataFileUpdated);
        return modifiedClassRecord;
    } // end of updateAClassrecord method

// Invoke by the run method if choice is 2

    public void displayRecordsFromAClassRecord() throws FileNotFoundException{
        Scanner keyboard = new Scanner(System.in);
        String dataFilename ="";
        ClassRecord recordToDisplay = null;
        int numberOfStudents = 0;

        System.out.println("Student objects will be constructed out of the comma separated values from the input text data file.");
        System.out.print("Please carefully enter the name of the text data file for a classrecord <ex. classrecord1.txt> : ");
        dataFilename = keyboard.nextLine();
        numberOfStudents = countLinesInATextFile(dataFilename);
        Student[] studentArray = new Student[numberOfStudents];
        studentArray = readDataFromAnExistingDataFileOfAClassrecord(dataFilename);
        recordToDisplay = new ClassRecord(numberOfStudents, studentArray, dataFilename);
        showAllStudentsInAClassrecord(recordToDisplay);

    } // end of displayRecordsFromAClassRecord method

    /**
     Displays the attribute values of each student object with descriptive labels where the students are listed
     following a lexicographic ordering based on their names


     1. Get the array of students from the class record and assign it to arrayOfStuds
     2. Use the sortArrayOfStudents method to sort the array
     3. For each student in the array, print the string showing a comma-separated values of the attributes of the student
     */
    private void showAllStudentsInAClassrecord(ClassRecord record) {
        Scanner keyboard = new Scanner(System.in);
        Student[] arrayOfStuds = record.getArrayOfStudents();
        sortArrayOfStudents(arrayOfStuds);
        for (int index = 0; index < arrayOfStuds.length; index++) {
            System.out.println(arrayOfStuds[index].toString());
        } // end of for
    } // end of showAllStudentsInTheClassRecord method


// Invoke by the run method if choice is 3

    public void viewStudentRecordsOneByOne() throws FileNotFoundException{
        Scanner keyboard = new Scanner(System.in);
        String dataFilename ="";
        ClassRecord recordToDisplay = null;
        int numberOfStudents = 0;
        System.out.println("Student objects will be constructed out of the comma separated values from the input text data file.");
        System.out.print("Please carefully enter the name of the text data file for a classrecord <ex. classrecord1.txt> : ");
        dataFilename = keyboard.nextLine();
        numberOfStudents = countLinesInATextFile(dataFilename);
        Student[] studentArray = new Student[numberOfStudents];
        studentArray = readDataFromAnExistingDataFileOfAClassrecord(dataFilename);
        recordToDisplay = new ClassRecord(numberOfStudents, studentArray, dataFilename);
        showStudentOneAtATime(recordToDisplay);

    } // end of displayRecordsFromAClassRecord method


    /**
     Displays the attribute values of each student object with descriptive labels


     1. Get the array of students from the class record and assign the array to arrayOfStuds
     2. For each student in the arrayOfStuds
     2.1. Show the id number of the student
     2.2. Show name of the student
     2.3. Show the program of the student
     2.4. Show the student's total raw score for the prelim requirements
     2.5. Show the student's prelim examination score
     2.6. Show the student's total raw score for the midterm requirements
     2.7. Show the student's midterm examination score
     2.8. Show the student's total raw score for the finals period
     2.9. Show the student's final examination score
     2.10. Show the student's Prelim Grade
     2.11. Show the student's Midterm Grade
     2.12. Show the student's Tentative Final Grade
     2.13. Show the student's Final Grade
     **/
    private void showStudentOneAtATime(ClassRecord record){
        Scanner keyboard = new Scanner(System.in);
        Student[] arrayOfStuds = record.getArrayOfStudents();
        for (int index=0; index < arrayOfStuds.length; index++){

            System.out.println("\n------------------------------------------------------------------------");
            System.out.printf("%-25s%-40s%n","ID Number : ", arrayOfStuds[index].getIdNo());
            System.out.printf("%-25s%-40s%n","Name of Student : ", arrayOfStuds[index].getName());
            System.out.printf("%-25s%-40s%n","Program : ", arrayOfStuds[index].getProgram());
            System.out.printf("%-25s%-40d%n","Year Level : ", arrayOfStuds[index].getYear());
            System.out.println("\nPeriodic total scores for all requirements");
            System.out.printf("%-10s%-6d%-10s%-6d%-10s%-6d%n","Prelims : ",arrayOfStuds[index].getPrelimRawScore(), "Midterms : ",arrayOfStuds[index].getMidtermRawScore(),"Finals : ",arrayOfStuds[index].getFinalRawScore());
            System.out.println("\nPeriodic Examination Scores");
            System.out.printf("%-10s%-6.0f%-10s%-6.0f%-10s%-6.0f%n","Prelims : ",arrayOfStuds[index].getPrelimExamScore(),"Midterms: ",arrayOfStuds[index].getMidtermExamScore(),"Finals: ",arrayOfStuds[index].getFinalExamScore());
            System.out.println("\nPeriodic Grades");
            System.out.printf("%-10s%-6d%-10s%-6d%-10s%-6d%n","Prelims : ",arrayOfStuds[index].getPrelimGrade(),"Midterms: ",arrayOfStuds[index].getMidtermGrade(),"Finals: ",arrayOfStuds[index].getTentativeFinalGrade());
            System.out.printf("%n%-15s%-5d%15s","FINAL GRADE : ",arrayOfStuds[index].getFinalGrade(),"Remarks : ");
            if (arrayOfStuds[index].getPassedFlag())
                System.out.println("PASSED");
            else
                System.out.println("FAILED");

            System.out.println("\n=================================================================================== ");

            if (index < (arrayOfStuds.length -1)) {
                System.out.println("Press enter to see next student record. ");
                keyboard.nextLine();


            } else
                System.out.println("End of list has been reached!");
        } // end of for


    } // end of showStudentsOneAtATime method

    /**
     Display a menu for the application
     */


    private void showMenu() {
        System.out.println("APPLICATION for CLASSRECORD keeping");
        System.out.println("<1> Construct an initial class record based on a given checklist "); // the attributes of each studentobject will be taken from a text data file");
        System.out.println("<2> Show a list of all students included in a class record where attributes are in comma separated strings");
        System.out.println("<3> Show data for students included in a class record one at a time");
        System.out.println("<4> Update an editable field of a student object in an existing class record");
        System.out.println("<5> Quit");

    } // end of showMenu method

    /**
     *Returns number from minimum to maximum that represents a choice from the given options in the menu that is enterd
     by the user
     **/
    private byte readChoice(byte minimum, byte maximum){
        byte choice=0;

        while (choice < minimum || choice > maximum){
            System.out.print("Enter a number corresponding to your choice: " );
            choice = readByte();
            if (choice < minimum || choice > maximum){
                System.out.println("The choice must be a number from " + minimum + " to " + maximum + ".");
            }
        }
        return choice;


    } // end of readChoice method

    /**
     Returns a valid byte read from the keyboard
     **/

    public byte readByte(){
        byte value= (byte) 0;
        Scanner keyboard = new Scanner(System.in);
        boolean noProblem = true;
        do {
            try {
                value = Byte.parseByte(keyboard.nextLine());
                noProblem = true;

            } catch (NumberFormatException ex){
                System.out.print("You entered an invalid number. Please enter a small number: ");
                noProblem = false;
            }
        } while (!noProblem);
        return value;


    } // end of readByte method

    /**
     Returns a valid integer read from the keyboard
     **/

    public int readInteger(){
        int value=0;
        Scanner keyboard = new Scanner(System.in);
        boolean noProblem = true;
        do {
            try {
                value = Integer.parseInt(keyboard.nextLine());
                noProblem = true;
            } catch (NumberFormatException ex){
                System.out.print("You entered an invalid number. Please enter an integer: ");
                noProblem = false;
            }
        } while (!noProblem);
        return value;


    } // end of readInteger method

    /**
     Returns a valid double read from the keyboard
     **/

    public double readDouble(){
        double value=0;
        Scanner keyboard = new Scanner(System.in);
        boolean noProblem = true;
        do {
            try {
                value = Double.parseDouble(keyboard.nextLine());
                noProblem = true;
            } catch (NumberFormatException ex){
                System.out.print("You entered an invalid number. Please enter an integer: ");
                noProblem = false;
            }
        } while (!noProblem);
        return value;


    } // end of readDouble method

    /**
     *Returns the number of lines found in a text file
     */

    public int countLinesInATextFile(String filename) throws FileNotFoundException{
        int count =0;
        Scanner filePointer = new Scanner(new File(filename));
        while (filePointer.hasNextLine()) {
            String lineOfString = filePointer.nextLine();
            count += 1;
        } // end of while
        filePointer.close();
        return count;


    } // end of countLinesInATextFile method

    /**
     *Applies the selection sort algorithm to arrange the elements of an array of student objects
     *where the sort key is the name attribute.
     Input: an unsorted array of student objects
     Output: a sorted version of the array of student objects based on lexicographic ordering of the
     values of the name field.

     1. Declare temp as a variable of type Student and initialize it to null
     2. Declare a variable of type int, say minIndex, to be used to store the index of the
     cell of the unsorted portion of the array that contains the element that should be
     moved to the first cell of the unsorted part thereby making the element a part of the sorted part.
     3. For indexOfCellToFix from index 0 to index array.length-2
     3.1. Let minIndex = indexOfCellToFix (assume that the cell at current indexOfCellToFix has
     the element that must be placed at indexOfCellToFix)
     3.2. Select the element to be moved from cell at searchIndex from cell indexOfCellToFix+1 to index array.length-1,
     if (name value of student at minIndex is lexicographically after name value of student at searchIndex,
     replace minIndex by searchIndex
     3.3. if minIndex has changed (minIndex is not indexOfCellToFix as initially assumed),
     swap the elements at minIndex and indexOfCellToFix
     **/
    public void sortArrayOfStudents(Student[] s){
        Student temp=null;
        int minIndex=0;
        for (int indexOfCellToFix=0; indexOfCellToFix < s.length-1; indexOfCellToFix++){

            minIndex= indexOfCellToFix;
            for (int searchIndex = indexOfCellToFix+1; searchIndex<s.length; searchIndex++){
                if (s[minIndex].getName().compareToIgnoreCase(s[searchIndex].getName())>0)
                    minIndex= searchIndex;
            }
            if (minIndex != indexOfCellToFix) {
                temp = s[indexOfCellToFix];
                s[indexOfCellToFix] = s[minIndex];
                s[minIndex] = temp;
            }
        }
    } // end of sortListOfStudents method

    /**
     *Returns an Array of Student that is populated with student objects
     *where the student objects are constructed out of data read from
     *a text data file that contains id numbers, names, programs, year level, prelim raw score,

     * prelim exam score, prelim grade, midterm raw score, midterm exam score, midterm grade,
     * final raw score, final exam score, tentative final grade, final grade and remark
     *in a line by line fashion; an empty array is returned if reading data causes a problem.
     */
    public Student[] readDataFromAnExistingDataFileOfAClassrecord(String filename) throws FileNotFoundException {
        Scanner filePointer = null;
        Student[] arrayOfStudents = new Student[countLinesInATextFile(filename)];
        String commaSeparatedLineOfStrings="";
        int lineNumber=0;
        int index=0;
        try {

            filePointer = new Scanner( new File(filename));

            while ( filePointer.hasNextLine() ){
                lineNumber += 1;
                commaSeparatedLineOfStrings = filePointer.nextLine();
                String[] data = commaSeparatedLineOfStrings.split(",");
                String id = data[0];
                String name = data[1];
                String program = data[2];
                byte year = Byte.parseByte(data[3]);

                String[] data4 = data[4].split("/");
                int pScore = Integer.parseInt(data4[0]);
                int ppScore = Integer.parseInt(data4[1]);

                String[] data5 = data[5].split("/");
                double pExam = Double.parseDouble(data5[0]);
                double ppExam = Double.parseDouble(data5[1]);
                byte pGrade = Byte.parseByte(data[6]);

                String[] data7 = data[7].split("/");
                int mScore = Integer.parseInt(data7[0]);
                int pmScore = Integer.parseInt(data7[1]);

                String[] data8 = data[8].split("/");
                double mExam = Double.parseDouble(data8[0]);
                double pmExam = Double.parseDouble(data8[1]);
                byte mGrade = Byte.parseByte(data[9]);

                String[] data10 = data[10].split("/");
                int fScore = Integer.parseInt(data10[0]);
                int pfScore = Integer.parseInt(data10[1]);

                String[] data11 = data[11].split("/");
                double fExam = Double.parseDouble(data11[0]);
                double pfExam = Double.parseDouble(data11[1]);
                byte tFGrade = Byte.parseByte(data[12]);

                byte fGrade = Byte.parseByte(data[13]);
                boolean remark = Boolean.parseBoolean(data[14]);

                double prelimPercent = Double.parseDouble(data[15]);
                double midtermPercent = Double.parseDouble(data[16]);
                double finalsPercent = Double.parseDouble(data[17]);

                Student student = new Student(id, name, program, year, pScore, ppScore, pExam, ppExam, pGrade, mScore, pmScore, mExam, pmExam, mGrade, fScore, pfScore, fExam, pfExam, tFGrade, fGrade, remark, prelimPercent, midtermPercent, finalsPercent);
                arrayOfStudents[index]= student;
                index += 1;
            }
        } catch (Exception e2){
            System.out.println("There is a problem in the data read from line " + lineNumber + " of the data file.");
            System.out.println("The program execution needed to terminate.");
            System.out.println("Please fixed the problem on the data file.");
            e2.printStackTrace();
        } finally {
            filePointer.close();
        }
        return arrayOfStudents;


    } // end of readDataFromAnExistingDataFileOfAClassrecord method

    /**
     *Returns the index of a cell of a given array of Students that contains a student with an ID number that


     * is equal to a given search key; Returns -1 if a student with an ID number that is the same as the search key is not found.
     *
     * Inputs: Array of Student objects, search key
     * Output: index of cell containing the student with an ID number that is equal to the search key, -1 if no student has an ID
     number that is the same as search key
     *

     * Algorithm. (Linear Search)
     * 1. Receive an array of student(list) and an id number to be searched(searchKey)
     * 2. Let result be an int with -1 as initial value
     * 3. Let found be false
     * 4. Let index=0
     * 5. While index is less than the size of the list and found == false
     * if id number for list[index] is equal to search key
     * let result = index
     * let found = true
     * 6. return result
     */
    public int searchListOfStudents(Student[] list, String searchKey){
        int result = -1;
        boolean found = false;
        for (int index=0; index < list.length && !found; index++){
            if (list[index].getIdNo().equalsIgnoreCase(searchKey)){
                result = index;
                found = true;
            }
        }
        return result;


    } // end of searchListOfStudents method

    /**
     Returns an array of Student that is the result of modifying at least one attribute of a student with a specified
     id number in a given list; Returns the original array if there is no modification made on a student
     Inputs: Array of student(original), id number of student whose fields will be modified
     Output: Array of students(modified)


     Algorithm.

     1. Receive an array of students and an id number
     2. Let studentArray be a copy of the given array of students
     3. If a student with the specified id number is in studentArray
     Modify the data for the student with the specified id number
     4. Return studentArray
     */
    public Student[] modifyListOfStudents(Student[] list, String id){
        boolean found = false;
        Student[] studentArray = new Student[list.length];
        studentArray = copyList(list);

        int indexModified = searchListOfStudents(studentArray, id);
        if (indexModified > -1) {
            studentArray[indexModified] = encodeGradeDataOfStudent(studentArray[indexModified]);
        }
        else {
            System.out.println("A student with ID Number "+ id + " is not in the list.");
            System.out.println("No modification is done.");
        }


        return studentArray;
    } // end of modifyListOfStudents method


    /**

     *Returns a student with new scoress and grade data for a given student as directed by user

     */

    public Student encodeGradeDataOfStudent(Student s){
        Scanner keyboard = new Scanner(System.in);
        Student modifiedStudent=null;
        String iNumber = s.getIdNo();
        String n = s.getName();
        String p = s.getProgram();
        byte y = s.getYear();
        int pRS = s.getPrelimRawScore();
        int pPRS = s.getPerfectPrelimRawScore();
        double pES = s.getPrelimExamScore();
        double pPES = s.getPerfectPrelimExamScore();
        byte pG = s.getPrelimGrade();
        int mRS = s.getMidtermRawScore();
        int pMRS = s.getPerfectMidtermRawScore();
        double mES = s.getMidtermExamScore();
        double pMES = s.getPerfectMidtermExamScore();
        byte mG = s.getMidtermGrade();
        int fRS = s.getFinalRawScore();
        int pFRS = s.getPerfectFinalRawScore();
        double fES = s.getFinalExamScore();
        double pFES = s.getPerfectFinalExamScore();
        byte tFG = s.getTentativeFinalGrade();
        byte fG = s.getFinalGrade();
        double pp = s.getPrelimPercent();
        double mp = s.getMidtermPercent();
        double fp = s.getFinalsPercent();



        System.out.print("You want to modify at least one score associated with the student with the id number = " + iNumber +" , ");
        System.out.println("Name = "+ n + ", Program = "+ p + ", Year Level = " + y +".");
        System.out.print("Press enter to continue...");
        keyboard.nextLine();

        pPRS = modifyPerfectRawScore(pPRS, "prelim PERFECT raw score");
        pPES = modifyPerfectExamScore(pPES, "prelim PERFECT exam score");
        pMRS = modifyPerfectRawScore(pMRS, "midterm PERFECT raw score");
        pMES = modifyPerfectExamScore(pMES, "midterm PERFECT exam score");
        pFRS = modifyPerfectRawScore(pFRS, "finals PERFECT raw score");
        pFES = modifyPerfectExamScore(pFES, "finals PERFECT exam score");
        pp = modifyPrelimPercent(pp, "prelim %");
        mp = modifyMidtermPercent(mp, "midterm %");
        fp = modifyFinalsPercent(fp,"finals %");


        pRS = modifyRawScore(pRS, "prelim raw score");
        pES = modifyExamScore(pES, "prelim exam score");
        mRS = modifyRawScore(mRS, "midterm raw score");
        mES = modifyExamScore(mES, "midterm exam score");
        fRS = modifyRawScore(fRS, "final raw score");
        fES = modifyExamScore(fES, "final exam score");


        System.out.println("The current final grade that is "+ fG + " will automatically be adjusted.");
        modifiedStudent = new Student(iNumber,n,p,y, pRS,pPRS, pES,pPES, mRS,pMRS, mES,pMES, fRS,pFRS, fES,pFES,pp,mp,fp);
        return modifiedStudent;
    } // end of encodeGradeDataOfAStudent method

private double modifyPrelimPercent(double oldPercent, String description){
    char editFlag = 'x';
    double newPercent = oldPercent;
    System.out.print("The current value of "+ description + " is "+ oldPercent+".\n" + "Do you want to change the current "
            +description+ "<Yes, No >? ");
    editFlag = readYesOrNo();
    if (editFlag == 'y'){
        System.out.print("Please enter the new " + description + ": ");
        newPercent = readInteger();
        System.out.println("The corresponding grade will be adjusted automatically.");
    }
    return newPercent;
}
private double modifyMidtermPercent(double oldPercent, String description){
    char editFlag = 'x';
    double newPercent = oldPercent;
    System.out.print("The current value of "+ description + " is "+ oldPercent+".\n" + "Do you want to change the current "
            +description+ "<Yes, No >? ");
    editFlag = readYesOrNo();
    if (editFlag == 'y'){
        System.out.print("Please enter the new " + description + ": ");
        newPercent = readInteger();
        System.out.println("The corresponding grade will be adjusted automatically.");
    }
    return newPercent;
}
private double modifyFinalsPercent(double oldPercent, String description){
    char editFlag = 'x';
    double newPercent = oldPercent;
    System.out.print("The current value of "+ description + " is "+ oldPercent+".\n" + "Do you want to change the current "
            +description+ "<Yes, No >? ");
    editFlag = readYesOrNo();
    if (editFlag == 'y'){
        System.out.print("Please enter the new " + description + ": ");
        newPercent = readInteger();
        System.out.println("The corresponding grade will be adjusted automatically.");
    }
    return newPercent;
}
    /**

     Returns an int value that replaced a given old score.

     */

    private int modifyRawScore(int oldScore, String description){
        char editFlag = 'x';
        int newScore = oldScore;
        System.out.print("The current value of "+ description + " is "+ oldScore+".\n" + "Do you want to change the current "
                +description+ "<Yes, No >? ");
        editFlag = readYesOrNo();
        if (editFlag == 'y'){
            System.out.print("Please enter the new " + description + ": ");
            newScore = readInteger();
            System.out.println("The corresponding grade will be adjusted automatically.");
        }
        return newScore;
    } // end of modifyRawScore method

    private int modifyPerfectRawScore(int oldScore, String description){
        char editFlag = 'x';
        int newScore = oldScore;
        System.out.print("The current value of "+ description + " is "+ oldScore+".\n" + "Do you want to change the current "
                +description+ "<Yes, No >? ");
        editFlag = readYesOrNo();
        if (editFlag == 'y'){
            System.out.print("Please enter the new " + description + ": ");
            newScore = readInteger();
            System.out.println("The corresponding grade will be adjusted automatically.");
        }
        return newScore;
    } // end of modifyRawScore method

    /**

     Returns a double value that replaced the value of a given old score.

     */

    private double modifyPerfectExamScore(double oldScore, String description){
        char editFlag = 'x';
        double newScore = oldScore;
        System.out.print("The current value of "+ description + " is "+ oldScore+".\n" + "Do you want to change the current "
                +description+ "<Yes, No>? ");
        editFlag = readYesOrNo();

        if (editFlag == 'y'){
            System.out.print("Please enter the new " + description + ": ");
            newScore = readDouble();
            System.out.println("The corresponding grade will be adjusted automatically.");
        }
        return newScore;
    } // end of modifyExamScore method

    private double modifyExamScore(double oldScore, String description){
        char editFlag = 'x';
        double newScore = oldScore;
        System.out.print("The current value of "+ description + " is "+ oldScore+".\n" + "Do you want to change the current "
                +description+ "<Yes, No>? ");
        editFlag = readYesOrNo();

        if (editFlag == 'y'){
            System.out.print("Please enter the new " + description + ": ");
            newScore = readDouble();
            System.out.println("The corresponding grade will be adjusted automatically.");
        }
        return newScore;
    } // end of modifyExamScore method


    /**
     Returns y or n after accepting yes or no from the keyboard
     */


    private char readYesOrNo(){
        Scanner keyboard = new Scanner(System.in);
        char result = 'x';
        String response = "";
        while (Character.toLowerCase(result) != 'y' && Character.toLowerCase(result) != 'n'){
            response = keyboard.nextLine();
            if (!response.equalsIgnoreCase("yes") && ! response.equalsIgnoreCase("no"))
                System.out.print("You have to type yes or no. : ");
            else
                result = response.charAt(0);
        }
        return result;


    } // end of readYesOrNo method

    /**
     *Returns a copy of a given array of Students
     */


    public Student[] copyList(Student[] list){
        Student[] copiedList = new Student[list.length];
        for (int y=0; y < copiedList.length; y++){
            Student copy = new Student(list[y].getIdNo(),list[y].getName(),list[y].getProgram(),list[y].getYear(),list[y].getPrelimRawScore(),list[y].getPerfectPrelimRawScore(),list[y].getPrelimExamScore(),list[y].getPerfectPrelimExamScore(), list[y].getPrelimGrade(),list[y].getMidtermRawScore(),list[y].getPerfectMidtermRawScore(),list[y].getMidtermExamScore(),list[y].getPerfectMidtermExamScore(),list[y].getMidtermGrade(),list[y].getFinalRawScore(),list[y].getPerfectFinalRawScore(),list[y].getFinalExamScore(),list[y].getPerfectFinalExamScore(),list[y].getTentativeFinalGrade(),list[y].getFinalGrade(),list[y].getPassedFlag(),list[y].getPrelimPercent(),list[y].getMidtermPercent(),list[y].getFinalsPercent());
            copiedList[y] = copy;
        }
        return copiedList;


    } // end of copyList method
} // end of ClassRecordBuilder class

