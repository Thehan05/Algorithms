public class ClassicQuickSort {
        public static void quickSort(int[] arr) {

            // no need to do anything if array is empty or only has 1 element
            if (arr == null || arr.length <= 1) {
                return;
            }
            // recursive call on whole array
            quickSort(arr, 0, arr.length - 1);
        }

        // recursive helper method
        private static void quickSort(int[] arr, int low, int high) {

            // continue if there are at least 2 elements to sort
            if (low < high) {

                // get the pivot index
                int pivotIndex = partition(arr, low, high);

                // recursive call sectioning the array from left of pivot
                quickSort(arr, low, pivotIndex - 1);

                // another recursive call sectioning the array from right of pivot
                quickSort(arr, pivotIndex + 1, high);
            }
        }

        public static int partition(int[] arr, int low, int high) {

            // get the pivot from median function
            int pivot = medianOfThree(arr, low, high);
            int i = low - 1;

            /*
            loop through subarray, if the value is smaller or equal to pivot, we move it to the left of pivot
            the i is used here to place the elements that are smaller than pivot in the correct place.
            makes sure that even if we skip over a value that is bigger than pivot we are putting the smaller ones on
            the left of it
             */
            for (int j = low; j < high; j++) {
                if (arr[j] <= pivot) {
                    i++;
                    swap(arr, i, j);
                }
            }

            /*
            the bigger elements is still on the left of the pivot so we swap the pivot to the i + 1
            index which is just above the all the smaller values
             */
            swap(arr, i + 1, high);
            return i + 1;
        }

        // helper method to move elements around
        public static void swap(int[] arr, int i, int j) {
            /*
            use a temporary variable to store the element i.
            Using the array, we put the element j at element i place.
            then get rid of the old duplicate element j with the temporary element i
            in the end we are just swapping i to js place
            */
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        // pivot chooser
        public static int medianOfThree(int[] arr, int low, int high) {
            // find the middle index of the array
            int mid = low + (high - low) / 2;

            // sort the 3 values low, mid and high from smallest to largest
            if(arr[low] > arr[mid]) {swap(arr, low, mid);}
            if(arr[low] > arr[high]) {swap(arr, low, high);}
            if(arr[mid] > arr[high]) {swap(arr, mid, high);}

            // we switch the median pivot to the end of array as our partition method requires the pivot there
            swap(arr, mid, high);
            return arr[high];
        }
}