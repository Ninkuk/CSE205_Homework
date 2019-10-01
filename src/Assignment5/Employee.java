package Assignment5;

public class Employee extends People {
    protected int payScale;

    public Employee(String first_name, String last_name, String phoneNumber, double payRate, int payScale) {
        super(first_name, last_name, phoneNumber);
        super.payRate = payRate;
        this.payScale = payScale;
    }
}
