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
                countingSortPartition(arr, low, high);
            }
            return;
        }

        int pivot = ClassicQuickSort.partition(arr, low, high);
        int midValue = arr[pivot];
        modifiedQuickSort(arr, low, pivot - 1, midValue, minValue );
        modifiedQuickSort(arr, pivot + 1, high, maxValue, midValue);
    }

    private static void countingSortPartition(int[] arr, int low, int high) {
        int n = high - low + 1;

        int localMin = arr[low];
        int localMax = arr[low];
        for(int i = low + 1; i <= high; i++){
            if(arr[i] < localMin){
                localMin = arr[i];
            }
            if(arr[i] > localMax){
                localMax = arr[i];
            }
        }

        int range = localMax - localMin + 1;
        int[] count = new int[range];
        int[] output = new int[n];

        for(int i = low; i <= high; i++){
            count[arr[i] - localMin]++;
        }

        for(int i = 1; i < range; i++){
            count[i] += count[i - 1];
        }

        for(int i = high; i >= low; i--){
            count[arr[i] - localMin]--;
            output[count[arr[i] - localMin]] = arr[i];
        }

        System.arraycopy(output, 0, arr, low, n);
    }
}
