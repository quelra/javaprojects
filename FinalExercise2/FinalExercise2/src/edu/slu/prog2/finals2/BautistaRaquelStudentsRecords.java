package edu.slu.prog2.finals2;

/*
 * Name: BAUTISTA, Raquel S.
 * Date: May 14, 2020
 * 9378A CS 122
 * 9378B CS 122L
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import java.util.stream.Collectors;

/**
 * This class reads a student data file, converts it to a Student object and processes it to useful information.
 * The processed information are discussed in the methods.
 */
public class BautistaRaquelStudentsRecords {
    public static void main(String[] args) {
        BautistaRaquelStudentsRecords myProgram;
        try {
            myProgram = new BautistaRaquelStudentsRecords();
            myProgram.run();
        } catch (Exception x) {
            x.printStackTrace();
        }
        System.exit(0);
    }

    /**
     * The method that is executed by the main method.
     * The method does sequentially the following:
     * 1. Initiate list of students from data file by invoking the method readDataFileIntoList().
     * 2. Invoke the method that shows the students aged under 20 sorted by average in descending order.
     * 3. Call the method showPopulationPerProgram that shows the lists of program together with its numbers of students.
     * 4. Show the the total number of students.
     * 5. Show the list of students per program and grouped according to their year level.
     * 6. Show the list of top 10 students with the highest general weighted average per year level.
     * 7. Show the alphabetical list of students who passed in each program.
     * 8. Show number of students with passing GWA.
     * 9. Show the alphabetical list of studetns who failed in each program.
     * 10. Show number of students with failing GWA.
     */
    public void run() throws Exception {
        System.out.println();
        List<Student> students = readDataFileIntoList("data02.csv");
        showStudentsLessThan20YearsOldSortedByGeneralWeightedAverageInDescendingOrder(students);
        showPopulationPerProgram(students);
        showTotalNumberOfStudents(students);
        showStudentListPerProgramSubdividedByYearLevel(students);
        showTop10HighestGWAPerYearLevel(students);
        showStudentsWithFailingOrPassedGeneralWeightedAverageInAlphabeticalOrderForEachProgramBasedOnTheGivenParameter(students,true); //students with passing average
        showTotalNumberOfStudentsWhoHaveAPassingOrFailingGWABasedOnParameter(students,true);
        showStudentsWithFailingOrPassedGeneralWeightedAverageInAlphabeticalOrderForEachProgramBasedOnTheGivenParameter(students,false); //students with failing average
        showTotalNumberOfStudentsWhoHaveAPassingOrFailingGWABasedOnParameter(students,false);
    }

    /**
     * The method for reading the student data file from a given fileName, creation of Student object and list.
     * Algorithm:
     * 1. Instantiate List
     * 2. Read file
     * 3. While there is a line to be read
     *      split based on comma
     *      remove quotation marks from lastName and firstName using substring
     *      extract from data[3] to create String program
     *      extract from data[3] to create int year
     *      Assign each data to create an object of Student.
     *      Add object to List
     * 4. Close file
     * 5. Return the List.
     */
    private List<Student> readDataFileIntoList(String fileName) {
        try {
            List<Student> students = new ArrayList<>();
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            while (true) {
                String line = reader.readLine();
                if (line == null) {
                    break;
                }
                String[] data = line.split(",");
                String lastName = data[1].substring(1);
                String firstName = data[2].substring(1, data[2].length() - 2);
                String program = data[3].substring(0, data[3].length() - 3);
                int year = Integer.parseInt(data[3].substring(data[3].length() - 1));
                Student stud = new Student(Integer.parseInt(data[0]), lastName, firstName, program,
                        year, data[4].charAt(0), Integer.parseInt(data[5]), Double.parseDouble(data[6]));
                students.add(stud);
            }
            reader.close();
            return students;
        } catch (Exception e) {
            throw new RuntimeException("Data file read error.");
        }
    }

