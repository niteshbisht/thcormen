package app.algo.arrays;

public class ZigZagConversion {

    public static String convert(String s, int numRows) {
        char[][] ar = new char[numRows][numRows];
        int counterNumRows = 0;
        int skipNumRows = 0;
        int strIndex = 0;
        for (int i = 0; i < numRows && strIndex < s.length(); i++) {
            for (int j = 0; j < numRows && strIndex < s.length(); j++) {
                if (counterNumRows < numRows) {
                    ar[j][i] = s.charAt(strIndex);
                    counterNumRows++;
                    strIndex++;
                } else {
                    if (skipNumRows < numRows - 2) {
                        skipNumRows++;
                        ar[j][i] = ' ';
                    } else {
                        counterNumRows = 0;
                        skipNumRows = 0;
                    }
                }
            }

        }
        String res = "";
        for (int i = 0; i < ar.length; i++) {
            for (int j = 0; j < ar[0].length; j++) {
                if (ar[i][j] != ' ') {
                    res = res + "" + ar[i][j];
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String paypalishiring = convert("PAYPALISHIRING", 3);
        System.out.printf(paypalishiring);
    }
}
