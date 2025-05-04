package src.main.java.basic.slidingwindow.fixedwindow;
import  java.util.*;

public class FirstNegativeInWindow {
    public static List<Integer>firstNegativeInWindow(int [] arr, int k){
        List<Integer> res = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        int i=0, j=0;
        while (j< arr.length) {
            // insert all the negative elements
            if(arr[j]<0){
                queue.offer(j);
            }

            if(j - i + 1 ==k){
                while (!queue.isEmpty() && queue.peek() < i){
                    queue.poll();
                }

                res.add(queue.isEmpty() ? 0: arr[queue.peek()]);

                i++;
            }
            j++;
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr1 = {12, -1, -7, 8, -15, 30, 16, 28};
        int k1 = 3;
        System.out.println("Test Case 1:");
        System.out.println("Array: " + Arrays.toString(arr1));
        System.out.println("Window size: " + k1);
        System.out.println("Result: " + firstNegativeInWindow(arr1, k1));
        // Output: [-1, -1, -7, -15, -15, 0]

        int[] arr2 = {-8, 2, 3, -6, 10};
        int k2 = 2;
        System.out.println("\nTest Case 2:");
        System.out.println("Array: " + Arrays.toString(arr2));
        System.out.println("Window size: " + k2);
        System.out.println("Result: " + firstNegativeInWindow(arr2, k2));
        // Output: [-8, 0, -6, -6]

        // Additional test case with all positive numbers
        int[] arr3 = {1, 2, 3, 4, 5};
        int k3 = 2;
        System.out.println("\nTest Case 3 (All Positive):");
        System.out.println("Array: " + Arrays.toString(arr3));
        System.out.println("Window size: " + k3);
        System.out.println("Result: " + firstNegativeInWindow(arr3, k3));
    }
}
