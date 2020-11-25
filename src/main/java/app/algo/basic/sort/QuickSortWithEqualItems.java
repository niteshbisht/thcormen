package app.algo.basic.sort;

import static app.algo.util.AlgoUtils.*;

public class QuickSortWithEqualItems {
    public void sort(int[] arr, int p, int r) {
        if (p < r) {
            int[] pivots = partition(arr, p, r);
            sort(arr, p, pivots[0] - 1);
            sort(arr, p, pivots[1] + 1);
        }
    }

    int[] partition(int[] arr, int p, int r) {
        int high = p;
        int low = p;
        int x = arr[p];
        for (int j = p + 1; j < r; j++) {
            if (arr[j] < x) {
                swap(arr, high + 1, low);
                high++;
                low++;
            } else if (arr[j] == x) {
                swap(arr, high + 1, j);
                high++;
            }
        }
        return new int[]{low, high};
    }

}
