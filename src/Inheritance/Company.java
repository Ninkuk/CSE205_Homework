package Inheritance;

import java.util.ArrayList;

public class Company {
    public static void main(String[] args) {

        ArrayList<Employee> empList = new ArrayList<Employee>();

        // take name, annual salary, and the tax rate
        MonthlyPaidEmp mpE1 = new MonthlyPaidEmp("John William", 55675.00, 0.1);
        MonthlyPaidEmp mpE2 = new MonthlyPaidEmp("Nancy William", 65675.00, 0.2);

        // take name, hourly rate, hours worked, and the tax rate
        HourlyPaidEmp hpE1 = new HourlyPaidEmp("Samira Monid", 7.50, 35, 0.2);

        // Add employees to the list
        empList.add(mpE1);
        empList.add(mpE2);
        empList.add(hpE1);

        // calculate salary for each employee
        for (int i = 0; i < empList.size(); i++) {
            Employee e = empList.get(i);
            e.calculateSalary();
            empList.set(i, e);
        }

        // display employee information for each employee
        for (int i = 0; i < empList.size(); i++) {
            System.out.println(empList.get(i));
            System.out.println();
        }
    }
}
