import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Assignment2 {
    public static void main(String[] args) {
        validateCardNumber();
    }

    private static void validateCardNumber() {
        int cardNumber = getCardNumber();

        int evenNumsSum = 0;
        List<Integer> oddNums = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            if (i % 2 == 0) {
                evenNumsSum += cardNumber % 10;
                cardNumber /= 10;
            } else {
                oddNums.add((cardNumber % 10) * 2);
                cardNumber /= 10;
            }
        }

        int oddNumsSum = 0;
        for (int oddNum : oddNums) {
            int tempNum = oddNum % 10;
            oddNum /= 10;
            oddNumsSum += oddNum + tempNum;
        }


        int finalSum = evenNumsSum + oddNumsSum;
        if (finalSum % 10 == 0) {
            System.out.println("The card number is valid");
        } else {
            System.out.println("The card number is not valid");
        }
    }

    /**
     * This method prompts user to input the card number.
     * If the user enters the input in an incorrect format then an error message is printed
     *
     * @return card number
     */
    private static int getCardNumber() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter your Credit Card number: ");
        int cardNumber;
        while (true) {
            if (scan.hasNextInt()) {
                cardNumber = scan.nextInt();
                break;
            } else {
                System.out.println("Please enter a valid number");
            }

            scan.nextLine(); // Removes the next line. Without this we will be stuck in infinite loop.
        }

        return cardNumber;
    }
}
