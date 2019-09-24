package Inheritance;

public class MonthlyPaidEmp extends Employee {
    private double annualSalary;


    public MonthlyPaidEmp(String name, double annualSalary, double taxRate) {
        super(name, taxRate);
        this.annualSalary = annualSalary;
    }




}
