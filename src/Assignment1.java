import java.util.Scanner;

public class Assignment1 {
    public static void main(String[] args) {
        displayWelcomeHeader(); //This method displays the stylized welcome header text
        calculateCosts(); // This method takes user input and calculates the cost of haircut
    }

    private static void calculateCosts() {
        Scanner scanKeyboard = new Scanner(System.in);

        System.out.println("\nPlease enter haircut type (adult or kids) : ");
        String haircutType;
        while (true) {
            if (scanKeyboard.hasNextLine()) {
                haircutType = scanKeyboard.nextLine().toLowerCase();
                if (haircutType.equals("adult") || haircutType.equals("kids")) {
                    break;
                } else {
                    System.out.println("Sorry, please input a valid haircut type (adult or kids)");
                }
            } else {
                System.out.println("Sorry, please input a valid haircut type (adult or kids)");
            }
        }


        System.out.println("\nPlease enter the coupon color code (green-1, blue-2, no coupon-0): ");
        int couponColor;
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
        double kidsCost;
        switch (couponColor) {
            case 1:
                adultCost = 3.50;
                kidsCost = 2.50;
                break;
            case 2:
                adultCost = 2.59;
                kidsCost = 1.50;
                break;
            default:
                adultCost = 15.50;
                kidsCost = 10.50;
        }

        double totalCost;
        if (haircutType.equals("adult")) {
            totalCost = adultCost;
        } else {
            totalCost = kidsCost;
        }

        System.out.println("Your Total: $" + totalCost);

        System.out.println("More Calculations? (YES/NO)");
        String rerun = scanKeyboard.next().toLowerCase();
        if (rerun.equals("yes")) {
            calculateCosts();
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