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

        int pivotIndex = partition(arr, low, high);
        quickInsertionSort(arr, low, pivotIndex - 1);
        quickInsertionSort(arr, pivotIndex + 1, high);
    }

    private static int partition(int[] arr, int low, int high) {

        int pivot = ClassicQuickSort.medianOfThree(arr, low, high);
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                ClassicQuickSort.swap(arr, i, j);
            }
        }

        ClassicQuickSort.swap(arr, i + 1, high);
        return i + 1;
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
