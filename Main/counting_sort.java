public class counting_sort {

    public static void countingSort(int[] arr, int n) {

        // hold the sorted result, get the largest value in an array,
        // create a count array storing the number of appearances of each number
        int[] output = new int[n];
        int r = getMax(arr, n);
        int[] count = new int[r + 1];

        // set all counts to 0 in an array
        for(int i = 0; i <= r; i++){
            count[i] = 0;
        }

        // goes through the array and gathers the number of times each number appears
        for(int i = 0; i < n; i++){
            count[arr[i]]++;
        }

        // instead of just checking frequencies, we are cumulatively adding them, checking how many are equal or less than that value
        // gives you information on the ending position of each value
        for(int i = 1; i <= r; i++){
            count[i] += count[i - 1];
        }

        /*
        reading from right to left making the sort more stable making duplicates land in the correct order
        we find the position of the value and then decrement it to fit the right indexing for the output array
         */
        for(int i = n - 1; i >= 0; i--){
            count[arr[i]]--;
            output[count[arr[i]]] = arr[i];
        }

        // copying the values into the original array
        for(int i = 0; i < n; i++){
            arr[i] = output[i];
        }

    }

    public static int getMax(int[] arr, int n){

        // assume the first element is the biggest
        int max = arr[0];

        // go through an array, and if a value is bigger, we set it to max
        for(int i = 0; i < n; i++){
            if(arr[i] > max){
                max = arr[i];
            }
        }
        return max;
    }
}

