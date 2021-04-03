package app.algo.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

public class MissingRangesFromArray {

    private static BiFunction<Integer, Integer, String> formatRange =
            (lower, upper) -> {
                if (lower == upper) {
                    return String.valueOf(lower);
                }
                return lower + "->" + upper;
            };

    public static List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<>();
        if (nums.length == 0) {
            String res = lower == upper ? String.valueOf(lower) : lower + "->" + upper;
            result.add(res);
        }
        int prev = lower - 1;
        for (int i = 0; i <= nums.length; i++) {
            int current = (i < nums.length) ? nums[i] : upper + 1;
            if (prev + 1 <= current - 1) {
                result.add(formatRange.apply(prev + 1, current - 1));
            }
            prev = current;
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> missingRanges = findMissingRanges(new int[]{0, 1, 3, 50, 75}, 0, 99);
        System.out.println(missingRanges);
    }
}
