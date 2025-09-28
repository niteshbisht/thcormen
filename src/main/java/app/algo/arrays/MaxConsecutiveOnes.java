package app.algo.arrays;

public class MaxConsecutiveOnes {
  public static int maxConsecutiveOnes(int[] nums) {
    if (nums == null) return 0;
    int max = Integer.MIN_VALUE;
    int counter = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == 0) {
        counter = 0;
      } else {
        counter++;
      }
      max = Math.max(max, counter);
    }
    return max;
  }

  public static void main(String[] args) {
    int max = maxConsecutiveOnes(new int[] {1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0});
    System.out.println(max);
  }
}
