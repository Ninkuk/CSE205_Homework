package Inheritance;

public class MonthlyPaidEmp extends Employee {
    private double annualSalary;


    public MonthlyPaidEmp(String name, double annualSalary, double taxRate) {
        super(name, taxRate);
        this.annualSalary = annualSalary;
    }

    public void calculateSalary() {
        super.monthlySalary = annualSalary / 12;
        super.taxPaid = super.monthlySalary * super.taxRate;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
