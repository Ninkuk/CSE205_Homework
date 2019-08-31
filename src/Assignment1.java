import java.util.Scanner;


public class Assignment1 {
    public static void main(String[] args) {
        displayWelcomeHeader(); //This method displays the stylized welcome header text
        calculateCosts(); // This method takes user input and calculates the cost of haircut
    }

    private static void calculateCosts() {
        Scanner scanKeyboard = new Scanner(System.in);

        System.out.println("\nPlease enter haircut type (adult or kid) : ");
        String haircutType;
        //This while loop will accept inputs until user types either adult or kid
        while (true) {
            if (scanKeyboard.hasNextLine()) {
                haircutType = scanKeyboard.nextLine().toLowerCase(); //In case user types input in all uppercase or "Adult" which isn't equal to "adult"
                if (haircutType.equals("adult") || haircutType.equals("kid")) {
                    break;
                } else {
                    System.out.println("Sorry, please input a valid haircut type (adult or kid)");
                }
            } else {
                System.out.println("Sorry, please input a valid haircut type (adult or kid)");
            }
        }


        System.out.println("\nPlease enter the coupon color code (green-1, blue-2, no coupon-0): ");
        int couponColor;
        //This while loop will accept inputs until user types a coupon number
        while (true) {
            if (scanKeyboard.hasNextInt()) {
                couponColor = scanKeyboard.nextInt();
                if (couponColor == 1 || couponColor == 2 || couponColor == 0) {
                    break;
                } else {
                    System.out.println("Sorry, please enter a valid coupon code (green-1, blue-2, no coupon-0)");
                }
            } else {
                System.out.println("Sorry, please enter a valid coupon code (green-1, blue-2, no coupon-0)");
            }
        }

        double adultCost;
        double kidCost;
        switch (couponColor) {
            case 1:
                adultCost = 3.50;
                kidCost = 2.50;
                break;
            case 2:
                adultCost = 2.59;
                kidCost = 1.50;
                break;
            default:
                adultCost = 15.50;
                kidCost = 10.50;
        }

        double totalCost;
        if (haircutType.equals("adult")) {
            totalCost = adultCost;
        } else {
            totalCost = kidCost;
        }

        System.out.println("Your Total: $" + totalCost);

        System.out.println("More Calculations? (YES/NO)");
        String rerun = scanKeyboard.next().toLowerCase(); // In case user types input in all lowercase or "Yes" which isn't equal to "YES" or "yes"
        if (rerun.equals("yes")) {
            calculateCosts(); //Recursion
        }
    }

    private static void displayWelcomeHeader() {
        String welcomeText = "Welcome to Haircut Program";
        System.out.print("\n\t\t\t" + welcomeText + "\n\t\t\t");
        for (int i = 0; i < welcomeText.length(); i++) {
            System.out.print("=");
        }
    }
}