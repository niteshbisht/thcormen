package io.nitesh.arrays;

public class RotateArray {
  static void rotateArray1(int[] arr, int k) {

    int n = arr.length;
    k = k % n;
    int temp, previous;
    for (int i = 0; i < k; i++) {
      previous = arr[n - 1];
      for (int j = 0; j < n; j++) {
        temp = arr[j];
        arr[j] = previous;
        previous = temp;
      }
    }
  }

  static void rotateV2(int[] arr, int k) {
    int[] copyArray = new int[arr.length];
    for (int i = 0; i < arr.length; i++) {
      copyArray[(i + k) % arr.length] = arr[i];
    }
    for (int i = 0; i < arr.length; i++) {
      arr[i] = copyArray[i];
    }
  }

  public static void main(String[] args) {
    int[] arr = new int[] {8, 7, 6, 5, 4, 2, 3, 1};
    rotateArray1(arr, 3);
  }
}
