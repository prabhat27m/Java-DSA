package src.main.java.leetcode.TwoPointer;

import java.util.*;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);

        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue; // skip duplicate for i
            }

            int j = i + 1;
            int k = n - 1;

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));

                    j++;
                    while (j < k && nums[j] == nums[j - 1]) j++; // skip duplicate for j

                    k--;
                    while (j < k && nums[k] == nums[k + 1]) k--; // skip duplicate for k
                } else if (sum < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        ThreeSum solver = new ThreeSum();

        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = solver.threeSum(nums);

        System.out.println("Triplets that sum to 0:");
        for (List<Integer> triplet : result) {
            System.out.println(triplet);
        }
    }
}
