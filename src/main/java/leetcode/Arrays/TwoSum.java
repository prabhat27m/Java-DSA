package src.main.java.leetcode.Arrays;

import java.util.HashMap;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }

            map.put(nums[i], i);
        }

        return new int[]{};
    }

    public static void main(String[] args) {
        TwoSum sol = new TwoSum();

        // Test Case 1:
        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;
        int[] res1 = sol.twoSum(nums1, target1);
        System.out.println("Two Sum indices: [" + res1[0] + ", " + res1[1] + "]");

        // Test Case 2:
        int[] nums2 = {3, 2, 4};
        int target2 = 6;
        int[] res2 = sol.twoSum(nums2, target2);
        System.out.println("Two Sum indices: [" + res2[0] + ", " + res2[1] + "]");

        // Test Case 3:
        int[] nums3 = {3, 3};
        int target3 = 6;
        int[] res3 = sol.twoSum(nums3, target3);
        System.out.println("Two Sum indices: [" + res3[0] + ", " + res3[1] + "]");
    }

}