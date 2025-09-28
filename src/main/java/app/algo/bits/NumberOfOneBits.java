package app.algo.bits;

public class NumberOfOneBits {
  public static void main(String[] args) {
    int bits = numberOfOneBits(11);
    System.out.println(bits);
    bits = numberOfOneBits(128);
    System.out.println(bits);
    bits = numberOfOneBits(2147483645);
    System.out.println(bits);
  }

  static int numberOfOneBits(int n) {
    // 1 -> 01
    // 2 -> 10
    // 3 -> 11
    // 4 ->
    /*
       4    4/2    0
       2    2/2    0
       1    1/2    1
    */
    int max1Bits = 0;
    int quotient = n / 2;
    int remainder = n % 2;
    String bits = "";
    while (quotient > 0) {
      bits = bits + remainder;
      remainder = quotient % 2;
      quotient = quotient / 2;
    }
    bits = bits + remainder;
    for (int i = 0; i < bits.length(); i++) {
      if (bits.charAt(i) == '1') {
        max1Bits++;
      }
    }
    return max1Bits;
  }
}
