package app.algo.easy;

import java.util.Arrays;

public class MergeSortedArrays {
  public static void merge(int[] nums1, int m, int[] nums2, int n) {
    int[] copyArray = Arrays.copyOfRange(nums1, 0, m);
    int p1 = 0, p2 = 0;
    for (int p = 0; p < m + n; p++) {
      if (p2 >= n || (p1 < m && copyArray[p1] < nums2[p2])) {
        nums1[p] = copyArray[p1++];
      } else {
        nums1[p] = nums2[p2++];
      }
    }
  }

  static void mergeFromEnd(int[] nums1, int m, int[] nums2, int n) {
    // Set p1 and p2 to point to the end of their respective arrays.
    int p1 = m - 1;
    int p2 = n - 1;

    // And move p backwards through the array, each time writing
    // the smallest value pointed at by p1 or p2.
    for (int p = m + n - 1; p >= 0; p--) {
      if (p2 < 0) {
        break;
      }
      if (p1 >= 0 && nums1[p1] > nums2[p2]) {
        nums1[p] = nums1[p1--];
      } else {
        nums1[p] = nums2[p2--];
      }
    }
  }

  public static void main(String[] args) {
    int[] nums1 = {1, 2, 3, 0, 0, 0};
    int m = 3;
    int[] nums2 = {2, 5, 6};
    int n = 3;
    mergeFromEnd(nums1, m, nums2, n);
    System.out.println(Arrays.toString(nums1));
  }
}
