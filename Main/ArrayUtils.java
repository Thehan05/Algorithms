import java.util.Random;

public class ArrayUtils {
    public static int[] generateRandom(int n, int min, int max) {
        Random rand = new Random();
        int[] arr = new int[n];

        // put random integers in each index of the array
        for (int i = 0; i < n; i++) {
            arr[i] = rand.nextInt(max - min + 1) + min;
        }
        return arr;
    }

    public static int[] generateSorted(int n) {
        int[] arr = new int[n];

        // fill the array from ascending order
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        return arr;
    }

}
