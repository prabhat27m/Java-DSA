package src.main.java.basic.sorting;

import java.util.Scanner;

public class SelectionSort {
    private
    final int size;
    int [] arr;
    SelectionSort(int size){
        this.size = size;
        arr = new int[size];
    }

    public
    int getSize(){
        return this.size;
    }

    void InsertArray(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the values of the array:");
        for(int i=0; i<size; i++){
            int ele = scanner.nextInt();
            arr[i]  = ele;
        }
    }

    void printArray(){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }


    void Sort(){
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if(arr[i] > arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

}
