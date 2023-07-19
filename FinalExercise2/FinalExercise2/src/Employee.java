public class Employee implements Comparable<Employee> {
    private String id;
    private String name;
    private String department;
    private char gender;
    private int age;
    private boolean isPermanent;
    private double salary;
    private int yrsOfService;

    public Employee(String id, String name, String department, char gender, int age, boolean isPermanent,
                    double salary, int yrsOfService) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.gender = gender;
        this.age = age;
        this.isPermanent = isPermanent;
        this.salary = salary;
        this.yrsOfService = yrsOfService;
    }

    @Override
    public int compareTo(Employee o) {
        return name.compareTo(o.name);
    }

    @Override
    public String toString() {
        return  String.format("%-10s\t%-20s\t%-30s\t%c\t%d %-15s\t%-10.2f\t%d",
                id, name, department, gender, age, (isPermanent ? "Permanent" : "Not Permanent"), salary, yrsOfService
        );
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public char getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public boolean isPermanent() {
        return isPermanent;
    }

    public double getSalary() {
        return salary;
    }

    public int getYrsOfService() {
        return yrsOfService;
    }
}
