package app.algo.easy;

public class RemoveDupes {
    public static void main(String[] args) {
        int[] arr = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        RemoveDupes dupes = new RemoveDupes();
        System.out.println(dupes.removeDuplicates(arr));
    }

    public int removeDuplicates(int[] nums) {
        int i = 0, j = 0;
        for (j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}
