/**
 *Reference class:
 *Template for a course
 **/
public class SampleCourse implements Comparable<SampleCourse>{
    private String number;  // course number attribute
    private String title; // descriptive title attribute
    private float units; // credit units attribute
    private byte yearLevel; // year level attribute: 1= first year, 2= second year, ...
    private byte term; //term attribute: 1= first sem, 2=second sem, 3=summer
    private int grade; // grade earned attribute

    /**
     *Default Constructor
     *Constructs a course with the empty string as the course number,
     *empty string as the course title, 0 as the units, 0 as the year level,
     *0 as the term, 0 as the grade
     **/
    public SampleCourse(){
        number="";
        title="";
        units= 0;
        yearLevel=(byte) 0;
        term=(byte) 0;
        grade=0;
    }

    /**
     *Constructor with parameters
     *Constructs a course with a given string c as the course number,
     *given string t as the course title, given u as the units,
     *given y as the year level, given e as the term,
     *given g as the grade
     **/
    public SampleCourse(String c, String t, float u, int y, int e, int g){
        number=c;
        title=t;
        units=u;
        yearLevel=(byte) y;
        term=(byte) e;
        grade=g;
    }


    /**
     *Sets given string n as the value of the number field
     **/
    public void setNumber(String n){
        number = n;
    }

    /**
     *Sets given string t as the value of the title field
     **/
    public void setTitle(String t){
        title = t;
    }

    /**
     *Sets given integer u as the value of the units field
     **/
    public void setUnits(float u){
        units = u;
    }

    /**
     *Sets given integer y as the value of the yearLevel field
     **/
    public void setYearLevel(byte y){
        yearLevel = y;
    }

    /**
     *Sets given integer t as the value of the term field
     **/
    public void setTerm(byte t){
        term =t;
    }

    /**
     *Sets given float g as the value of the grade field
     **/
    public void setGrade(int g){
        grade = g;
    }


    /**
     *Returns the value of the number field
     **/
    public String getNumber(){
        return number;
    }

    /**
     *Returns the value of the title field
     **/
    public String getTitle(){
        return title;
    }

    /**
     *Returns the value of the units field
     **/
    public float getUnits(){
        return units;
    }

    /**
     *Returns the value of the year level field
     **/
    public byte getYearLevel(){
        return yearLevel;
    }

    /**
     *Returns the value of the terms field
     **/
    public byte getTerm(){
        return term;
    }

    /**
     *Returns the value of the grade field
     **/
    public int getGrade(){
        return grade;
    }

    /**
     *Returns a string describing a course
     **/
    public String toString(){
        String result="";
        result = yearLevel+","+term+","+number+","+title+","+units+","+grade;
        return result;
    }

    /**
     *Returns 0 if this Course and another course has the same grade
     *Returns -1 if the grade of this Course is less than the grade of another course
     *Returns 1 if the grade of this Course is greater than the grade of another course
     **/
    public int compareTo(SampleCourse another){
        if (this.getGrade() > another.getGrade())
            return 1;
        else
        if (this.getGrade() < another.getGrade())
            return -1;
        else
            return 0;

    }
} // end of class SampleCourse