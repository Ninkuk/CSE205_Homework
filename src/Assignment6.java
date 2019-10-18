import java.util.ArrayList;
import java.util.Scanner;

public class Assignment6 {
    public static void main(String[] args) {

        int[] numbers = getNumbersArray();

        int startIndex = 0, endIndex = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 0) {
                endIndex = i - 1;
                break;
            }
        }

        int min = findMin(numbers, startIndex, endIndex);
        System.out.println(min);
        int oddCount = countOdd(numbers, startIndex, endIndex);
//        int negativeOneCount = countNegativeOne(numbers, count);
//        int sumAtEvenIndexes = computeSumAtEvenIndexes(numbers, count);
    }

    private static int findMin(int[] numbers, int startIndex, int endIndex) {
        if (endIndex == startIndex) {
            return numbers[startIndex];
        }

        return Math.min(numbers[endIndex], findMin(numbers, startIndex, endIndex - 1));
    }

    private static int countOdd(int[] numbers, int startIndex, int endIndex) {
        if (numbers[endIndex] % 2 != 0) {
            return 1;
        }

        return countOdd(numbers, startIndex, endIndex - 1);
    }

    private static int[] getNumbersArray() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please Enter Number: ");
        int inputNum;
        int numCounter = 0;
        int[] numbers = new int[100];

        while (true) {
            if (scan.hasNextInt()) {
                inputNum = scan.nextInt();
                if (inputNum == 0) {
                    break;
                } else {
                    numbers[numCounter] = inputNum;
                    numCounter++;
                    System.out.println("Enter next number: ");
                }
            } else {
                System.out.println("Please enter a valid number!");
            }

            scan.nextLine();
        }

        return numbers;
    }
}