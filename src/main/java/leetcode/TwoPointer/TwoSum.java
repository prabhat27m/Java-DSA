package src.main.java.leetcode.TwoPointer;

import java.util.*;

public class TwoSum {

    public List<List<Integer>> twoSum(int[] nums, int target) {
        Set<Integer> seen = new HashSet<>();
        Set<List<Integer>> resultSet = new HashSet<>();

        for (int num : nums) {
            int complement = target - num;
            if (seen.contains(complement)) {
                List<Integer> pair = Arrays.asList(Math.min(num, complement), Math.max(num, complement));
                resultSet.add(pair);
            }
            seen.add(num);
        }

        return new ArrayList<>(resultSet);
    }

    public static void main(String[] args) {
        TwoSum solver = new TwoSum();

        int[] nums = {2, 7, 11, 15, -2, 9, 1, 8, 0};
        int target = 9;
        List<List<Integer>> result = solver.twoSum(nums, target);

        System.out.println("Pairs that sum to " + target + ":");
        for (List<Integer> pair : result) {
            System.out.println(pair);
        }
    }
}
