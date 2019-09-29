package Assignment5;

import java.util.*;

public class University {
    public static void main(String[] args) {
        String univ_Name, location;
        ArrayList<People> people = new ArrayList<>();

        char choice = 'A';
        String line;

        Scanner scan = new Scanner(System.in);

        // read the name and the location of the university here
        System.out.println("Please enter the name of the University: ");
        univ_Name = scan.nextLine();
        System.out.println("Please enter the location of " + univ_Name);
        location = scan.nextLine();

        String first_name;
        String last_name;
        String phoneNumber;
        double payRate;
        int payScale;

        do {
            System.out.print("What action would you like to perform?\n");
            printMenu();
            line = scan.nextLine();

            if (line.length() == 1) {
                choice = line.charAt(0);
                choice = Character.toUpperCase(choice);

                switch (choice) {
                    case 'A':
                        // add a Student here
                        /* read the first name, last name, phone number, major as parameters and then call the
                         * constructor of the Student class to create the instance
                         * then read the gpa, call setGpa method of the student to set the gpa
                         * finally add the student instance to the people list
                         */

                        System.out.println("Please enter the First Name: ");
                        first_name = scan.nextLine();

                        System.out.println("Please enter the Last Name: ");
                        last_name = scan.nextLine();

                        System.out.println("Please enter the Phone Number: ");
                        phoneNumber = scan.nextLine();

                        System.out.println("Please enter the Major: ");
                        String major = scan.nextLine();

                        Student student = new Student(first_name, last_name, phoneNumber, major);
                        people.add(student);

                        break;
                    case 'B':
                        // add a Staff here
                        /* read the first name, last name, phone number, payRate, payScale, and title and then call the
                         * constructor of the Staff class to create the instance
                         * finally add the Staff instance to the people list
                         */

                        System.out.println("Please enter the First Name: ");
                        first_name = scan.nextLine();

                        System.out.println("Please enter the Last Name: ");
                        last_name = scan.nextLine();

                        System.out.println("Please enter the Phone Number: ");
                        phoneNumber = scan.nextLine();

                        System.out.println("Please enter the Pay Rate: ");
                        payRate = scan.nextDouble();
                        scan.nextLine();

                        System.out.println("Please enter the Pay Scale: ");
                        payScale = scan.nextInt();
                        scan.nextLine();

                        System.out.println("Please enter the Title: ");
                        String title = scan.nextLine();

                        Staff staff = new Staff(first_name, last_name, phoneNumber, payRate, payScale, title);
                        people.add(staff);

                        break;
                    case 'C':
                        // add a Faculty here
                        /* read the first name, last name, phone number, payRate, payScale, and department and then call the
                         * constructor of the Faculty class to create the instance
                         * read list of courses the instructor read and call the addClass method
                         * of the faculty to add classes
                         * finally add the Faculty instance to the people list
                         */

                        System.out.println("Please enter the First Name: ");
                        first_name = scan.nextLine();

                        System.out.println("Please enter the Last Name: ");
                        last_name = scan.nextLine();

                        System.out.println("Please enter the Phone Number: ");
                        phoneNumber = scan.nextLine();

                        System.out.println("Please enter the Pay Rate: ");
                        payRate = scan.nextDouble();
                        scan.nextLine();

                        System.out.println("Please enter the Pay Scale: ");
                        payScale = scan.nextInt();
                        scan.nextLine();

                        System.out.println("Please enter the Department: ");
                        String department = scan.nextLine();

                        Faculty faculty = new Faculty(first_name, last_name, phoneNumber, payRate, payScale, department);
                        people.add(faculty);

                        break;

                    case 'D':
                        // display university info
                        /* university name, location, number of students, number of faculty and number of
                         *staff
                         */

                        int numberOfStudents = 0;
                        int numberOfFaculty = 0;
                        int numberOfStaff = 0;

                        for (People person : people) {
                            if (person instanceof Student) {
                                numberOfStudents++;
                            } else if (person instanceof Faculty) {
                                numberOfFaculty++;
                            } else {
                                numberOfStaff++;
                            }
                        }

                        System.out.println("University Name: " + univ_Name +
                                "\nLocation: " + location +
                                "\nNumber of Students: " + numberOfStudents +
                                "\nNumber of Faculty: " + numberOfFaculty +
                                "\nNumber of Staff: " + numberOfStaff);

                        break;

                    case 'E':
                        // display people info
                        /* display the fist name and the last name of each person at school
                         *
                         */

                        for (People person : people) {
                            System.out.println(person);
                        }

                        break;

                    case 'F':
                        // display Student info
                        /* display fist name, last name, and the major of each student
                         * java has a construct called instanceof. That construct can determine
                         * the object instance type
                         * example:
                         *  String str = new String("hello");
                         *  if(str instanceof String) will be evaluated to true
                         */

                        for (People person : people) {
                            if (person instanceof Student) {
                                System.out.println(person);
                            }
                        }

                        break;

                    case 'G':
                        // display Employee info
                        /* display fist name, last name, pay rate, and monthly pay of each employee
                         *
                         */

                        for (People person : people) {
                            if (person instanceof Employee) {
                                System.out.println(person);
                            }
                        }

                        break;

                    case 'Q':
                        // quit the program

                        break;
                    case '?':
                        // display the menu again
                        printMenu();

                        break;

                    default:
                        System.out.println("default");
                }


            } else {
                System.out.print("Unknown action\n");
            }

        } while (choice != 'Q');


    }

    public static void printMenu() {
        System.out.print("Choice\t\tAction\n" +
                "------\t\t------\n" +
                "A\t\tAdd a Student\n" +
                "B\t\tAdd a Staff\n" +
                "C\t\tAdd a Faculty\n" +
                "D\t\tDisplay University  Info\n" +
                "E\t\tDisplay University People Info\n" +
                "F\t\tDisplay University Student Info\n" +
                "G\t\tDisplay University Employee Info\n" +
                "Q\t\tQuit\n" +
                "?\t\tDisplay Menu Again\n\n");
    }
}
