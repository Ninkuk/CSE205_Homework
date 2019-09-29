package Inheritance;

public abstract class Employee {
    protected String name;
    protected double taxRate;
    protected double monthlySalary;
    protected double taxPaid;

    public Employee(String name, double taxRate) {
        this.name = name;
        this.taxRate = taxRate;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\nMonthly Salary: " + monthlySalary + "\nTax Paid: " + taxPaid;
    }

    public abstract void calculateSalary();
}
