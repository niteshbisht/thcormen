package app.algo.basic.arrays;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicates {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> hs = new HashSet<>();
        for (int num : nums) {
            if (hs.contains(num)) {
                return true;
            }
        }
        return false;
    }
}
