package src.main.java.basic.dynamicprogramming;
import java.util.*;

public class FrogJump {
    public int solve(int ind, int[]heights, int[] dp){
        if(ind == 0) return 0;
        if(dp[ind]!= -1) return dp[ind];
        int jumpOne = Math.abs(heights[ind] - heights[ind-1]) +solve(ind -1 , heights, dp);
        int jumpTwo = Integer.MAX_VALUE;
        if(ind >1) {jumpTwo = Math.abs(heights[ind] - heights[ind-2])+ solve(ind -2, heights, dp);}

        return dp[ind] = Math.min(jumpOne, jumpTwo);
    }

    public static void main(String[] args) {
        FrogJump solution = new FrogJump();
        int []heights={30,10,60,10,60,50};
        int n = heights.length;
        int[]dp = new int[n];
        Arrays.fill(dp, -1);
        int res = solution.solve(n-1, heights, dp);
        System.out.println(res);
    }
}
