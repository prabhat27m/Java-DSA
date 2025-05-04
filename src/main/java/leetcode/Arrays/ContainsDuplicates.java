package src.main.java.leetcode.Arrays;

import java.util.HashMap;
import java.util.HashSet;

public class ContainsDuplicates {
    public boolean containsDuplicates(int [] arr){
        HashSet<Integer> set = new HashSet<>();

        for(int num : arr){
            if(set.contains(num)){
                return true;
            }
            set.add(num);
        }

        return false;
    }

    public static void main(String[] args) {
        ContainsDuplicates sol = new ContainsDuplicates();
        // Test case 1:
        int []arr1 = new int[]{1,3,3,45};
        System.out.println("Contains Duplicates:" + sol.containsDuplicates(arr1) );

        // Test case 3:
        int []arr3 = new int[]{1,9,3,45};
        System.out.println("Contains Duplicates:" + sol.containsDuplicates(arr3) );
    }
}
