package com.sep.ds.base.backtrack;

import java.util.LinkedList;

public class ScootersFuel {
    static int cap = 10;
    int res = 0;

    public static void main(String[] args) {
        ScootersFuel sf = new ScootersFuel();
        sf.solve(new int[]{7, 4, 14}, 23);
    }

    int solve(int[] scooters, int finish) {
        backTrack(scooters, new LinkedList<>(), 0, 0, finish);
        return 0;
    }

    void backTrack(int[] scooters, LinkedList<Integer> scooterList, int currentPoint, int prevSum, int finish) {
        // code for base case
        if (currentPoint + cap >= finish) {
            // found
            int val = finish - currentPoint;
            res = prevSum + val;
            return;
        }

        for (int i = 0; i < scooters.length; i++) {
            int val = scooters[i];
            if (scooterList.contains(val)) {
                continue;
            }
            scooterList.add(val);
            backTrack(scooters, scooterList, val, prevSum, finish);
            scooterList.removeLast();
        }
    }
}
