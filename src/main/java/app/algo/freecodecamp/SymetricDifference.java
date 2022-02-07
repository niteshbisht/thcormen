package app.algo.freecodecamp;

import java.util.ArrayList;
import java.util.List;

public class SymetricDifference {
    static List<Integer> solve(int[] s1, int[] s2) {
        List<Integer> s1List = new ArrayList<>();
        List<Integer> s2List = new ArrayList<>();
        List<Integer> resList = new ArrayList<>();
        for (Integer e : s1) {
            s1List.add(e);
        }
        for (Integer e : s2) {
            s2List.add(e);
        }
        for (Integer e : s2) {
            if (!s1List.contains(e)) {
                resList.add(e);
            }
        }
        for (Integer e : s1) {
            if (!s2List.contains(e)) {
                resList.add(e);
            }
        }
        return resList;
    }

    public static void main(String[] args) {
        System.out.println(solve(new int[]{1, 3}, new int[]{1, 2, 4, 5}));
    }
}
