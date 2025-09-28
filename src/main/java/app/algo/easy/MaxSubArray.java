package app.algo.easy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MaxSubArray {
  static int maxSubArrayDivConquer(int[] arr) {
    return recursiveMaxSubArray(arr, 0, arr.length - 1);
  }

  static int recursiveMaxSubArray(int[] arr, int start, int end) {
    if (start > end) {
      return Integer.MIN_VALUE;
    }
    int mid = Math.floorDiv(start + end, 2);
    int leftSum = 0, rightSum = 0;
    int currentSum = 0;
    for (int i = mid - 1; i >= 0; i--) {
      currentSum = currentSum + arr[i];
      leftSum = Math.max(currentSum, leftSum);
    }
    currentSum = 0;
    for (int i = mid + 1; i <= end; i++) {
      currentSum = currentSum + arr[i];
      rightSum = Math.max(currentSum, rightSum);
    }
    int bestCombinedSum = arr[mid] + leftSum + rightSum;
    int leftHalf = recursiveMaxSubArray(arr, start, mid - 1);
    int rightHalf = recursiveMaxSubArray(arr, mid + 1, end);
    return Math.max(bestCombinedSum, Math.max(leftHalf, rightHalf));
  }

  public static void main(String[] args) {
    log.info("value = {}", maxSubArrayDivConquer(new int[] {-2, 1, -3, 4, -1, 2, 1, -5, 4}));
  }

  public int maxSubArray(int[] nums) {
    int currentSubArray = nums[0];
    int maxSum = nums[0];
    for (int i = 1; i < nums.length; i++) {
      int num = nums[i];
      currentSubArray = Math.max(num, currentSubArray + num);
      maxSum = Math.max(currentSubArray, maxSum);
    }

    return maxSum;
  }
}
