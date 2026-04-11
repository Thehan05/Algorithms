import java.util.Random;

public class QuickSortPerformance {
    // test an array of size n filled with integer from max to min
    public static long benchmarkInsertion(int n, int min, int max, int iterations) {
        long total = 0;

        // Warmup
        for (int i = 0; i < 3; i++) {
            int[] arr = ArrayUtils.generateRandom(n, min, max);
            QuickInsertionSort.sort(arr);
        }

        // Timed runs
        for (int i = 0; i < iterations; i++) {
            int[] arr = ArrayUtils.generateRandom(n, min, max);

            long start = System.nanoTime();
            QuickInsertionSort.sort(arr);
            long end = System.nanoTime();

            total += (end - start);
        }

        return total / iterations;
    }

    // Benchmark quick sort on random arrays and return the average running time
    public static long benchmarkClassic(int n, int min, int max, int iterations) {
        long total = 0;
        // Warmup
        for (int i = 0; i < 3; i++) {
            int[] arr = ArrayUtils.generateSorted(n);
            QuickSort.quickSort(arr);
        }

        //
        for(int i = 0; i < iterations; i++) {
            int[] arr = ArrayUtils.generateRandom(n, min, max);

            // Record the time before and after sorting
            long start = System.nanoTime();
            QuickSort.quickSort(arr);
            long end = System.nanoTime();

            total += (end - start);
        }

        // Return the average running time
        return total / iterations;
    }

    public static long benchmarkHybrid(int n, int min, int max, int iterations) {
        long total = 0;
        // Warmup
        for (int i = 0; i < 3; i++) {
            int[] arr = ArrayUtils.generateRandom(n, min, max);
            HybridSort.hybridSort(arr);
        }

        //
        for(int i = 0; i < iterations; i++) {
            int[] arr = ArrayUtils.generateRandom(n, min, max);

            // Record the time before and after sorting
            long start = System.nanoTime();
            HybridSort.hybridSort(arr);
            long end = System.nanoTime();

            total += (end - start);
        }

        // Return the average running time
        return total / iterations;
    }

    public static void main(String[] args) {
        int[] sizes = {1000000, 2000000, 3000000};
        int iterations = 10;
        System.out.println("\n Running Times in ms for Quicksort (T1), Quicksort with Insertion Sort (T2), and Quicksort with Counting Sort (T3)");
        System.out.println("==================================================================================================================");
        System.out.println("_____________________________________________________");
        System.out.println("|            |            |            |            |");
        System.out.println("|   n = r    |     T1     |     T2     |     T3     |");
        System.out.println("|____________|____________|____________|____________|");

        // Run the benchmark for each size and print the average time in milliseconds
        for (int n : sizes) {
            long t1 = benchmarkClassic(n, 0, n - 1, iterations);
            long t2 = benchmarkInsertion(n, 0, n - 1, iterations);
            long t3 = benchmarkHybrid(n, 0, n - 1, iterations);
            System.out.printf("|  %7d   |   %6.2f   |   %6.2f   |   %6.2f   |%n", n, t1 / 1_000_000.0, t2 / 1_000_000.0, t3 / 1_000_000.0);
        }


        System.out.println("|____________|____________|____________|____________|");
    }
}
