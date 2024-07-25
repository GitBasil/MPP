package prob4C;

public class Salaried extends Employee {
    private double salary;
    public Salaried(String empId, double salary) {
        super(empId);
        this.salary = salary;
    }

    @Override
    public double calcGrossPay(int month, int year) {
        return salary;
    }
    
}
