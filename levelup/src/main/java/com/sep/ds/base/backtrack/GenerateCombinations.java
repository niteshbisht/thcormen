package com.sep.ds.base.backtrack;

import java.util.LinkedList;

public class GenerateCombinations {
    static final LinkedList<LinkedList<Integer>> res = new LinkedList<>();

    void solve(int n, int k) {
        LinkedList<Integer> trackList = new LinkedList<>();
        backTrack(n, k, 1, trackList);
    }

    void backTrack(int n, int k, int start, LinkedList<Integer> track) {
        if (k == track.size()) {
            res.addLast(track);
            return;
        }
        for (int i = start; i <= n; i++) {
            track.addLast(i);
            backTrack(n, k, i + 1, new LinkedList<>(track));
            track.removeLast();
        }
    }

    public static void main(String[] args) {
        GenerateCombinations gc = new GenerateCombinations();
        gc.solve(4, 2);
        System.out.println(res);
    }
}
