package app.algo.easy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ClimbStairs {

    int climb(int n) {
        return climbStairs(0, n);
    }

    int climbStairs(int i, int n) {
        if (i > n) return 0;
        if (i == n) return 1;
        int val = climbStairs(i + 1, n) + climbStairs(i + 2, n);
        return val;
    }

    int climbStairsWithMemoization(int n) {
        int[] memo = new int[n + 1];
        return memoizationBased(0, n, memo);
    }

    private int memoizationBased(int i, int n, int[] memo) {
        if (i > n) return 0;
        if (i == n) return 1;
        if (memo[i] > 0) return memo[i];
        memo[i] = memoizationBased(i + 1, n, memo) + memoizationBased(i + 2, n, memo);
        return memo[i];
    }

    public static void main(String[] args) {
        ClimbStairs cl = new ClimbStairs();
        // System.out.println(cl.climb(3));
        log.info("value {}", cl.climbStairsWithMemoization(3));
    }
}
