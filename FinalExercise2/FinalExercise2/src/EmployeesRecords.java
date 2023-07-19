import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import java.util.stream.Collectors;

public class EmployeesRecords {
    public static void main(String[] args) {
        EmployeesRecords program;
        try {
            program = new EmployeesRecords();
            program.run();
        }catch (Exception x){
            x.printStackTrace();
        }
        System.exit(0);
    }

    public void run() throws Exception { //methods
        List<Employee> employees = readDataFileIntoList("data01.csv");
        showPopulationPerDepartment(employees);
        showFiveNewestHiredPermanentEmployees(employees);
        showEmployeesWithLessThanFiveYearsOfServiceSortedBySalaryInDescendingOrder(employees);
        showTotalServiceYearsInITServicesDepartment(employees);
        showEmployeeListPerDepartmentPartitionedByEmploymentStatus(employees);
    }

    private List<Employee> readDataFileIntoList(String filename) {
        try {
            List<Employee> employees = new ArrayList<>();
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            while (true) {
                String line = reader.readLine();
                if (line == null) {
                    break;
                }
                String[] data = line.split(",");
                boolean permanent = data[7].equalsIgnoreCase("permanent");
                Employee emp = new Employee(data[0], data[1], data[4], data[2].charAt(0),
                        Integer.parseInt(data[3]), permanent, Double.parseDouble(data[6]), Integer.parseInt(data[5]));
                employees.add(emp);
            }
            reader.close();
            return employees;
        } catch (Exception e) {
            throw new RuntimeException("Data file read error.");
        }
    }

    private void showEmployeesWithLessThanFiveYearsOfServiceSortedBySalaryInDescendingOrder(List<Employee> employees) {
        System.out.println("Lowest Paid Employees with less than 5 years of service (salary in descending order):");
        Comparator<Employee> comparator = (emp1, emp2) -> {
            if (emp1.getSalary() > emp2.getSalary()) {
                return -1;
            } else if (emp1.getSalary() < emp2.getSalary()) {
                return 1;
            } else {
                return 0;
            }
        };
        employees
                .stream()
                .filter(emp -> emp.getYrsOfService() < 5).sorted(comparator)
                .forEach(System.out::println);
        System.out.println("=============================================\n");
    }

    private void showFiveNewestHiredPermanentEmployees(List<Employee> employees) {
        System.out.println("Five newest employees who are hired as permanent:");
        employees
                .stream()
                .filter(emp -> emp.isPermanent())
                .sorted(
                        (emp1, emp2) -> {
                            if (emp1.getYrsOfService() < emp2.getYrsOfService()) {
                                return -1;
                            } else if (emp1.getYrsOfService() == emp2.getYrsOfService()) {
                                return 0;
                            }
                            return 1;
                        }
                )
                .limit(5)
                .forEach(System.out::println);
        System.out.println("=============================================\n");
    }

    private void showTotalServiceYearsInITServicesDepartment(List<Employee> employees) {
        System.out.print("Total years of service of employees in the IT Services Department: ");
        int sumYrs = employees.stream()
                .filter(emp -> emp.getDepartment().compareTo("IT Services") == 0)
                .mapToInt(Employee::getYrsOfService)
                .sum();
        System.out.println(sumYrs);
        System.out.println("=============================================\n");
    }

    private void showPopulationPerDepartment(List<Employee> employees) {
        System.out.println("List of departments and corresponding number of employees:");
        Map<String, List<Employee>> deptInfo = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
        Set<String> departments = deptInfo.keySet();
        for (String dept : departments) {
            List<Employee> emps = deptInfo.get(dept);
            int total = (int) emps.stream().count();
            System.out.printf("%s: %d%n", dept, total);
        }
        System.out.println("=============================================\n");
    }

    private void showEmployeeListPerDepartmentPartitionedByEmploymentStatus(List<Employee> employees) {
        System.out.println("List of employees per department partitioned by employment status:");
        Map<String, Map<Boolean, Set<Employee>>> allEmployees = new TreeMap<>();
        for (Employee emp: employees) {
            String dept = emp.getDepartment();
            boolean empStatus = emp.isPermanent();
            Map<Boolean, Set<Employee>> deptList = allEmployees.computeIfAbsent(dept, k -> new TreeMap<>());
            Set<Employee> empStatusList = deptList.computeIfAbsent(empStatus, k -> new TreeSet<>());
            empStatusList.add(emp);
        }
        Set<String> departments = allEmployees.keySet();
        for (String dept: departments) {
            System.out.printf("%s%n", dept);
            Map<Boolean, Set<Employee>> empStatusList = allEmployees.get(dept);
            Set<Boolean> empStats = empStatusList.keySet();
            for (boolean empStat: empStats) {
                System.out.printf("\t%s%n", empStat ? "Permanent" : "Not Permanent");
                Set<Employee> empStatList = empStatusList.get(empStat);
                for(Employee emp: empStatList) {
                    System.out.println("\t\t" + emp.toString());
                }
            }
        }
        System.out.println("=============================================\n");
    }
}