    /**
     * The method that shows the lists students ages below 20 sorted by average in descending order.
     * 1. Create Comparator based on the generalWeightedAverage to be used in sorting
     *      if student1 has higher GWA than student2
     *          return -1
     *      else if student2 has higher GWA than student2
     *          return 1
     *      else
     *          return 0
     * 2. Use stream operations on students
     * 3. Filter the students by their ages and must be below 20
     * 4. Sort students using the created Comparator
     * 5. Print each student
     */
    private void showStudentsLessThan20YearsOldSortedByGeneralWeightedAverageInDescendingOrder(List<Student> students) {
        System.out.println("Students with ages less than 20 (GWA in descending order): \n");
        Comparator<Student> comparator = (s1, s2) -> {
            if (s1.getGeneralWeightedAverage() > s2.getGeneralWeightedAverage()) {
                return -1;
            } else if (s1.getGeneralWeightedAverage() < s2.getGeneralWeightedAverage()) {
                return 1;
            } else {
                return 0;
            }
        };
        students
                .stream()
                .filter(s -> s.getAge() < 20)
                .sorted(comparator)
                .forEach(System.out::println);
        lineDivider();
    }

    /**
     * Method that shows the lists of programs and its respective student population.
     * 1. Initiate Map and assign a grouped list of students according to program.
     * 2. Create Set "programs" and assign Map progInfo with a Set view of the keys.
     * 3. for each program
     *      Create list of stud based on the program
     *      get the size of students in the program and assign to total
     *      print name of program with the total
     */
    private void showPopulationPerProgram(List<Student> students) {
        System.out.println("List of programs and corresponding number of students: \n");
        Map<String, List<Student>> progInfo = students
                .stream()
                .collect(Collectors.groupingBy(Student::getProgram));
        Set<String> programs = progInfo.keySet();
        for (String prog : programs) {
            List<Student> stud = progInfo.get(prog);
            int total = stud.size();
            System.out.printf("%s: %d%n", prog, total);
        }
       lineDivider();
    }

    /**
     *The method that shows a list of students in each program and divided according to their year level.
     * 1. Create Map for all students.
     * 2. For each student,
     *      get program
     *      get year
     *      Create list of program
     *      Create list of student's year list
     *      Add student in the list
     * 3. Create set of programs of students
     * 4. For each program
     *      print program
     *      create student year list of students per program
     *      create set yr
     *      For each year
     *           print year
     *           create set of student year list
     *           For each student
     *                 print student
     */
    private void showStudentListPerProgramSubdividedByYearLevel(List<Student> students) {
        System.out.println("List of students per program subdivided by year level\n");
        Map<String, Map<Integer, Set<Student>>> allStudents = new TreeMap<>();
        for (Student s : students) {
            String prog = s.getProgram();
            int yr = s.getYear();
            Map<Integer, Set<Student>> progList = allStudents.computeIfAbsent(prog, k -> new TreeMap<>());
            Set<Student> studentYearList = progList.computeIfAbsent(yr, k -> new TreeSet<>());
            studentYearList.add(s);
        }
        Set<String> programs = allStudents.keySet();
        for (String prog : programs) {
            System.out.printf("%s%n", prog);
            Map<Integer, Set<Student>> studentYearList = allStudents.get(prog);
            Set<Integer> yr = studentYearList.keySet();
            for (int year : yr) {
                System.out.printf("\t%6s\t%s%n", "Year", year);
                Set<Student> studYrList = studentYearList.get(year);
                for (Student s : studYrList) {
                    System.out.println("\t\t" + s.toString());
                }
            }
        }
        lineDivider();
    }

