package src.main.java.basic.binarysearch;

import java.awt.*;
import java.util.Scanner;

public class Introduction {

    public String binarysearch(int[] arr, int target){
        int lo = 0;
        int hi = arr.length - 1;

        while(lo <= hi){
            int mid = (lo+ hi)/ 2;

            if(arr[mid] == target){
                return "found";
            }
            else if(arr[mid] > target){
                hi = mid - 1;
            }else{
                lo = mid + 1;
            }
        }

        return "not found";
    }

    public String recbinarysearch(int[] arr, int lo, int hi,  int target) {
        if (lo > hi) return "not found";

        int mid = (lo + hi) / 2;

        if (arr[mid] == target) {
            return "found";
        } else if (arr[mid] > target) {
            return recbinarysearch(arr, lo, mid - 1, target);
        }
            return recbinarysearch(arr, mid + 1, hi, target);

        }


    public static void main(String[] args) {
        Introduction sol = new Introduction();
//        int [] arr = new int[]{5,8, 11, 32, 45, 69, 70, 99};
//
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements");
        n = sc.nextInt();
        int [] arr= new int[n];
        int ind =0;

        while(n-- > 0){
            System.out.println("Enter " + ind +"th element");
            int ele = sc.nextInt();
            arr[ind++] = ele;
        }

        System.out.println(sol.binarysearch(arr, 99));
        System.out.println(sol.binarysearch(arr, 5));
        System.out.println(sol.binarysearch(arr, 69));
        System.out.println(sol.binarysearch(arr, 100));
        System.out.println(sol.binarysearch(arr, 4));
        System.out.println(sol.recbinarysearch(arr, 0, arr.length-1, 99));
        System.out.println(sol.recbinarysearch(arr, 0, arr.length-1, 5));
        System.out.println(sol.recbinarysearch(arr, 0, arr.length-1, 69));
        System.out.println(sol.recbinarysearch(arr, 0, arr.length-1, 100));
        System.out.println(sol.recbinarysearch(arr, 0, arr.length-1, 4));

    }


}