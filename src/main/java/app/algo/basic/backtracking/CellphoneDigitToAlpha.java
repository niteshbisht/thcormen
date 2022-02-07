package app.algo.basic.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CellphoneDigitToAlpha {
    static List<String> output = new ArrayList<String>();
    private static Map<String, String> digMap = new HashMap<>();

    static {
        digMap.put("2", "abc");
        digMap.put("3", "def");
        digMap.put("4", "ghi");
        digMap.put("5", "jkl");
        digMap.put("6", "mno");
        digMap.put("7", "pqr");
        digMap.put("8", "stu");
        digMap.put("9", "wxyz");
    }

    static void backTrack(String combination, String nextDigits) {
        //  base case
        if (nextDigits.length() == 0) {
            output.add(combination);
        } else {
            String digit = nextDigits.substring(0, 1);
            String letters = digMap.get(digit);
            for (int i = 0; i < letters.length(); i++) {
                String letter = letters.substring(i, i + 1);
                backTrack(combination + letter, nextDigits.substring(1));
            }
        }
    }

    static List<String> solve(String digits) {
        if (digits.length() != 0) {
            backTrack("", digits);
        }
        return output;
    }

    public static void main(String[] args) {
        //
        List<String> resultvalue = solve("5522792599345798543792");
        System.out.println(resultvalue);
    }
}
