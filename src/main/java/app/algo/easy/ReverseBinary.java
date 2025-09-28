package app.algo.easy;

public class ReverseBinary {
  public static void main(String[] args) {
    ReverseBinary rbn = new ReverseBinary();
    System.out.println(rbn.reverseBits("00000010100101000001111010011100"));
  }

  public int reverseBits(String s) {
    // String binary = Integer.toBinaryString(n);
    char[] chars = s.toCharArray();
    StringBuffer stringBuffer = new StringBuffer();
    for (int i = chars.length - 1; i >= 0; i--) {
      stringBuffer.append(chars[i]);
    }
    String reversedString = stringBuffer.toString();
    return Integer.parseInt(reversedString, 2);
  }
}
