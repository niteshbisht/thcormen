package app.algo.basic.sort;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class QuickSort {

    public void quickSort(int[] arr, int p, int r) {
        if (p < r) {
            int q = partition(arr, p, r);
            quickSort(arr, p, q - 1);
            quickSort(arr, q + 1, r);
        }
    }

    public void quickSortHoares(int[] arr, int p, int r) {
        if (p < r) {
            int pivot = (p + r) / 2;
            int index = hoaresPartition(arr, p, r, pivot);
            quickSortHoares(arr, p, index - 1);
            quickSortHoares(arr, index, r);
        }
    }

    public int partition(int[] arr, int p, int r) {
        int x = arr[r];
        int i = p - 1;
        for (int j = p; j < r; j++) {
            if (arr[j] < x) {
                i++;
                if (i != j) {
                    exchange(arr, i, j);
                }
            }
        }
        exchange(arr, i + 1, r);
        return i + 1;
    }

    int hoaresPartition(int[] arr, int left, int right, int pivot) {
        while (left < right) {
            while (arr[left] < pivot) {
                left++;
            }
            while (arr[right] > pivot) {
                right--;
            }
            if (left < right) {
                exchange(arr, left, right);
            }
        }
        return left;
    }

    void exchange(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    void tailrecQuickSort(int[] arr, int p, int r) {
        while (p < r) {
            int pivot = partition(arr, p, r);
            tailrecQuickSort(arr, p, pivot - 1);
            p = pivot + 1;
        }
    }

    void quickSortWithLessStack(int[] arr, int p, int r) {
        if (p < r) {
            int pivot = partition(arr, p, r);
            if (pivot < Math.floor(p + r / 2)) {
                quickSortWithLessStack(arr, p, pivot - 1);
            } else {
                quickSortWithLessStack(arr, pivot + 1, r);
            }
        }
    }

}
