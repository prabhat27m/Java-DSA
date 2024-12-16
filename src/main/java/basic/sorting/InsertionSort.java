package src.main.java.basic.sorting;

import java.util.Scanner;

public class InsertionSort {
    private
    final int size;
    int[] arr;

    InsertionSort(int size) {
        this.size = size;
        arr = new int[size];
    }

    public int getSize() {
        return this.size;
    }

    void InsertArray() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the values of the array:");
        for (int i = 0; i < size; i++) {
            int ele = scanner.nextInt();
            arr[i] = ele;
        }
    }

    void printArray() {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }


    void Sort() {
        for (int i = 0; i < arr.length; i++) {
            int ele = arr[i];
            int ind = i;
            // keep shifting
            while (ind > 0 && ele < arr[ind - 1]) {
                arr[ind] = arr[ind-1];
                ind--;
            }
            arr[ind] = ele;
        }
    }
}
