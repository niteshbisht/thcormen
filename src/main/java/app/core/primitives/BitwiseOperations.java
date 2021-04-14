package app.core.primitives;

public class BitwiseOperations {
  public static void main(String[] args) {
    int q = 2, r = 2;
    System.out.println(q & r);
    System.out.println(q | r);
    System.out.println(q ^ r);
    System.out.println(-16>>3);
    int i = 10;
    int n = i++%5;
    System.out.println(n);
  }
}
