package day1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TwoSumProblem {


    public int[] twoSumApproach1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }

    public int[] twoSumApproach2(int[] nums, int target) {
        Arrays.sort(nums);
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            if (nums[start] + nums[end] == target) {
                return new int[]{start, end};
            } else if (nums[start] + nums[end] < target) {
                start = start + 1;
            } else {
                end = end - 1;
            }
        }
        return new int[]{};
    }

    public int[] twoSumApproach3(int[] nums, int target) {
        final Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (set.contains(complement)) {
                return new int[]{i, complement};
            }
            set.add(nums[i]);
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        var twoSum = new TwoSumProblem();
        var result = twoSum.twoSumApproach1(new int[]{2, 7, 11, 15}, 9);
        System.out.println(result[0]);
        System.out.println(result[1]);
    }
}
