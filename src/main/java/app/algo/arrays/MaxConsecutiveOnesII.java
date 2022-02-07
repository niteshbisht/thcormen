package app.algo.arrays;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MaxConsecutiveOnesII {

    public static int findMaxConsecutiveOnes(int[] nums) {
        int numZeroes = 0, left = 0, right = 0, maxConsecutiveOnes = 0;
        while (right < nums.length) {
            if (nums[right] == 0) {
                numZeroes++;
            }

            while (numZeroes == 2) {
                if (nums[left] == 0) {
                    numZeroes--;
                }
                left++;
            }
            maxConsecutiveOnes = Math.max(maxConsecutiveOnes, right - left + 1);
            right++;
        }
        return maxConsecutiveOnes;
    }

    public static void main(String[] args) {
        var data = new int[]{1, 0, 1, 1, 0};
        int findMaxConsecutiveOnes = findMaxConsecutiveOnes(data);
        log.info("value {}", findMaxConsecutiveOnes);
    }
}
