package Assignment5;

public class Student extends People {
    private String major;
    private double gpa;


    public Student(String first_name, String last_name, String phoneNumber, String major) {
        super(first_name, last_name, phoneNumber);
        this.major = major;
        this.gpa = 0;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public void changeMajor(String major) {
        this.major = major;
    }

    @Override
    public String toString() {
        return super.toString() + "\nMajor: " + major + "\nGPA: " + gpa;
    }
}
