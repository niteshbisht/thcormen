package app.algo.basic.arrays;

public class SingleNumber {

  static int solve(int[] nums) {
    int p = 0;
    for (int q : nums) {
      p = p ^ q;
    }
    return p;
  }

  public static void main(String[] args) {}
}
