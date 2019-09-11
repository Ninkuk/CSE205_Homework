import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Lottery {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter your lottery number: ");
        String userNum = scan.nextLine();

        int[] user = new int[5];
        int[] lottery = new int[5];

        Random rand = new Random();

        for (int i = 0; i < 5; i++) {
//            user[i] = Integer.parseInt(userNum.)

            lottery[i] = rand.nextInt(10);
        }

        int matchedNums = 0;
        for (int i = 0; i < 5; i++) {
            if (user[i] == lottery[i]) {
                matchedNums++;
            }
        }

        System.out.println("Lottery Number was " + Arrays.toString(lottery));
        System.out.println("User Number was " + Arrays.toString(user));

        if (matchedNums == 5) {
            System.out.println("Congratulations!");
        }
    }
}
