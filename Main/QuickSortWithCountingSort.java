import java.util.Arrays;

public class QuickSortWithCountingSort {

    private static final int C = 1000;

    public static void quickSort_countingSort(int[] arr){
        if(arr == null || arr.length <= 1){
            return;
        }

        int minValue = arr[0];
        int maxValue = arr[0];
        for(int i = 1; i < arr.length; i++){
            if(arr[i] < minValue){
                minValue = arr[i];
            }
            if(arr[i] > maxValue){
                maxValue = arr[i];
            }
        }

        modifiedQuickSort(arr, 0, arr.length - 1, maxValue, minValue);
    }

    private static void modifiedQuickSort(int[] arr, int low, int high, int maxValue, int minValue) {
        if(low >= high || (maxValue - minValue + high - low) <= C){
            if(low < high){
                int[] partition = Arrays.copyOfRange(arr, low, high + 1);
                counting_sort.countingSort(partition, partition.length);
                System.arraycopy(partition, 0, arr, low, partition.length);
            }
            return;
        }

        int pivot = ClassicQuickSort.partition(arr, low, high);
        int midValue = arr[pivot];
        modifiedQuickSort(arr, low, pivot - 1, midValue, minValue );
        modifiedQuickSort(arr, pivot + 1, high, maxValue, midValue);
    }

    public static void main(String[] args) {
        int[] data = {29, 10, 14, 37, 13, 5, 8, 21, 45, 2, 99, 67, 33, 11, 7};

        System.out.println("Before sorting:");
        for (int num : data) {
            System.out.print(num + " ");
        }
        System.out.println();

        quickSort_countingSort(data);

        System.out.println("After sorting:");
        for (int num : data) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
