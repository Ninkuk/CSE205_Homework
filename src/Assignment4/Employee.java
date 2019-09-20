package Assignment4;

public class Employee {
    private String first_name;
    private String last_name;
    private int age;
    private double baseSalary;
    private Address address;

    public Employee() {
    }

    public String getName() {
        return first_name;
    }

    public double getSalary() {
        return baseSalary;
    }

    public Address getAddress() {
        return address;
    }

    public void setName(String first_name, String last_name) {
        this.first_name = first_name;
        this.last_name = last_name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public void setAddress(String streetName, String city, String state, int zipcode) {
        address = new Address(streetName, city, state, zipcode);
    }

    @Override
    public String toString() {
        return "First Name: " + first_name + "\nLast Name: " + last_name + "\nBase Salary: " + baseSalary + "\nAddress: " + address.toString();
    }
}
