package app.algo.dynamicprog;

public class ClimbingStairs {

  public static void main(String[] args){
    climbStairs(7);
  }

  public static int climbStairs(int n) {
    int a = 0, b = 1;
    for (int i = 0; i < n; ++i) {
      int c = a + b;
      a = b;
      b = c;
    }
    return b;
  }
}
