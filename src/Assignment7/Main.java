package Assignment7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        //Relative path depends on your working directory
        //TODO: Change Path
        Scanner in = new Scanner(new File("src/Assignment7/phoneCalls.txt"));

        ArrayList<PhoneCall> callRecordList = new ArrayList<>();

        while (in.hasNextLine()) {
            String readLine = in.nextLine();
            String[] lineSplit = readLine.split("/");
            PhoneCall call = new PhoneCall(lineSplit[0], Integer.parseInt(lineSplit[1]), lineSplit[2], lineSplit[3], Double.parseDouble(lineSplit[4]));
            callRecordList.add(call);
        }

        char choice = 'A';
        String input;
        Scanner scan = new Scanner(System.in);

        do {
            System.out.println("What action would you like to perform?");
            printMenu();
            input = scan.nextLine();

            if (input.length() == 1) {
                choice = Character.toUpperCase(input.charAt(0));
            } else {
                System.out.println("Sorry, Invalid input. Please try again!");
                continue;
            }

            switch (choice) {
                case 'A':
                    System.out.println("Enter the number you wish to search:");
                    PhoneCall callSearch;
                    callSearch = searchCall(scan.nextLine(), callRecordList);

                    if (callSearch == null) {
                        System.out.println("Sorry, no number found!");
                        break;
                    } else {
                        printCallInfo(callSearch);
                    }

                    break;
                case 'B':
                    printCallInfo(searchLongestCall(callRecordList));

                    break;
                case 'C':
                    printCallInfo(searchShortestCall(callRecordList));

                    break;
                case 'D':


                    break;
                case 'E':
                    break;
                default:
                    System.out.println("Sorry, Invalid input. Please try again!");
                    break;
            }


        } while (choice != 'F');

    }

    private static PhoneCall searchCall(String numberToSearch, ArrayList<PhoneCall> callRecordList) {
        for (PhoneCall callRecord : callRecordList) {
            if (numberToSearch.equals(callRecord.getNumber())) {
                return callRecord;
            }
        }

        return null;
    }

    private static PhoneCall searchLongestCall(ArrayList<PhoneCall> callRecordList) {
        PhoneCall longestCall = null;
        int longestDuration = Integer.MIN_VALUE;
        for (PhoneCall callRecord : callRecordList) {
            if (callRecord.getDuration() > longestDuration) {
                longestCall = callRecord;
            }
        }

        return longestCall;
    }

    private static PhoneCall searchShortestCall(ArrayList<PhoneCall> callRecordList) {
        PhoneCall shortestCall = null;
        int shortestDuration = Integer.MAX_VALUE;
        for (PhoneCall callRecord : callRecordList) {
            if (callRecord.getDuration() < shortestDuration) {
                shortestCall = callRecord;
            }
        }

        return shortestCall;

    }

    public static void sortCalls(ArrayList<PhoneCall> callRecordList) {

    }

    private static void createPhoneBill(ArrayList callRecordList) {

    }

    private static void printMenu() {
        System.out.println("A. Search a call based on the destination number\n" +
                "B. Display the longest call information\n" +
                "C. Display the shortest call information\n" +
                "D. Sort the phone calls array list based on the call duration and display calls in the sorted order\n" +
                "E. Prepare a phone bill\n" +
                "F. Exit the program");
    }

    private static void printCallInfo(PhoneCall callInfo) {
        System.out.println("Number: " + callInfo.number +
                "\nDuration: " + callInfo.getDuration() +
                "\nDate: " + callInfo.getDate() +
                "\nCallee Name: " + callInfo.getCalleeName() +
                "\nCost: " + callInfo.getCost());
    }
}
