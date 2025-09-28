package app.algo.basic.arrays;

import java.util.HashSet;
import java.util.Set;

public class LongestSubsequence {

  public static int solve(String input) {
    int ans = 0;
    for (int i = 0; i < input.length(); i++) {
      for (int j = i + 1; j < input.length(); j++) {
        if (isUnique(input, i, j)) ans = Math.max(ans, j - i);
      }
    }
    return 0;
  }

  static boolean isUnique(String s, int start, int end) {
    Set<Character> set = new HashSet<>();
    for (int i = start; i < end; i++) {
      char c = s.charAt(i);
      if (set.contains(c)) {
        return false;
      }
      set.add(c);
    }
    return true;
  }

  public static void main(String[] args) {}
}
