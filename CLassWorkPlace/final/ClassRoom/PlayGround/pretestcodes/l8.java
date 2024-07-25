package PlayGround.pretestcodes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

import PlayGround.TriFunction;

/*
 * Functional programming / Comparator
 */
class EmployeeSalaryComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee e1, Employee e2) {
        if (e1.salary == e2.salary) return 0;
        else if (e1.salary < e2.salary) return -1;
        else return 1;
    }
}

class EmployeeNameComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee e1, Employee e2) {
        return e1.name.compareTo(e2.name);
    }
}

class Employee {
    String name;
    int salary;

    public Employee(String n, int s) {
        this. name = n;
        this. salary = s;
    }

    public String getName() {
        return name;
    }
    public int getSalary() {
        return salary;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Name: " + this.name + ", Salary: " + this.salary;
    }
}


public class l8 {

    /*
    * lambda expressions for functional interfaces
    * there is a 4th type which is Class::new 
    */
    static TriFunction<Integer, Integer, Integer, Integer> tf = (x,y,z) -> x + y + z;
    static BiFunction<Integer, Integer, Integer> bf = (x,y) -> x + y;
    static Function<Integer, Integer> f = (x) -> x;

    static Consumer<String> cn = x-> System.out.println(x);
    static BiConsumer<String,String> bcn = (x,y)-> System.out.println(x + y);

    // (Employee e) -> e.getName();
    static Function<Employee, String> getName = (Employee e) -> e.getName();
    static Function<Employee, String> getName2 = Employee::getName; // Method reference type: Class::instanceMethod

    // (Employee e,String s) -> e.setName(s)
    static BiConsumer<Employee, String> setName = (Employee e, String s) -> e.setName(s);
    static BiConsumer<Employee, String> setName2 = Employee::setName; // Method reference type: Class::instanceMethod

    // (String s1,String s2) -> s1.compareTo(s2)
    static BiFunction<String, String, Integer> compareTo = (String s1, String s2) -> s1.compareTo(s2);
    static BiFunction<String, String, Integer> compareTo2 = String::compareTo; // Method reference type: Class::instanceMethod

    // (Integer x,Integer y) -> Math.pow(x,y)
    static BiFunction<Integer, Integer, Double> pow1 = (Integer x, Integer y) -> Math.pow(x, y);
    static BiFunction<Integer, Integer, Double> pow2 = Math::pow; // Method reference type: Class::staticMethod

    // (String x) -> Integer.parseInt(x);
    static Function<String, Integer> parseInt1 = (String x) -> Integer.parseInt(x);
    static Function<String, Integer> parseInt2 = Integer::parseInt; // Method reference type: Class::staticMethod

    // EmployeeNameComparator comp = new EmployeeNameComparator(); (Employee e1, Employee e2) -> comp.compare(e1,e2)
    static EmployeeNameComparator comp = new EmployeeNameComparator();
    static BiFunction<Employee, Employee, Integer> compare = (Employee e1, Employee e2) -> comp.compare(e1, e2);
    static BiFunction<Employee, Employee, Integer> compare2 = comp::compare; // Method reference type: instance::instanceMethod

    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("John Doe", 50000));
        employees.add(new Employee("Jane Smith", 60000));
        employees.add(new Employee("Alice Johnson", 55000));
        employees.add(new Employee("Bob Brown", 70000));
        
        System.out.println("----Comprator by name------");
        Collections.sort(employees, new EmployeeNameComparator());
        employees.forEach(System.out::println);
        System.out.println("----Comprator by salary------");
        Collections.sort(employees, new EmployeeSalaryComparator());
        employees.forEach(System.out::println);
        System.out.println("-----Comprator with lambda-----");
        Collections.sort(employees, (e1,e2) -> e1.name.compareTo(e2.name));
        employees.forEach(System.out::println);
        System.out.println("-----Lambda Funtions-----");
        System.out.println("TriFunction: " + l8.tf.apply(1, 2,3));
        System.out.println("BiFunction: " + l8.bf.apply(1,2));
        System.out.println("Function: " + l8.f.apply(1));

        setName.accept(employees.get(0), "Basil");
        System.out.println(employees.get(0));


        List<String> strings = Arrays.asList("Eleven", "strikes", "the", "clock");
        String[] stringArr2 = strings.stream().toArray(String[]::new); // Method reference type: Class::new 
        System.out.println(Arrays.toString(stringArr2));

    }
}
