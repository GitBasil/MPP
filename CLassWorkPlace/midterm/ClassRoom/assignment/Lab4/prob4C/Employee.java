package prob4C;

public abstract class Employee {
    private String empId;

    public Employee(String empId) {
        this.empId = empId;
    }

    public void print() {
        System.out.println("Employee ID :" + empId);
    }

    public Paycheck calcCompensation(int month, int year){
        double grossPay = calcGrossPay(month, year);
        return new Paycheck(grossPay);
    }

    public abstract double calcGrossPay(int month, int year);

}
