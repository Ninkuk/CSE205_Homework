package ClassActivity6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        ArrayList numsArray = new ArrayList<Arrays>();
        for (int i = 1; i < 7; i++) {
            numsArray.add(createNumsArray(i * 10000));
        }
        System.out.println();

        StopWatch timer = new StopWatch();


        for (int i = 1; i < numsArray.size() + 1; i++) {
            //Java in-built sort
            timer.start();
            Arrays.sort((int[]) numsArray.get(i - 1));
            timer.stop();
            System.out.println("Java In-Built Sort(" + i + "): " + timer.getElapsedTime());

            timer.reset();

            //Selection Sort
            timer.start();
            SelectionSorter.sort((int[]) numsArray.get(i - 1));
            timer.stop();

            System.out.println("Selection Sort(" + i + "): " + timer.getElapsedTime());

            timer.reset();

            //Merge Sort
            timer.start();
            MergeSorter.sort((int[]) numsArray.get(i - 1));
            timer.stop();
            System.out.println("Merge Sort(" + i + "): " + timer.getElapsedTime());

            timer.reset();

            //Quick Sort
            timer.start();
            QuickSorter.sort((int[]) numsArray.get(i - 1), 0, (i * 10000) - 1);
            timer.stop();
            System.out.println("Quick Sort(" + i + "): " + timer.getElapsedTime() + "\n");

            timer.reset();
        }
    }

    private static int[] createNumsArray(int index) {
        Random random = new Random();
        int[] numsArray = new int[index];

        for (int i = 0; i < index; i++) {
            numsArray[i] = random.nextInt(10);
        }

        return numsArray;
    }

}
