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

  static int[] merge(int[] arr1, int[] arr2) {
    int len = arr1.length + arr2.length;
    int m = arr1.length - 1;
    int n = arr2.length - 1;
    int[] mergedArray = new int[len];
    for (int i = len - 1; i >= 0; ) {
      if (m >= 0 && n >= 0) {
        if (arr1[m] > arr2[n]) {
          mergedArray[i] = arr1[m];
          m--;
          i--;
        } else if (arr1[m] < arr2[n]) {
          mergedArray[i] = arr2[n];
          n--;
          i--;
        } else {
          mergedArray[i] = arr1[m];
          m--;
          i--;
          mergedArray[i] = arr2[n];
          n--;
          i--;
        }
      } else if (m >= 0 && n < 0) {
        mergedArray[i] = arr1[m];
        i--;
        m--;
      } else if (n >= 0 && m < 0) {
        mergedArray[i] = arr2[n];
        i--;
        n--;
      }
    }
    return mergedArray;
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

  public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
    if (nums2.length < nums1.length) {
      return findMedianSortedArrays(nums2, nums1);
    }
    return helper(nums1, 0, nums1.length, nums2);
  }

  private static double helper(int[] nums1, int l, int h, int[] nums2) {
    while (l <= h) {
      int m1 = l + (h - l) / 2; // # of elements on left in nums1
      int m2 = (nums2.length + nums1.length + 1) / 2 - m1; // # of elements on left in nums2
      if (m1 > 0 && m2 < nums2.length && nums1[m1 - 1] > nums2[m2]) // m1 needs to reduced
      {
        h = m1 - 1;
      } else if (m2 > 0
          && m1 < nums1.length
          && nums2[m2 - 1] > nums1[m1]) { // m1 needs to be increased
        l = m1 + 1;
      } else {
        int total = nums1.length + nums2.length;
        int maxLeft = -Integer.MAX_VALUE;
        if (m1 > 0) {
          maxLeft = Math.max(maxLeft, nums1[m1 - 1]);
        }
        if (m2 > 0) {
          maxLeft = Math.max(maxLeft, nums2[m2 - 1]);
        }
        if (total % 2 != 0) {
          return maxLeft;
        }
        int minRight = Integer.MAX_VALUE;
        if (m1 < nums1.length) {
          minRight = Math.min(minRight, nums1[m1]);
        }
        if (m2 < nums2.length) {
          minRight = Math.min(minRight, nums2[m2]);
        }
        return (maxLeft + minRight) / 2.0;
      }
    }
    return 0;
  }

  public static void main(String[] args) {
    final int[] nums1 = {1, 2, 3, 4, 7, 10};
    final int[] nums2 = {2, 5, 6, 8, 9, 11, 13, 15};
    double medianSortedArrays = findMedianSortedArrays(nums1, nums2);
    System.out.println(medianSortedArrays);
  }
}
