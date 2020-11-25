package app.algo.leetcode.backtrak;

public class Solution {
    boolean isSafe(int[][] arr, int row, int col, int n) {
        int i, j;
        // check row
        for (i = 0; i < col; i++) {
            if (arr[row][i] == 1) {
                return false;
            }
        }

        // check upper diagonal on left side
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (arr[i][j] == 1) {
                return false;
            }
        }

        // check lower diagonal on left side
        for (i = row, j = col; i < n && j >= 0; i++, j--) {
            if (arr[i][j] == 1)
                return false;
        }
        return true;
    }

    int nQueenUtil(int[][] arr, int col, int n, int count) {
        if (col == n) {
            // printSolution(arr);
            count++;
        }

        // for all rows in this column check is safe
        for (int i = 0; i < n; i++) {
            // if is safe for this row and col combination mark queen
            if (isSafe(arr, i, col, n)) {
                arr[i][col] = 1;
                // check for next col in this
                count = nQueenUtil(arr, col + 1, n, count);
                arr[i][col] = 0;
            }
        }
        return  count;
    }

    public int totalNQueens(int n) {
        int[][] arr = new int[n][n];
        return nQueenUtil(arr, 0, n, 0);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.totalNQueens(1));
    }
}
