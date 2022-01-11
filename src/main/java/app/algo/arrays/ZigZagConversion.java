package app.algo.arrays;

import java.util.HashMap;
import java.util.Map;

public class ZigZagConversion {

  public static String convert(String s, int numRows) {
    // char[][] ar = new char[numRows][numRows];
    // int row = 0, col = 0;
    int pos = 1, step = 1;
    Map<Integer, StringBuilder> stringBuilderMap = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (!stringBuilderMap.containsKey(pos)) {
        stringBuilderMap.put(pos, new StringBuilder(c));
      } else {
        stringBuilderMap.get(pos).append(c);
      }
      pos = pos + step;
      if (pos == 1 || pos == numRows) {
        step = step * -1;
      }
    }
    String res = "";

    for (int i = 0; i < numRows + 1; i++) {
      if(null!=stringBuilderMap.get(i)) {
        res = res.concat(stringBuilderMap.get(i).toString());
      }
    }
    return res;
  }

  public static void main(String[] args) {
    String outputValue = convert("PAYPALISHIRING", 3);
    System.out.printf(outputValue);
  }
}
