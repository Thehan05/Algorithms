import java.util.Random;

public class CountingSortWithPreprocessingPerformance {

    // Paper Table 2 uses n = 1000, 2000, 3000 and r = 1,000,000.
    // This benchmark compares:
    // T1 = counting sort WITH preprocessing
    // T2 = counting sort WITHOUT preprocessing

    public static int[] generateRandomArray(int n, int min, int max) {
        Random rand = new Random();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = rand.nextInt(max - min + 1) + min;
        }
        return arr;
    }

    public static long benchmarkWithPreprocessing(int n, int min, int max, int iterations) {
        long total = 0;

        // Warmup
        for (int i = 0; i < 3; i++) {
            int[] arr = generateRandomArray(n, min, max);
            QuickSortWithCountingSort.quickSort_countingSort(arr);
        }

        // Timed runs
        for (int i = 0; i < iterations; i++) {
            int[] arr = generateRandomArray(n, min, max);

            long start = System.nanoTime();
            QuickSortWithCountingSort.quickSort_countingSort(arr);
            long end = System.nanoTime();

            total += (end - start);
        }

        return total / iterations;
    }

    public static long benchmarkWithoutPreprocessing(int n, int min, int max, int iterations) {
        long total = 0;

        // Warmup
        for (int i = 0; i < 3; i++) {
            int[] arr = generateRandomArray(n, min, max);
            counting_sort.countingSort(arr, arr.length);
        }

        // Timed runs
        for (int i = 0; i < iterations; i++) {
            int[] arr = generateRandomArray(n, min, max);

            long start = System.nanoTime();
            counting_sort.countingSort(arr, arr.length);
            long end = System.nanoTime();

            total += (end - start);
        }

        return total / iterations;
    }

    public static void main(String[] args) {
        int[] sizes = {1000, 2000, 3000};
        int range = 1_000_000;
        int iterations = 10;

        System.out.println("\nRunning Times in ms for Counting Sort With Preprocessing (T1) and Without Preprocessing (T2)");
        System.out.println("==================================================================================================");
        System.out.println("______________________________________________________________");
        System.out.println("|            |            |              |                   |");
        System.out.println("|     n      |     r      |      T1      |        T2         |");
        System.out.println("|____________|____________|______________|___________________|");

        for (int n : sizes) {
            long t1 = benchmarkWithPreprocessing(n, 0, range - 1, iterations);
            long t2 = benchmarkWithoutPreprocessing(n, 0, range - 1, iterations);

            System.out.printf("|  %7d   |  %7d   |    %8.2f  |      %8.2f     |%n",
                    n, range, t1 / 1_000_000.0, t2 / 1_000_000.0);
        }

        System.out.println("|____________|____________|______________|___________________|");
    }
}
