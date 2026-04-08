public class counting_sort {

    public static int[] countingSort(int[] arr, int n) {
        int[] output = new int[n];
        int r = getMax(arr, n);
        int[] count = new int[r + 1];

        for(int i = 0; i <= r; i++){
            count[i] = 0;
        }

        for(int i = 0; i < n; i++){
            count[arr[i]]++;
        }

        for(int i = 1; i <= r; i++){
            count[i] += count[i - 1];
        }

        for(int i = n - 1; i >= 0; i--){
            count[arr[i]]--;
            output[count[arr[i]]] = arr[i];
        }

        for(int i = 0; i < n; i++){
            arr[i] = output[i];
        }

        return arr;
    }

    public static int getMax(int[] arr, int n){
        int max = arr[0];
        for(int i = 0; i < n; i++){
            if(arr[i] > max){
                max = arr[i];
            }
        }
        return max;
    }
}

