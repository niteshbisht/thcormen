package app.algo.basic.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CombinationGenerator {

    List<List<Integer>> result = new ArrayList<>();
    int n, k;

    public static void main(String[] args) {
        CombinationGenerator cm = new CombinationGenerator();
        cm.solve(5, 3);
        System.out.println(cm.result);
    }

    void backTrack(int number, LinkedList<Integer> currentList) {
        if (currentList.size() == k) result.add(new LinkedList<>(currentList));

        for (int i = number; i < n + 1; ++i) {
            currentList.add(i);
            backTrack(i + 1, currentList);
            currentList.removeLast();
        }
    }

    public void solve(int n, int k) {
        this.n = n;
        this.k = k;
        backTrack(1, new LinkedList<Integer>());
    }
}
