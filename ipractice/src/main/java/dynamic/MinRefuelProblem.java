package dynamic;

import java.util.*;

public class MinRefuelProblem {

  static int minRefuelStopsPq(int T, int F, int[][] S) {
    int N = S.length, ans = 0;

    // Sort on the basis of
    // distance from the start
    Arrays.sort(
        S,
        new Comparator<int[]>() {
          public int compare(int[] a, int[] b) {
            return Integer.compare(a[0], b[0]);
          }
        });
    PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
    for (int i = 0; i <= N; i++) {
      int dist = i == N ? T : S[i][0];
      while (F < dist) {
        if (pq.size() == 0) return -1;
        F += pq.poll();
        ans++;
      }
      if (i < N) pq.add(S[i][1]);
    }
    return ans;
  }

  static int minRefuelStops(int T, int F, int[][] S) {
    int n = S.length;
    int t[][] = new int[n + 1][n + 1];
    for (int i = 0; i < n + 1; i++) {
      t[i][0] = F;
    }

    for (int i = 1; i < n + 1; i++) {
      for (int j = 1; j <= i; j++) {
        t[i][j] = t[i - 1][j];
        if (t[i - 1][j - 1] >= S[i - 1][0]) {
          t[i][j] = Math.max(t[i][j], t[i - 1][j - 1] + S[i - 1][1]);
        }
      }
    }
    for (int j = 0; j < n + 1; j++) {
      if (t[n][j] >= T) return j;
    }
    return -1;
  }

  public static void main(String[] args) {
    int target = 100, M = 10;
    int stations[][] = {{10, 60}, {20, 30}, {30, 30}, {60, 40}};
    //    System.out.println(minRefuelStops(target, M, stations));
    System.out.println(minRefuelStopsPq(target, M, stations));
  }
}
