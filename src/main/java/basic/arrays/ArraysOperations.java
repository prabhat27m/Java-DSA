package src.main.java.basic.arrays;

import java.util.Scanner;

public class ArraysOperations {
    public static void main(String[] args){
        int [] arr = new int[7];
        System.out.println("Enter the values in the array:");
        Scanner scanner = new Scanner(System.in);
        for(int i=0; i< arr.length; i++){
            arr[i] = scanner.nextInt();
        }

        for(int i=0; i< arr.length; i++){
            System.out.println(arr[i]);
        }
    }
}
