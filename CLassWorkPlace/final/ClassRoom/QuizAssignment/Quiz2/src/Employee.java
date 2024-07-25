import java.util.Objects;

public class Employee {
    private String Name;
    private Double Salary;
    Employee(String Name, Double Salary) {
        this.Name = Name;
        this.Salary =Salary;
    }

    public String getName() {
        return Name;
    }
    public double getSalary() {
        return Salary;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null) return false;
        if(!(obj instanceof Employee)) return false;
        Employee em = (Employee) obj;

        return em.Name.equals(Name) && em.Salary.equals(Salary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Name,Salary);
    }

    @Override
    public String toString() {
        return "Name: " + Name + ", Salary: " + Salary;
    }
}
