package app.algo.basic.arrays;

public class ComputeDigitsEven {
  public int findNumbers(int[] nums) {
    int ctr = 0;
    for (int i : nums) {
      int len = (int) Math.floor(Math.log10(i) + 1);
      if (len % 2 == 0) {
        ctr++;
      }
    }
    return ctr;
  }

  public static void main(String[] args) {

  }
}
