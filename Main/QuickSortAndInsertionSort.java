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

        int pivot = medianOfThree(arr, low, high);
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, high);
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

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static int medianOfThree(int[] arr, int low, int high) {
        int mid = low + (high - low) / 2;

        if(arr[low] > arr[mid]) {swap(arr, low, mid);}
        if(arr[low] > arr[high]) {swap(arr, low, high);}
        if(arr[mid] > arr[high]) {swap(arr, mid, high);}

        swap(arr, mid, high);
        return arr[high];
    }


    public static void main(String[] args) {
        int[] data = {29, 10, 14, 37, 13, 5, 8, 21};

        System.out.println("Before sorting:");
        printArray(data);

        sort(data);

        System.out.println("After sorting:");
        printArray(data);
    }

    private static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
