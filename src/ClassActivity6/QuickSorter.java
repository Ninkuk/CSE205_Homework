package ClassActivity6;

public class QuickSorter {

    public static void sort(int[] arr, int start, int end) {
        if (start < end) {
            int pi = partition(arr, start, end);

            sort(arr, start, pi - 1);
            sort(arr, pi + 1, end);
        }
    }

    public static int partition(int[] arr, int start, int end) {
        int pivot = arr[end];
        int i = (start - 1);
        for (int j = start; j < end; j++) {
            if (arr[j] < pivot) {
                i++;

                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[end];
        arr[end] = temp;

        return i + 1;
    }
}
