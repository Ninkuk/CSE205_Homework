package Assignment4;

/**
 * @author Ninad Kulkarni
 * Assignemt 4
 * 9/20/2019
 */

import java.util.*;

public class Assignment4 {
    public static void main(String[] args) {
        // local variables, can be accessed anywhere from the main method

        //declaring the address variable here so I can reuse them in 2 places without creating new vars
        String streetName;
        String city;
        String state;
        int zipcode;

        char choice = 'Q';
        String line;

        // instantiate a Employee object
        Employee e1 = new Employee();

        //Create a Scanner object to read user input
        Scanner scan = new Scanner(System.in);

        do  // will ask for user input
        {
            System.out.println("What action would you like to perform?");
            printMenu();
            line = scan.nextLine();

            if (line.length() == 1) {
                // get the choice as a character
                choice = line.charAt(0);
                choice = Character.toUpperCase(choice);

                // matches one of the case statement
                switch (choice) {
                    case 'A':   //Add an employee

                        /*read first_name, last_name, age, address, base salary
                        then call the appropriate methods of the employee instance e1 to
                        set those values */

                        //Name
                        System.out.println("Enter First Name:");
                        String firstName = scan.nextLine();
                        System.out.println("Enter Last Name:");
                        String lastName = scan.nextLine();
                        e1.setName(firstName, lastName);

                        //Age
                        System.out.println("Enter Age:");
                        int age = scan.nextInt();
                        e1.setAge(age);
                        scan.nextLine();

                        //Salary
                        System.out.println("Enter Base Salary");
                        double baseSalary = scan.nextDouble();
                        e1.setBaseSalary(baseSalary);
                        scan.nextLine();

                        //Address
                        System.out.println("Enter Street Name:");
                        streetName = scan.nextLine();
                        System.out.println("Enter City:");
                        city = scan.nextLine();
                        System.out.println("Enter State:");
                        state = scan.nextLine();
                        System.out.println("Enter Zipcode:");
                        zipcode = scan.nextInt();
                        scan.nextLine();
                        e1.setAddress(streetName, city, state, zipcode);

                        break;

                    case 'D':   //Display Employee
                        System.out.println(e1);
                        break;

                    case 'C': // change address
                        /* read street name, city, state, zipcode and call appropriate
                        methods of e1 to change the address */

                        //New Address
                        System.out.println("Enter Street Name:");
                        streetName = scan.nextLine();
                        System.out.println("Enter City:");
                        city = scan.nextLine();
                        System.out.println("Enter State:");
                        state = scan.nextLine();
                        System.out.println("Enter Zipcode:");
                        zipcode = scan.nextInt();
                        scan.nextLine();

                        //First get the employee's address and then change it
                        e1.getAddress().changeAddress(streetName, city, state, zipcode);

                        break;

                    case 'Q':   //Quit
                        break;

                    case '?':   //Display Menu
                        printMenu();
                        break;

                    default:
                        System.out.print("Unknown action\n");
                        break;
                }
            } else {
                System.out.print("Unknown action\n");
            }


        } while (choice != 'Q');
    }

    /**
     * The method printMenu displays the menu to a user
     **/
    public static void printMenu() {
        System.out.print("Choice\t\tAction\n" +
                "------\t\t------\n" +
                "A\t\tAdd an Employee\n" +
                "D\t\tDisplay an Employee Info\n" +
                "C\t\tChange Address\n" +
                "Q\t\tQuit\n" +
                "?\t\tDisplay Menu Again\n\n"
        );
    }
}
