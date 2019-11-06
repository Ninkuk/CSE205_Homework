package ClassActivity6;

public class SelectionSorter {

    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minPos = minimumPosition(arr, i);

            int temp = arr[minPos];
            arr[minPos] = arr[i];
            arr[i] = temp;
        }
    }

    public static int minimumPosition(int[] a, int start) {
        int minPos = start;
        for (int i = start + 1; i < a.length; i++) {
            if (a[i] < a[minPos]) {
                minPos = i;
            }
        }
        return minPos;
    }
}