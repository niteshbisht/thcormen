package app.algo.arrays;

import java.util.Arrays;

public class MoveZeroes {

  static void moveZeroes(int[] nums) {
    int lastNonzero = 0, cur = 0;
    for (cur = 0; cur < nums.length; cur++) {
      if (nums[cur] != 0) {
        int temp = nums[cur];
        nums[cur] = nums[lastNonzero];
        nums[lastNonzero] = temp;
        lastNonzero++;
      }
    }
    for (int i = lastNonzero; i < nums.length; i++) {
      nums[i] = 0;
    }
  }

  public static void main(String[] args) {
    int[] arr = {0, 1, 0, 3, 12};
    moveZeroes(arr);
    System.out.println(Arrays.toString(arr));
  }
}
