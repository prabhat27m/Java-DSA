package src.main.java.leetcode.TwoPointer;

public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1, area = Integer.MIN_VALUE;

        while (i < j) {
            if (height[j] >= height[i]) {
                area = Math.max(area, height[i] * (j - i));
                i++;
            } else {
                area = Math.max(area, height[j] * (j - i));
                j--;
            }
        }

        return area;
    }

    public static void main(String[] args) {
        ContainerWithMostWater solver = new ContainerWithMostWater();

        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int result = solver.maxArea(height);

        System.out.println("Maximum water area: " + result);
    }
}
