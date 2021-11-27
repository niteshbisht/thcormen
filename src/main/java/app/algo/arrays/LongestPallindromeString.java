package app.algo.arrays;

public class LongestPallindromeString {
    void solve(String str) {

    }

    int fromCenter(String s, int start, int end) {
        int len = 0;
        while (start > 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
            len++;
        }

        return len;
    }
}
