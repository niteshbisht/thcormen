package app.algo.basic.search;

import java.util.ArrayList;
import java.util.List;

public class BasicSearch {

    Integer[] getIdxOfElements(int[] searchArray, @SuppressWarnings("SameParameterValue") int item) {
        List<Integer> positionArray = new ArrayList<>();
        for (int i = 0; i < searchArray.length; i++) {
            if (item == searchArray[i]) {
                positionArray.add(i);
            }
        }
        Integer[] a = new Integer[positionArray.size()];
        positionArray.toArray(a);
        return a;
    }
}
