package src.main.java.basic.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class TwoDimentionalArrayListOperations {
    ArrayList<ArrayList<Integer>> dp = new ArrayList<>(Collections.nCopies(4, new ArrayList<>(Collections.nCopies(5, -1))));

    public static void main(String[] args) {
        int rows = 5, cols =6;
        int [][] dp2 = new int[rows][cols];

        for(int[] row : dp2){
            Arrays.fill(row, -1);
        }

        for(int row=0; row < rows; row++){
            for (int col =0; col < cols; col++ ){
                System.out.print(dp2[row][col]+ " ");
            }
            System.out.println();
        }
    }
}
