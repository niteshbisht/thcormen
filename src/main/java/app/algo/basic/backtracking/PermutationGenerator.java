package app.algo.basic.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import static app.algo.util.AlgoUtils.swap;

public class PermutationGenerator {

  public static void main(String[] args) {
    PermutationGenerator pg = new PermutationGenerator();
    // pg.permutation1(new int[] {1, 2, 3, 4, 5}, 5);
    ArrayList<ArrayList<Integer>> result = pg.permutation2(new int[] {1, 2, 3, 4, 5}, 5);
    System.out.println(result.toArray());
  }

  public void permutation1(int[] a, int n) {
    if (n == 1) {
      System.out.println(Arrays.toString(a));
      return;
    }
    for (int i = 0; i < n; i++) {
      swap(a, i, n - 1); // (remove the ith element)
      permutation1(a, n - 1);
      swap(a, i, n - 1); // (restore for the next round)
    }
  }

  public ArrayList<ArrayList<Integer>> permutation2(int[] a, int n) {
    ArrayList<ArrayList<Integer>> gen = new ArrayList<>();
    if (n == 1) {
      ArrayList<Integer> new_permutation = new ArrayList<>();
      new_permutation.add(a[n - 1]);
      gen.add(new_permutation);
    } else {
      Iterator<ArrayList<Integer>> itr = permutation2(a, n - 1).iterator();
      while (itr.hasNext()) {
        ArrayList<Integer> permutation = itr.next();
        // (create new permutation with this element in every position)
        for (int i = 0; i <= permutation.size(); i++) {
          ArrayList<Integer> new_permutation = new ArrayList<>(permutation);
          new_permutation.add(i, a[n - 1]);
          gen.add(new_permutation);
        }
      }
    }
    return gen;
  }
}
