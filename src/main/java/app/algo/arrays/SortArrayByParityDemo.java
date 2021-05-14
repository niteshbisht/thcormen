package app.algo.arrays;

import app.algo.util.AlgoUtils;

import java.util.Arrays;

public class SortArrayByParityDemo {
  static void sortArrayByParity(int[] A) {
    int startIndex = 0;
    for (int i = A.length - 1; i > 0 && i >= startIndex; ) {
      if (A[i] % 2 == 0 && A[startIndex] % 2 != 0) {
        AlgoUtils.swap(A, i, startIndex);
        startIndex++;
        i--;
        continue;
      }
      if (A[i] % 2 != 0) {
        i--;
      }
      if (A[startIndex] % 2 == 0) {
        startIndex++;
      }
    }
  }

  public static void main(String[] args) {
    int[] arr = new int[] {3, 1, 2, 4};
    int[] arrSorted = Arrays.copyOf(arr, arr.length);
    Arrays.sort(arrSorted);
    sortArrayByParity(arr);
    System.out.println(Arrays.toString(arr));
  }
}
