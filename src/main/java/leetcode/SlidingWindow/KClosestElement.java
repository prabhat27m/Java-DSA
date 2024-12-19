package src.main.java.leetcode.SlidingWindow;

import java.util.ArrayList;
import java.util.List;

public class KClosestElement {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer>res = new ArrayList<Integer>();
        int n = arr.length;
        int start =0;
        long min = (long)1e9;
        int left =0, right =0;
        long sum =0;

        for(int i =0 ; i < n ; i++){
            sum += Math.abs(arr[i] - x);

            while(i-start + 1 > k){
                sum -= Math.abs(arr[start++] - x);
            }

            if(i-start + 1 == k && sum < min){
                sum = min;
                left = start;
                right = i;
            }

        }

        for(int i=left;i<=right;i++){
            res.add(arr[i]);
        }

        return res;
    }

    public static void main(String[] args) {
        int [] arr = {1,2,3,4,5};
        KClosestElement sol = new KClosestElement();
        System.out.println(sol.findClosestElements(arr, 4,3));
    }
}
