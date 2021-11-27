package com.sep.ds.base.backtrack;

import java.util.LinkedList;

public class GeneratePermutations {
    LinkedList<LinkedList<Integer>> res = new LinkedList<>();

    void solve(int[] arr) {
        backTrack(arr, new LinkedList<>());
    }

    void backTrack(int[] arr, LinkedList<Integer> trackList) {
        if (trackList.size() == arr.length) {
            res.add(new LinkedList<>(trackList));
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            int arrIElement = arr[i];
            if(trackList.contains(arrIElement)){
                continue;
            }
            trackList.add(arrIElement);
            backTrack(arr, trackList);
            trackList.removeLast();
        }
    }

    public static void main(String[] args) {
        GeneratePermutations gpr = new GeneratePermutations();
        gpr.solve(new int[]{1,2,3});
        System.out.println(gpr.res);
    }
}
