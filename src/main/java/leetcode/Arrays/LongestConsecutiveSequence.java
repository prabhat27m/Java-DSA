package src.main.java.leetcode.Arrays;

import java.util.HashSet;

public class LongestConsecutiveSequence {
    public int solve(int[] nums){
       HashSet<Integer> set = new HashSet<>();

        int res=0;

        for(int num : nums){
            set.add(num);
        }

        for(int num : nums){
            int currSequence = 1;
            int previousSequence = num -1 ;
            int nextSequence = num + 1;

            while(set.remove(previousSequence--)){
                currSequence++;
            }

            while(set.remove(nextSequence ++ )){
                currSequence++;
            }

            res = Math.max(res, currSequence);
        }

        return res;
    }
    public static void main(String[] args) {

        LongestConsecutiveSequence sol = new LongestConsecutiveSequence();

        // 1. Test Case 1
        int [] nums1 = new int[]{100, 4, 200, 1, 3, 2};
        System.out.println(sol.solve(nums1));

        // 1. Test Case 2
        int [] nums2 = new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        System.out.println(sol.solve(nums2));
    }
}
