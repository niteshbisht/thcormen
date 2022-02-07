package app.algo.easy;

public class NeedleInHaystackAkaIndexOf {
    public static int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) return 0;
        if (haystack.equalsIgnoreCase("") || needle.equalsIgnoreCase("")) return 0;
        int i = 0, j = 0;
        int beginIdx = -1;
        while (i < haystack.length() && j < needle.length()) {
            char c = haystack.charAt(i);
            char p = needle.charAt(j);
            if (c == p) {
                if (j == 0) {
                    beginIdx = i;
                }
                j++;
            } else {
                j = 0;
                beginIdx = -1;
                i++;
            }
        }
        return beginIdx;
    }

    public static void main(String[] args) {
        int val = strStr("aaaaa", "bba");
        System.out.println(val);

        "".indexOf("yes");
    }
}
