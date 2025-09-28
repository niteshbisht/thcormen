package app.algo.arrays;


// import java.util.stream.Collectors;

public class RemoveDupesFromArray {
  static int removeDuplicates(int[] arr) {
    int i = 0;
    int j = 1;
    for (; j < arr.length; j++) {
      if (arr[i] != arr[j]) {
        i++;
        arr[i] = arr[j];
      }
    }
    return i;
  }

  public static int[] remElement(int[] arr, int index) {

    //
    // Overwrite the element at the given index by
    // moving all the elements to the right of the
    // index, one position to the left.
    //
    for (int i = index + 1; i < arr.length; i++) {
      arr[i - 1] = arr[i];
    }
    return arr;
  }

  public static int removeDuplicatesV2(int[] nums) {
    if (nums.length == 0) return 0;
    int idx = 1, counter = 0, len = nums.length;
    while (idx < len) {
      if (nums[idx] == nums[idx - 1]) {
        counter++;
        if (counter > 2) {
          remElement(nums, idx);
          idx--;
          len--;
        }
      } else {
        counter = 1;
      }
    }
    return len;
  }

  public static void main(String[] args) {
    // int[] arr = IntStream.range(0, 90000).toArray();
    // // System.out.println(removeDuplicates(arr));
    // //    removeDuplicatesV2(arr);
    // //    System.out.println(Arrays.toString(arr));

    // List<Integer> collect = Arrays.stream(arr).boxed().collect(Collectors.toList());
    // collect.parallelStream()
    //     .forEach(
    //         item -> {
    //           System.out.println(
    //               "Thread => " + Thread.currentThread().getName() + " value = " + item);
    //         });
    int[] arr = {1,1,1,1,2,3,3};
    removeDuplicatesV3(arr);
    //removeDupesLeetSol(arr);
  }

  static int removeDuplicatesV3(int[] nums) {
    //
    // Initialize the counter and the second pointer.
    //
    int j = 1, count = 1;

    //
    // Start from the second element of the array and process
    // elements one by one.
    //
    for (int i = 1; i < nums.length; i++) {

      //
      // If the current element is a duplicate, increment the count.
      //
      if (nums[i] == nums[i - 1]) {

        count++;

      } else {

        //
        // Reset the count since we encountered a different element
        // than the previous one.
        //
        count = 1;
      }

      //
      // For a count <= 2, we copy the element over thus
      // overwriting the element at index "j" in the array
      //
      if (count <= 2) {
        nums[j++] = nums[i];
      }
    }
    return j;
  }

  public static void removeDupesLeetSol(int arr[]) {
    int i = 1;
    int j = 1;
    int count=1;
    int n = arr.length;
    while (i<n) {
      if(arr[i] == arr[i-1]) {
        count++;
        if(count>2) {
          i++;
          continue;
        }
      } else {
        count = 1;
      }
      arr[j] = arr[i];
      i++;
      j++;
    }
  }
}
