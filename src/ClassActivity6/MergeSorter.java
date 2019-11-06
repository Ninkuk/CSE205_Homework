package ClassActivity6;

public class MergeSorter {

    public static void sort(int[] arr) {
        if (arr.length <= 1) {
            return;
        }

        int[] first = new int[arr.length / 2];
        int[] second = new int[arr.length - first.length];

        for (int i = 0; i < first.length; i++) {
            first[i] = arr[i];
        }
        for (int i = 0; i < second.length; i++) {
            second[i] = arr[first.length + i];
        }

        sort(first);
        sort(second);
        merge(first, second, arr);
    }

    private static void merge(int[] first, int[] second, int[] arr) {
        int iFirst = 0;
        int iSecond = 0;
        int j = 0;

        while (iFirst < first.length && iSecond < second.length) {
            if (first[iFirst] < second[iSecond]) {
                arr[j] = first[iFirst];
                iFirst++;
            } else {
                arr[j] = second[iSecond];
                iSecond++;
            }
            j++;
        }


        while (iFirst < first.length) {
            arr[j] = first[iFirst];
            iFirst++;
            j++;
        }

        while (iSecond < second.length) {
            arr[j] = second[iSecond];
            iSecond++;
            j++;
        }
    }
}