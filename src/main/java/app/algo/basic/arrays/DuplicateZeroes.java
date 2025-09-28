package app.algo.basic.arrays;

import java.util.Arrays;

public class DuplicateZeroes {
  public static void duplicateZeros(int[] arr) {
    int possibleDupes = 0;
    int length_ = arr.length - 1;

    // Find the number of zeros to be duplicated
    // Stopping when left points beyond the last element in the original array
    // which would be part of the modified array
    for (int left = 0; left <= length_ - possibleDupes; left++) {

      // Count the zeros
      if (arr[left] == 0) {

        // Edge case: This zero can't be duplicated. We have no more space,
        // as left is pointing to the last element which could be included
        if (left == length_ - possibleDupes) {
          // For this zero we just copy it without duplication.
          arr[length_] = 0;
          length_ -= 1;
          break;
        }
        possibleDupes++;
      }
    }

    // Start backwards from the last element which would be part of new array.
    int last = length_ - possibleDupes;

    // Copy zero twice, and non zero once.
    for (int i = last; i >= 0; i--) {
      if (arr[i] == 0) {
        arr[i + possibleDupes] = 0;
        possibleDupes--;
        arr[i + possibleDupes] = 0;
      } else {
        arr[i + possibleDupes] = arr[i];
      }
    }
  }

  public static void main(String[] args) {
    int[] arr = {1, 0, 2, 3, 0, 4, 5, 0};
    duplicateZeros(arr);
    System.out.println(Arrays.toString(arr));
  }
}
