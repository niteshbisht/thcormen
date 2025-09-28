package app.algo.basic.sort;

import app.algo.util.AlgoUtils;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BubbleSort {
  public static void main(String[] args) {
    var bs = new BubbleSort();
    bs.sort(new int[] {2, 1, 3, 4, 9, 0, 11});
  }

  void sort(int[] arr) {
    int n = arr.length;
    for (int i = 0; i < n - 1; i++) {
      for (int j = 0; j < n - i - 1; j++) {
        if (arr[j] > arr[j + 1]) {
          AlgoUtils.swap(arr, j, j + 1);
        }
      }
    }
    log.info("Array After Sort {}", arr);
  }
}
