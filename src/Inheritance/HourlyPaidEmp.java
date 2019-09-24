package Inheritance;

public class HourlyPaidEmp extends Employee {
    private int hoursWorked;
    private double hourlyRate;

    public HourlyPaidEmp(String name, double hourlyRate, int hoursWorked, double taxRate) {
        super(name, taxRate);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }
}
