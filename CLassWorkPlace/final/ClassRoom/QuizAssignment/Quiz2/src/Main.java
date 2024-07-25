import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Employee> Employees = new ArrayList<>();
        Employee emp1 = new Employee("Basil", 1000.0);
        Employee emp2 = new Employee("Basil", 1000.0);
        Employee emp3 = new Employee("Basil", 1000.0);
        Employee emp4 = new Employee("Fadi", 500.0);
        Employees.add(emp1);
        Employees.add(emp2);
        Employees.add(emp3);
        Employees.add(emp4);

        System.out.println("----------Original List------------");
        for (Employee employee : Employees) {
            System.out.println(employee);
        }

        Set<Employee> uniqueEmployees = new HashSet<>(Employees);
        System.out.println("----------Unique List------------");
        for (Employee employee : uniqueEmployees) {
            System.out.println(employee);
        }
    }
}
