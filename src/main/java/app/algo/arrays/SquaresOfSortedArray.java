package app.algo.arrays;

public class SquaresOfSortedArray {
  public static int[] sortedSquares(int[] nums) {
    int len = nums.length;
    int left = 0, right = len - 1;
    int[] res = new int[len];
    for (int i = len - 1; i >= 0; i--) {
      int square;
      if (Math.abs(nums[right]) > Math.abs(nums[left])) {
        square = nums[right--];
      } else {
        square = nums[left++];
      }
      res[i] = square * square;
    }
    return res;
  }

  public static void main(String[] args) {
    
  }
}
