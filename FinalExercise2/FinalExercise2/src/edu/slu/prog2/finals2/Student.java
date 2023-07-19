package edu.slu.prog2.finals2;

public class Student implements Comparable<Student> {
    private int id;
    private String lastName;
    private String firstName;
    private String program;
    private int year;
    private char gender;
    private int age;
    private double generalWeightedAverage;

    public Student(int id, String lName, String fName, String course, int yr, char gender, int age, double avg){
        this.id = id;
        lastName = lName;
        firstName = fName;
        program = course;
        year = yr;
        this.gender = gender;
        this.age = age;
        generalWeightedAverage = avg;
    }

    @Override
    public int compareTo(Student another) { //based on id
        if (this.getId() > another.getId())
            return 1;
        else if (this.getId() < another.getId())
            return -1;
        else
            return 0;
    }

    @Override
    public String toString(){
        return String.format("%-10s\t%-15s\t%-25s\t%-15s\t%-4d\t%-4c\t%-4d\t%-5.2f",
                id,lastName,firstName,program,year,gender,age,generalWeightedAverage);
    }



    public int getId(){
        return id;
    }

    public String getLastName(){
        return lastName;
    }

    public String getFirstName(){
        return firstName;
    }

    public String getProgram(){
        return program;
    }

    public int getYear(){
        return year;
    }

    public char getGender(){
        return gender;
    }

    public int getAge(){
        return age;
    }

    public double getGeneralWeightedAverage(){
        return generalWeightedAverage;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public void setProgram(String course){
        program = course;
    }

    public  void setYear(int yr){
        year = yr;
    }

    public void setGender(char gender){
        this.gender = gender;
    }

    public void setAge(int age){
        this.age = age;
    }

    public void setGeneralWeightedAverage(double average){
        generalWeightedAverage = average;
    }


}
