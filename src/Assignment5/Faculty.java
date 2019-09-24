package Assignment5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Faculty extends Employee {
    private String department;
    private ArrayList<String> classesTeach = new ArrayList<>();

    public Faculty(String first_name, String last_name, String phoneNumber, double payRate, int payScale, String department) {
        super(first_name, last_name, phoneNumber, payRate, payScale);
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
