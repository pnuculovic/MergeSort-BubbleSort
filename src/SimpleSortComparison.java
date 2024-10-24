import java.util.Random;
import java.util.Scanner;

public class SimpleSortComparison {

    // MergeSort method that divides and conquers
    public static void mergeSort(int[] arr, int start, int end) {
        if (end - start <= 1) {
            return;
        }
        int middle = (start + end) / 2;
        mergeSort(arr, start, middle);
        mergeSort(arr, middle, end);
        merge(arr, start, middle, end);
    }

    // Helper method to merge two sorted halves
    private static void merge(int[] arr, int start, int middle, int end) {
        int[] temp = new int[end - start];
        int i = start;
        int j = middle;
        int k = 0;
        
        while (i < middle && j < end) {
            if (arr[i] <= arr[j]) {
                temp[k] = arr[i];
                i++;
            } else {
                temp[k] = arr[j];
                j++;
            }
            k++;
        }
        while (i < middle) {
            temp[k] = arr[i];
            i++;
            k++;
        }
        while (j < end) {
            temp[k] = arr[j];
            j++;
            k++;
        }

        System.arraycopy(temp, 0, arr, start, temp.length);
    }

    // BubbleSort method
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j + 1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create a random array
        System.out.print("Enter the length of the random array: ");
        int length = scanner.nextInt();
        int[] randomArray = new Random().ints(length, 0, 101).toArray();

        // Clone arrays for both sorts
        int[] bubbleArray = randomArray.clone();
        int[] mergeArray = randomArray.clone();

        // Sort using BubbleSort
        long bubbleStartTime = System.nanoTime();
        bubbleSort(bubbleArray);
        long bubbleEndTime = System.nanoTime();

        // Sort using MergeSort
        long mergeStartTime = System.nanoTime();
        mergeSort(mergeArray, 0, mergeArray.length);
        long mergeEndTime = System.nanoTime();

        // Print results
        System.out.println("BubbleSort Time (nanoseconds): " + (bubbleEndTime - bubbleStartTime));
        System.out.println("MergeSort Time (nanoseconds): " + (mergeEndTime - mergeStartTime));

        
        scanner.close();
    }
}
