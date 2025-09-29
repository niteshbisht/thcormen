package io.nitesh.arrays;

public class CheckIsPallindromeString {
    
    boolean isPallindromeString(String s) {
        boolean isPallin = false;
        int i = 0, j = s.length() - 1;
        while (s.charAt(i) == s.charAt(j) && i <=j) {
            if(i==j || i+1==j) {
                isPallin = true;
            }
            i++;
            j--;
        }
        return isPallin;
    }

    public static void main(String[] args) {
        String s = "nany";
        final var pallinTest = new CheckIsPallindromeString();
        System.out.println(pallinTest.isPallindromeString(s));
    }
}
