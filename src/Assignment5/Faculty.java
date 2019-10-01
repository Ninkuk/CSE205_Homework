package Assignment5;

import java.util.ArrayList;

public class Faculty extends Employee {
    public static int numberOfFaculty;
    private String department;
    private ArrayList<String> classesTeach = new ArrayList<>();

    public Faculty(String first_name, String last_name, String phoneNumber, double payRate, int payScale, String department) {
        super(first_name, last_name, phoneNumber, payRate, payScale);
        this.department = department;
        numberOfFaculty++;
    }

    public void addClass(String className) {
        classesTeach.add(className);
    }

    public void calculatePay() {
        super.monthlyPay = super.payRate / super.payScale + 500 * classesTeach.size();
    }

    @Override
    public String toString() {
        return super.toString() + "\nClasses Teach: " + classesTeach.toString() + "\nMonthly Pay: " + monthlyPay;
    }
}
