package app.algo.arrays;

import java.util.Arrays;

public class RotateArray {
  public static void rotate(int[] nums, int k) {
    int previous, temp;
    k = k % nums.length;
    for (int i = 0; i < k; i++) {
      previous = nums[nums.length - 1];
      for (int j = 0; j < nums.length; j++) {
        temp = nums[j];
        nums[j] = previous;
        previous = temp;
      }
    }
    Arrays.stream(nums).forEach(System.out::print);
    System.out.println();
  }

  public static void rotate2(int[] nums, int k) {
    int[] a = new int[nums.length];
    for (int i = 0; i < nums.length; i++) {
      a[(i + k) % nums.length] = nums[i];
    }
    for (int i = 0; i < nums.length; i++) {
      nums[i] = a[i];
    }
    Arrays.stream(nums).forEach(System.out::print);
    System.out.println();
  }

  public static void reverseArray(int arr[], int start, int end) {
    while (start < end) {
      int temp = arr[start];
      arr[start] = arr[end];
      arr[end] = temp;
      start++;
      end--;
    }
  }

  public static void rotate3(int input[], int k) {
    int n = input.length;
    k = k % n;
    reverseArray(input, 0, k - 1);
    reverseArray(input, k, n - 1);
    reverseArray(input, 0, n - 1);
  }

  public static void main(String[] args) {
    int[] iput = {1, 2, 3, 4, 5, 6, 7};
    //    rotate(iput.clone(), 3);
    //    rotate2(iput.clone(), 3);
    rotate3(iput, 3);
    System.out.println(Arrays.toString(iput));
  }
}
