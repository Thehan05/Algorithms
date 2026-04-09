import java.util.Random;

public class ClassicQuickSortPerformance {
/* ------------------------ TEMPORARY PERFORMANCE TESTER --------------------- */
    // DELETE THIS LATER COUNING SORT PERFROMANCE DOES ALREADY
    // test an array of size n filled with integer from max to min
    public static int[] generateRandomArray(int n, int min, int max) {
        Random rand = new Random();
        int[] arr = new int[n];

        // put random integers in each index of the array
        for (int i = 0; i < n; i++) {
            arr[i] = rand.nextInt(max - min + 1) + min;
        }
        return arr;
    }

    // Benchmark quick sort on random arrays and return the average running time
    public static long benchmarkRandom(int n, int min, int max, int iterations) {
        long total = 0;
        // Warmup
        for (int i = 0; i < 3; i++) {
            int[] arr = generateRandomArray(n, min, max);
            ClassicQuickSort.quickSort(arr);
        }

        //
        for(int i = 0; i < iterations; i++) {
            int[] arr = generateRandomArray(n, min, max);

            // Record the time before and after sorting
            long start = System.nanoTime();
            ClassicQuickSort.quickSort(arr);
            long end = System.nanoTime();

            total += (end - start);
        }

        // Return the average running time
        return total / iterations;
    }

    public static void main(String[] args) {
        int[] sizes = {1000000, 2000000};
        int iterations = 10;

        // Run the benchmark for each size and print the average time in milliseconds
        for (int n : sizes) {
            long t = benchmarkRandom(n, 0, n - 1, iterations);
            System.out.printf("n = %d, time = %.2f ms%n", n, t / 1_000_000.0);
        }
    }
}
