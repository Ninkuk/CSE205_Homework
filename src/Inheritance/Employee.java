package Inheritance;

public class Employee {
    protected String name;
    protected double taxRate;

    public Employee(String name, double taxRate) {
        this.name = name;
        this.taxRate = taxRate;
    }

    public void calculateSalary() {
    }
}
