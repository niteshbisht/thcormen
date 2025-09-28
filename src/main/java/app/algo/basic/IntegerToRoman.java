package app.algo.basic;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class IntegerToRoman {

  private static final String[] thousands = {"", "M", "MM", "MMM"};
  private static final String[] hundreds = {
    "", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"
  };
  private static final String[] tens = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
  private static final String[] ones = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
  static Map<Integer, String> maps =
      new TreeMap<>(
              Map.ofEntries(
                  Map.entry(1, "I"),
                  Map.entry(5, "V"),
                  Map.entry(10, "X"),
                  Map.entry(50, "L"),
                  Map.entry(100, "C"),
                  Map.entry(500, "D"),
                  Map.entry(1000, "M"),
                  Map.entry(9, "IX"),
                  Map.entry(4, "IV"),
                  Map.entry(40, "XL"),
                  Map.entry(90, "XC"),
                  Map.entry(400, "CD"),
                  Map.entry(900, "CM")))
          .descendingMap();

  public static String intToRoman(int num) {
    StringBuffer sbf = new StringBuffer();
    Iterator<Map.Entry<Integer, String>> iterator = maps.entrySet().iterator();
    while (iterator.hasNext()) {
      Map.Entry<Integer, String> next = iterator.next();
      while (next.getKey() <= num) {
        num = num - next.getKey();
        sbf.append(next.getValue());
      }
    }
    return sbf.toString();
  }

  public static void main(String[] args) {
    String convertedRoman = intToRoman(121);
    System.out.println(convertedRoman);
  }

  public String intToRomanLess(int num) {
    return thousands[num / 1000]
        + hundreds[num % 1000 / 100]
        + tens[num % 100 / 10]
        + ones[num % 10];
  }
}
