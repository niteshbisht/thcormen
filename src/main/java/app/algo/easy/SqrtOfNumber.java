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

    public static void main(String[] args) {
        mySqrt(16);
        Math.sqrt(4.0);
    }
}
