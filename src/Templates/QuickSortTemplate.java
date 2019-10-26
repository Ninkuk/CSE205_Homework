package Templates;

public class QuickSortTemplate {
    public static void main(String[] args) {
        int[] x = {10, 7, 8, 9, 1, 5};
        int n = x.length;

        sort(x, 0, n - 1);
    }

    private static void sort(int[] x, int start, int end) {
        if (start < end) {
            int part = partition(x, start, end);

            sort(x, start, part - 1);
            sort(x, part + 1, end);
        }
    }

    private static int partition(int[] x, int start, int end) {
        int pivot = x[end];
        int i = start - 1;

        for (int j = start; j < end; j++) {
            if (x[j] < pivot) {
                i++;

                int temp = x[i];
                x[i] = x[j];
                x[j] = temp;
            }
        }

        int temp = x[i + 1];
        x[i + 1] = x[end];
        x[end] = temp;

        return i + 1;
    }
}
