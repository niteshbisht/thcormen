package io.nitesh.arrays;

public class ReverseStringInPlace {
    String reverseString(String str) {
        char[] c= str.toCharArray();
        int i = 0, j = c.length - 1;
        while (i < j) {
            char temp = c[i];
            c[i] = c[j];
            c[j] = temp;
            i++;
            j--;
        }
        return new String(c);
    }

    public static void main(String[] args) {
        String s = "123456";
        final var reverseStr = new ReverseStringInPlace();
        final var reversed = reverseStr.reverseString(s);
        System.out.println(reversed);
    }
}
