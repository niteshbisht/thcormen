package app.algo.basic.sort;

import java.util.Random;

public class RandomizedQuickSort extends QuickSort {
  public void randomQuickSort(int[] arr, int p, int r) {
    if (p < r) {
      int q = randomPartition(arr, p, r);
      randomQuickSort(arr, p, q - 1);
      randomQuickSort(arr, q + 1, r);
    }
  }

  int randomPartition(int[] arr, int p, int r) {
    Random rand = new Random();
    int i = p + rand.nextInt((r - p) + 1);
    exchange(arr, i, r);
    return partition(arr, p, r);
  }
}
