public class ClassicQuickSort {
        public static void quickSort(int[] arr) {
            if (arr == null || arr.length <= 1) {
                return;
            }
            quickSort(arr, 0, arr.length - 1);
        }

        private static void quickSort(int[] arr, int low, int high) {
            if (low < high) {
                int pivotIndex = partition(arr, low, high);

                quickSort(arr, low, pivotIndex - 1);
                quickSort(arr, pivotIndex + 1, high);
            }
        }

        private static int partition(int[] arr, int low, int high) {
            int pivot = arr[high];
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

        private static void swap(int[] arr, int i, int j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        public static void main(String[] args) {
            int[] data = {29, 10, 14, 37, 13, 5, 8, 21};

            System.out.println("Before sorting:");
            printArray(data);

            quickSort(data);

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