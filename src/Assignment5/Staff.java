package Assignment5;

public class Staff extends Employee {
    public static int numberOfStaff;
    private String title;


    public Staff(String first_name, String last_name, String phoneNumber, double payRate, int payScale, String title) {
        super(first_name, last_name, phoneNumber, payRate, payScale);
        this.title = title;
        numberOfStaff++;
    }

    public void calculatePay() {
        super.monthlyPay = super.payRate / super.payScale;
    }

    @Override
    public String toString() {
        return super.toString() + "\nTitle: " + title + "\nMonthly Pay: " + super.monthlyPay;
    }
}
