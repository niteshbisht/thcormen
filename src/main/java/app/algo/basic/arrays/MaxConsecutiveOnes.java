package app.algo.basic.arrays;

public class MaxConsecutiveOnes {
  static int solve(int[] nums) {
    int maxCount = 0, count = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == 1) {
        count++;
      } else {
        maxCount = Math.max(maxCount, count);
        count = 0;
      }
    }
    return maxCount;
  }

  public static void main(String[] args) {
    System.out.println(solve(new int[] {1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1}));
  }
}
