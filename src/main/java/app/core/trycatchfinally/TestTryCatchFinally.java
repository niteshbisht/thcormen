package app.core.trycatchfinally;

public class TestTryCatchFinally {
  public static void main(String[] args) {
    System.out.println(testCompute());
  }

  static int testCompute() {
    try {
      throw new IllegalStateException();
    } catch (Exception e) {
      System.out.println("In Exception Area");
      return 0;
    }
  }
}
