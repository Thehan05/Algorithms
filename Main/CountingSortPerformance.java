import java.util.Random;

public class CountingSortPerformance {

    // Benchmark counting sort on random arrays and return the average time
    public static long benchmarkRandom(int n, int min, int max, int iterations) {
        long total = 0;
        // Warmup
        for (int i = 0; i < 3; i++) {
            int[] arr = ArrayUtils.generateRandom(n, min, max);
            CountingSort.countingSort(arr, arr.length);
        }

        // Run the timed benchmark multiple times
        for(int i = 0; i < iterations; i++) {
            int[] arr = ArrayUtils.generateRandom(n, min, max);

            // Record the time before and after sorting
            long start = System.nanoTime();
            CountingSort.countingSort(arr, arr.length);
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
            int[] arr = ArrayUtils.generateSorted(n);
            CountingSort.countingSort(arr, arr.length);
        }

        // Run the timed benchmark multiple times
        for(int i = 0; i < iterations; i++) {
            int[] arr = ArrayUtils.generateSorted(n);

            // Record the time before and after sorting
            long start = System.nanoTime();
            CountingSort.countingSort(arr, arr.length);
            long end = System.nanoTime();

            total += (end - start);
        }

        // Return the average runtime
        return total / iterations;
    }

    public static void table1Benchmark() {
        System.out.println("\nCounting Sort Benchmark in ms Over Random(T1) and Sorted Inputs(T2)");
        System.out.println("===================================================================");
        System.out.println("_____________________________________________________");
        System.out.println("|            |            |            |            |");
        System.out.println("|     n      |     r      |     T1     |     T2     |");
        System.out.println("|____________|____________|____________|____________|");

        int[] sizes = {1000000, 2000000, 3000000, 4000000, 5000000};
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


    public static void table2Benchmark() {
        System.out.println("\n\n\nRunning Times in ms for Counting sort wtih (T1) and without preprocessing (T2)");
        System.out.println("==============================================================================");
        System.out.println("_____________________________________________________");
        System.out.println("|            |            |            |            |");
        System.out.println("|     n      |     r      |     T1     |     T2     |");
        System.out.println("|____________|____________|____________|____________|");

        int[] sizes = {500, 1000, 2000, 3000, 5000, 10000, 25000, 50000};
        int r = 1000000;
        int iterations = 10;

        for(int n :sizes) {
            long t1 = QuickSortPerformance.benchmarkHybrid(n, 0, r-1, iterations);
            long t2 = benchmarkRandom(n, 0, r-1, iterations);
            System.out.printf("|  %7d   |  %7d   |   %6.2f   |   %6.2f   |%n", n, r, t1 / 1_000_000.0, t2 / 1_000_000.0 );
        }
        System.out.println("|____________|____________|____________|____________|");
    }

    public static void main (String[] args) {
        table1Benchmark();
        table2Benchmark();
    }
}


