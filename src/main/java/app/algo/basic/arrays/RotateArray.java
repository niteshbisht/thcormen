package app.algo.basic.arrays;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
public class RotateArray {
  // approach one
  public static int[] rotate1(int[] nums, int k) {
    // speed up the rotation
    k %= nums.length;
    int temp, previous;
    for (int i = 0; i < k; i++) {
      previous = nums[nums.length - 1];
      for (int j = 0; j < nums.length; j++) {
        temp = nums[j];
        nums[j] = previous;
        previous = temp;
      }
    }
    return nums;
  }

  // extra space
  public static int[] rotate2(int[] nums, int k) {
    int[] a = new int[nums.length];
    for (int i = 0; i < nums.length; i++) {
      a[(i + k) % nums.length] = nums[i];
    }
    for (int i = 0; i < nums.length; i++) {
      nums[i] = a[i];
    }
    return nums;
  }

  // mathematical rotations
  public static int[] rotate3(int[] nums, int k) {
    k = k % nums.length;
    int count = 0;
    for (int start = 0; count < nums.length; start++) {
      int currentIdx = start;
      int prev = nums[start];
      do {
        int nextIdx = (currentIdx + k) % nums.length;
        int temp = nums[nextIdx];
        nums[nextIdx] = prev;
        prev = temp;
        currentIdx = nextIdx;
        count++;
      } while (start != currentIdx);
    }
    return nums;
  }

  public static int[] rotate4(int[] nums, int k) {
    if (nums.length <= 1) {
      return nums;
    }
    // step each time to move
    int step = k % nums.length;
    // find GCD between nums length and step
    int gcd = findGcd(nums.length, step);
    int position, count;

    // gcd path to finish movie
    for (int i = 0; i < gcd; i++) {
      // beginning position of each path
      position = i;
      // count is the number we need swap each path
      count = nums.length / gcd - 1;
      for (int j = 0; j < count; j++) {
        position = (position + step) % nums.length;
        // swap index value in index i and position
        nums[i] ^= nums[position];
        nums[position] ^= nums[i];
        nums[i] ^= nums[position];
      }
    }
    return nums;
  }

  public static int findGcd(int a, int b) {
    return (a == 0 || b == 0) ? a + b : findGcd(b, a % b);
  }

  public static int[] rotate5(int[] nums, int k) {
    k %= nums.length;
    reverse(nums, 0, nums.length - 1);
    reverse(nums, 0, k - 1);
    reverse(nums, k, nums.length - 1);
    return nums;
  }

  public static void reverse(int[] nums, int start, int end) {
    while (start < end) {
      int temp = nums[start];
      nums[start] = nums[end];
      nums[end] = temp;
      start++;
      end--;
    }
  }

  public static void main(String[] args) {
    int[] arr = new int[] {1, 2, 3, 4, 5, 6};
    // log.info(Arrays.toString(rotate1(Arrays.copyOf(arr, arr.length), 3)));
    // log.info(Arrays.toString(rotate2(Arrays.copyOf(arr, arr.length), 3)));
    log.info(Arrays.toString(rotate4(Arrays.copyOf(arr, arr.length), 2)));
  }
}
