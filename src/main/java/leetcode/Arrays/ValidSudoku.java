package src.main.java.leetcode.Arrays;

import java.util.*;

public class ValidSudoku {

    public boolean checkRow(char[][] board, int row , int col, int target) {
        for(int i=0; i< 9 ; i++){
            if(board[i][col] == target && row != i){
                return true;
            }
        }

        return false;
    }

    public boolean checkCol(char[][] board, int row , int col, int target) {
        for(int i=0; i< 9 ; i++){
            if(board[row][i] == target && col != i){
                return true;
            }
        }

        return false;
    }

    public boolean checkDiagonal(char[][] board , int row, int col, int target) {
        int currRow = 3 * (row/3);
        int currCol = 3 * (col/3);

        for (int k = 0; k < 9; k++) {
            int nextR = currRow + k / 3;
            int nextC = currCol + k % 3;

            if (board[nextR][nextC] == target && (nextR != row || nextC != col)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ValidSudoku sol = new ValidSudoku();

        char[][] board = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') continue;

                if (sol.checkRow(board, i, j, board[i][j]) || sol.checkCol(board, i, j, board[i][j])
                        || sol.checkDiagonal(board, i, j, board[i][j])) {
                    System.out.println("Not Valid Sudoku");
                }

            }
        }
        System.out.println("Valid Sudoku");

    }
}
