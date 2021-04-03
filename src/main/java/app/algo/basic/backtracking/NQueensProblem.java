package app.algo.basic.backtracking;

public class NQueensProblem {
    static int N = 4;
    static int k = 1;

    /* A utility function to print solution */
    static void printSolution(int board[][]) {
        System.out.printf("%d-\n", k++);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) System.out.printf(" %d ", board[i][j]);
            System.out.printf("\n");
        }
        System.out.printf("\n");
    }

    static boolean isSafe(int[][] arr, int row, int col) {
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
        for (i = row, j = col; i < N && j >= 0; i++, j--) {
            if (arr[i][j] == 1) return false;
        }
        return true;
    }

    static boolean nQueenUtil(int[][] arr, int col) {
        if (col == N) {
            printSolution(arr);
            return true;
        }
        boolean res = false;
        // for all rows in this column check is safe
        for (int i = 0; i < N; i++) {
            // if is safe for this row and col combination mark queen
            if (isSafe(arr, i, col)) {
                arr[i][col] = 1;
                // check for next col in this
                res = nQueenUtil(arr, col + 1) || res;
                arr[i][col] = 0;
            }
        }
        return res;
    }

    static void solve() {
        int[][] arr = new int[N][N];
        // Arrays.fill(arr, 0);
        if (nQueenUtil(arr, 0) == false) {
            System.out.println("Solution does not exist");
        }
    }

    public static void main(String[] args) {
        solve();
    }
}
