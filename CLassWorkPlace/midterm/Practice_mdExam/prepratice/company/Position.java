package Practice_mdExam.prepratice.company;

public class Position {
    private String name;
    private String description;
    private Employee employee;

    public Position(String name, String description){
        this.name = name;
        this.description = description;
        this.employee = new Employee();
    }

    public double getSalary()
    {
        return employee.getSalary();
    }

    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public Employee getEmployee() {
        return employee;
    }
    public void setEmployee(Employee employee)
    {
        this.employee = employee;
    }
}
