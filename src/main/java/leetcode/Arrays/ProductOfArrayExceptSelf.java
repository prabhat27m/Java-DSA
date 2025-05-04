package src.main.java.leetcode.Arrays;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    public int[] solve(int [] nums){
        int n = nums.length;
        int [] res = new int[n];

        int [] right = new int[n];
        int [] left = new int[n];

        right[n-1] = nums[n-1];
        left[0] = nums[0];

        for(int i=1; i< n; i++){
           left[i] = left[i-1] * nums[i];
        }

        for(int i= n-2; i>=0; i--){
            right[i] = right[i+1]*nums[i];
        }

        res[0] = right[1];
        res[n-1] = left[n-2];

        for(int i=1; i<n-1;i++){
            res[i] = left[i-1] * right[i+1];
        }

        return res;
    }
    public static void main(String[] args) {
        ProductOfArrayExceptSelf sol = new ProductOfArrayExceptSelf();
        // Test Case 1:
        int[] nums1 = new int[]{1,2,3,4};
        int [] res1 = sol.solve(nums1);

        System.out.println(Arrays.toString(res1));
    }
}
