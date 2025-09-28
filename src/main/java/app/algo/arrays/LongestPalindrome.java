package app.algo.arrays;

public class LongestPalindrome {

  public static String longestPalindrome(String s) {
    int maxRes = 0;
    String res = "";

    for (int i = 0; i < s.length(); i++) {
      int start = i, end = i;
      while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
        if (end - start + 1 > maxRes) {
          maxRes = end - start + 1;
          res = s.substring(start, end + 1);
        }
        start--;
        end++;
      }
      start = i;
      end = i + 1;
      while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
        if (end - start + 1 > maxRes) {
          maxRes = end - start + 1;
          res = s.substring(start, end + 1);
        }
        start--;
        end++;
      }
    }
    return res;
  }

  public static void main(String[] args) {
    String longestPal = longestPalindrome("babad");
    System.out.println(longestPal);
  }
}
