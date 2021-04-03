package app.algo.basic.sort;

import app.algo.util.AlgoUtils;

public class SelectionSort {
    void sort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int min_idx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min_idx]) {
                    min_idx = j;
                }
            }
            if (min_idx != i) {
                AlgoUtils.swap(arr, min_idx, i);
            }
        }
    }
}
