package app.algo.basic.backtracking;

import java.util.HashMap;

public class CanSumSolution {

  public static void main(String[] args) {
    CanSumSolution cs = new CanSumSolution();
    long t1 = System.nanoTime();
    System.out.println(cs.canSum(7, new int[] {3, 4, 2, 5}, new HashMap<>()));
    long t2 = System.nanoTime();
    System.out.println(t2 - t1);
    System.out.println(cs.canSum(308, new int[] {3, 7}, new HashMap<>()));
    System.out.println(System.nanoTime() - t2);
  }

  boolean canSum(int target, int[] arr, HashMap<Integer, Boolean> memoizationMap) {
    if (target == 0) {
      memoizationMap.put(target, true);
      return true;
    }
    if (target < 0) {
      memoizationMap.put(target, false);
      return false;
    }
    for (int p : arr) {
      int remainder = target - p;
      if (canSum(remainder, arr, memoizationMap)) {
        memoizationMap.put(target, true);
        return true;
      }
    }
    memoizationMap.put(target, false);
    return false;
  }
}
