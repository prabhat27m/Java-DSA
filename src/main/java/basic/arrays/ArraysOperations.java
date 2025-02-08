package src.main.java.basic.arrays;

import java.util.Arrays;
import java.util.Scanner;

public class ArraysOperations {
    public static void main(String[] args){
        int [] arr = new int[7];



//        System.out.println("Enter the values in the array:");
//        Scanner scanner = new Scanner(System.in);
//        for(int i=0; i< arr.length; i++){
//            arr[i] = scanner.nextInt();
//        }
//
//        for(int i=0; i< arr.length; i++){
//            System.out.println(arr[i]);
//        }


        int [][] twoDArray = {{5,8},{2,4}};

        Arrays.sort(twoDArray, (a, b)-> a[0] - b[0]);

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(twoDArray[i][j] + " ");
            }
            System.out.println();
        }


    }
}
