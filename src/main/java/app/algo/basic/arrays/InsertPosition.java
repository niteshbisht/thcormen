package app.algo.basic.arrays;

public class InsertPosition {
    public static int searchInsert(int[] nums, int target) {
        int pivot, left = 0, right = nums.length - 1;
        while (left <= right) {
            pivot = left + (right - left) / 2;
            if (nums[pivot] == target) {
                return pivot;
            }
            if (target < nums[pivot]) {
                right = pivot - 1;
            } else {
                left = pivot + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{1, 2, 3, 4, 7}, 5));
    }
}
