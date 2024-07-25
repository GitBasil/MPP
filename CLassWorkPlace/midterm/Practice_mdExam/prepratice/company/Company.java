package Practice_mdExam.prepratice.company;

import java.util.*;

public class Company {
    private String name;
    private List<Department> departments;

    public Company(String name){
        this.name = name;
        this.departments = new ArrayList<>();
    }

    public double getSalary()
    {
        double salary =0;
        for (Department department : departments) {
            salary += department.getSalary();
        }
        return salary;
    }

    public void addDepartment(Department department){
        this.departments.add(department);
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public String getName() {
        return name;
    }
    
}
