public class QuickSortAndInsertionSort {
    private static final int THRESHOLD = 16;

    public static void sort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        quickInsertionSort(arr, 0, arr.length - 1);
    }

    private static void quickInsertionSort(int[] arr, int low, int high) {
        if(low >= high) {
            return;
        }

        if(high - low + 1 <= THRESHOLD) {
            insertionSort(arr, low, high);
            return;
        }

        int pivotIndex = ClassicQuickSort.partition(arr, low, high);
        quickInsertionSort(arr, low, pivotIndex - 1);
        quickInsertionSort(arr, pivotIndex + 1, high);
    }

    private static void insertionSort(int[] arr, int low, int high) {
        for (int i = low + 1; i <= high; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= low && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }
    }

}