    /**
     * The method that lists the top 10 students who has the highest general weighted average divided according to year level.
     * 1. print info
     * 2. create Comparator for student's general weighted average
     *      if gWA of student1 is > student2
     *          return -1
     *      else if gWA of student1 is < student2
     *          return 1
     *      else
     *          return 0
     * 3. initialize Map for department information that groups the students according to year
     * 4. initialize Set yr
     * 5. for each year
     *      initialize list of students per year
     *      print year
     *      sort students according to grade
     *      limit number of students to 10
     *      print the top 10 students
     */
    private void showTop10HighestGWAPerYearLevel(List<Student> students) {
        System.out.println("Top 10 students with highest general weighted average per year level (descending order)\n");
        Comparator<Student> comparator = (s1, s2) -> {
            if (s1.getGeneralWeightedAverage() > s2.getGeneralWeightedAverage()) {
                return -1;
            } else if (s1.getGeneralWeightedAverage() < s2.getGeneralWeightedAverage()) {
                return 1;
            } else {
                return 0;
            }
        };
        Map<Integer, List<Student>> deptInfo = students.stream().collect(Collectors.groupingBy(Student::getYear));
        Set<Integer> yr = deptInfo.keySet();
        for (int year : yr) {
            List<Student> stud = deptInfo.get(year);
            System.out.printf("%-6s%-2d%n%n" , "Year" ,year);
            stud
                    .stream()
                    .sorted(comparator)
                    .limit(10)
                    .forEach(System.out::println);
            System.out.println();
        }
        lineDivider();
    }

    /**
     * This method shows the overall population of students from a list.
     */
    private void showTotalNumberOfStudents(List<Student> students){
        System.out.println("Total number of students: " + students.size());
        lineDivider();
    }

    /**
     * The method that shows the total number of students who have passing or failing general weighted average based on the given parameter.
     * @param students - list of students
     * @param passed - if true, the method will show the list who have passing GWA. Else, it will show the list of failing GWA.
     * 1. assign filtered number of students to count
     *      filter students
     *               if passed
     *                  filter those with 75 and above GWA
     *               else
     *                  filter those with < 75 GWA
     *      count
     * 2. print count
     */
    private void showTotalNumberOfStudentsWhoHaveAPassingOrFailingGWABasedOnParameter(List<Student> students, Boolean passed){
        long count = students
                .stream()
                .filter(passed? student -> student.getGeneralWeightedAverage() >= 75 : student -> student.getGeneralWeightedAverage() < 75)
                .count();
        System.out.println(passed? "Total number of students who have passing general weighted average: " + count:
                "Total number of students who have failing general weighted average" + count);

    }

    /**
     * The method that shows a lists of students per program who have failing/passing general weighted averages arranged alphabetically.
     * The failing or passing is determined by the parameter.
     * If the parameter Boolean passed is true, then the method will show the list of passed students per program arranged alphabetically
     * Otherwise if false.
     * 1.print info depending on the given boolean value
     * 2.initialize comparator for last names
     * 3.initialize Map of students grouped by program
     * 4.initialize Set of programs from Map
     * 5.for each program
     *      initialize List of students per program
     *      print program
     *      filter students
     *          if passed
     *              filter those who have general weighted average below 75
     *          else
     *              filter according to those who have general weighted average of 75 and above
     *      sort students based on last name
     *      print student
     */
    private void showStudentsWithFailingOrPassedGeneralWeightedAverageInAlphabeticalOrderForEachProgramBasedOnTheGivenParameter(List<Student> students, Boolean passed){
        System.out.println(passed? "Alphabetical list of students with passing general weighted average \n" : "Alphabetic list of students with failing general weighted average \n" );
        Comparator<Student> comparator = Comparator.comparing(Student::getLastName);
        Map<String, List<Student>> deptInfo = students.stream().collect(Collectors.groupingBy(Student::getProgram));
        Set<String> prog = deptInfo.keySet();
        for (String program : prog) {
            List<Student> stud = deptInfo.get(program);
            System.out.printf("%-10s%-10s%n%n" , "Program" ,program);
            stud
                    .stream()
                    .filter(passed? s -> s.getGeneralWeightedAverage() >= 75: s-> s.getGeneralWeightedAverage() < 75)
                    .sorted(comparator)
                    .forEach(System.out::println);
            System.out.println();
        }
        lineDivider();
    }

    /**
     * A simple method that prints a line for display.
     */
    private void lineDivider(){
        System.out.println("=============================================================================================================================");
        System.out.println("=============================================================================================================================\n");
    }


}//end of BautistaRaquelStudentsRecords class
