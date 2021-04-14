package app.algo.easy;

public class SqrtOfNumber {
  public static int mySqrt(int x) {
    if (x < 2) return x;

    double x0 = x;
    double x1 = (x0 + x / x0) / 2.0;
    while (Math.abs(x0 - x1) >= 1) {
      x0 = x1;
      x1 = (x0 + x / x0) / 2.0;
    }

    return (int) x1;
  }

  public static int sqrtByDivideAndConquer(int x) {
    int left = 0, right = x / 2;
    long num;
    while (left < right) {
      int pivot = left + (right - left) / 2;
      num = pivot * pivot;
      if (num > x) right = pivot - 1;
      else if (num < x) left = pivot + 1;
      else return pivot;
    }
    return right;
  }

  public static int sqrt(int x) {
    if (x < 2) return x;
    int left = (int) Math.pow(Math.E, (0.5 * Math.log(x)));
    int right = left + 1;
    return right * right > x ? left : right;
  }

  public static void main(String[] args) {
    System.out.println(sqrtByDivideAndConquer(625));
    // Math.sqrt(4.0);
  }
}
