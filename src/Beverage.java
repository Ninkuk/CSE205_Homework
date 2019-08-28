import java.util.Scanner;

/**
 * ALGORITHM
 *
 * Print the survey question
 * In a while loop get the survey answers from the user using Scanner
 * Update the counter based on the input
 * Break the loop when -1 is entered
 * Display the result
 */
public class Beverage {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int coffeeCount = 0;
        int teaCount = 0;
        int cokeCount = 0;
        int juiceCount = 0;

        int peopleCounter = 1;

        while (true) {
            System.out.println("Please input the favourite beverage of person #" + peopleCounter + "\n1. Coffee\n2. Tea\n3. Coke\n4. Orange Juice\nEnter a number from above or enter -1 to end the program");
            int input = scan.nextInt();

            if (input == 1) {
                coffeeCount++;
            } else if (input == 2) {
                teaCount++;
            } else if (input == 3) {
                cokeCount++;
            } else if (input == 4) {
                juiceCount++;
            } else if (input == -1) {
                break;
            } else {
                System.out.println("Please enter valid input");
            }

            peopleCounter++;
        }

        System.out.println("The total number of people surveyed is " + peopleCounter + ". The result are as follows:");
        String resultHeader = "\nBeverage     Number of Votes";
        System.out.println(resultHeader);
        for (int i = 0; i < resultHeader.length(); i++) {
            System.out.print("*");
        }
        System.out.println("\nCoffee       " + coffeeCount + "\nTea          " + teaCount + "\nCoke         " + cokeCount + "\nOrange Juice " + juiceCount);
    }
}
