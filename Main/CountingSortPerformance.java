import java.util.Random;

public class CountingSortPerformance {

    // test an array of size n with random values between max and min
    public static int[] generateRandomArray(int n, int min, int max) {
        Random rand = new Random();
        int[] arr = new int[n];

        // put random values in each position of the array
        for (int i = 0; i < n; i++) {
            arr[i] = rand.nextInt(max - min + 1) + min;
        }
        return arr;
    }

    // create an already sorted array from 0 to n - 1
    public static int[] generateSortedArray(int n) {
        int[] arr = new int[n];

        // fill the array from ascending order
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        return arr;
    }

    // Benchmark counting sort on random arrays and return the average time
    public static long benchmarkRandom(int n, int min, int max, int iterations) {
        long total = 0;
        // Warmup
        for (int i = 0; i < 3; i++) {
            int[] arr = generateRandomArray(n, min, max);
            counting_sort.countingSort(arr, arr.length);
        }

        // Run the timed benchmark multiple times
        for(int i = 0; i < iterations; i++) {
            int[] arr = generateRandomArray(n, min, max);

            // Record the time before and after sorting
            long start = System.nanoTime();
            counting_sort.countingSort(arr, arr.length);
            long end = System.nanoTime();

            total += (end - start);
        }

        // Return the average runtime
        return total / iterations;
    }

    // Benchmark counting sort on already sorted arrays and return the average time
    public static long benchmarkSorted(int n, int iterations) {
        long total = 0;
        // Warmup
        for (int i = 0; i < 3; i++) {
            int[] arr = generateSortedArray(n);
            counting_sort.countingSort(arr, arr.length);
        }

        // Run the timed benchmark multiple times
        for(int i = 0; i < iterations; i++) {
            int[] arr = generateSortedArray(n);

            // Record the time before and after sorting
            long start = System.nanoTime();
            counting_sort.countingSort(arr, arr.length);
            long end = System.nanoTime();

            total += (end - start);
        }

        // Return the average runtime
        return total / iterations;
    }

    // Need to write main for testing benchmark of counting sort

    public static void main (String[] args) {
        System.out.println("\nCounting Sort Benchmark in ms Over Random(T1) and Sorted Inputs(T2)");
        System.out.println("=====================================================================");
        System.out.println("_____________________________________________________");
        System.out.println("|            |            |            |            |");
        System.out.println("|     n      |     r      |     T1     |     T2     |");
        System.out.println("|____________|____________|____________|____________|");

        int[] sizes = {1000000, 2000000, 3000000};
        int iterations = 10;

        // Benchmark counting sort for each input size
        for(int n :sizes) {
            long t1 = benchmarkRandom(n, 0, n-1, iterations);
            long t2 = benchmarkSorted(n, iterations);

            // Print average times in milliseconds
            System.out.printf("|  %7d   |  %7d   |   %6.2f   |   %6.2f   |%n", n, n, t1 / 1_000_000.0, t2 / 1_000_000.0);
        }
        System.out.println("|____________|____________|____________|____________|");
    }


}


