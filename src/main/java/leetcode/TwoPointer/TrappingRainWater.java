package src.main.java.leetcode.TwoPointer;

public class TrappingRainWater {
    public int solve(int[] nums){
        int n = nums.length;
        int low = 0;
        int high = n-1;
        int leftMax = nums[0];
        int rightMax = nums[n-1];
        int res =0;

        while(low < high){
            if(leftMax <= rightMax){
                res += leftMax - nums[low];
                low ++;
                leftMax = Math.max(leftMax, nums[low]);
            }else{
                res += rightMax - nums[high];
                high --;
                rightMax = Math.max(rightMax, nums[high]);
            }
        }

        return res;
    }
    public static void main(String[] args) {
        int []nums = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        TrappingRainWater sol = new TrappingRainWater();

        System.out.println(sol.solve(nums));

    }
}
