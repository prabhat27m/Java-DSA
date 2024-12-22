package src.main.java.basic.sorting;

public class QuickSort {

    // Main quicksort method that initializes the sorting process
    public static void quickSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }

    // Recursive quicksort method
    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // Find the partition index
            int pi = partition(arr, low, high);

            // Recursively sort elements before and after partition
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    // Partitioning using last element as pivot
    private static int partition(int[] arr, int low, int high) {
        // Select the rightmost element as pivot
        int pivot = arr[high];

        // Index of smaller element
        int i = (low - 1);

        // Traverse through all elements
        // compare each element with pivot
        for (int j = low; j < high; j++) {
            // If current element is smaller than or equal to pivot
            if (arr[j] <= pivot) {
                i++;    // increment index of smaller element

                // Swap elements
                swap(arr, i, j);
            }
        }

        // Place pivot in its correct position
        swap(arr, i + 1, high);

        // Return the partition index
        return i + 1;
    }


    // Utility method to swap elements
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Utility method to print array
    public static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    // Main method with example usage
    public static void main(String[] args) {
        // Test Case 1: Random array
        int[] arr1 = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("Original Array 1:");
        printArray(arr1);
        quickSort(arr1);
        System.out.println("Sorted Array 1:");
        printArray(arr1);

        // Test Case 2: Already sorted array
        int[] arr2 = {1, 2, 3, 4, 5};
        System.out.println("\nOriginal Array 2 (Already Sorted):");
        printArray(arr2);
        quickSort(arr2);
        System.out.println("Sorted Array 2:");
        printArray(arr2);

        // Test Case 3: Array with duplicates
        int[] arr3 = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5};
        System.out.println("\nOriginal Array 3 (With Duplicates):");
        printArray(arr3);
        quickSort(arr3);
        System.out.println("Sorted Array 3:");
        printArray(arr3);
    }
}