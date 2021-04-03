package app.algo.basic.search;

import java.util.*;

public class ArrayToArraySearch {

    public Map<Integer, List<Integer>> getPositionsOfElements(
            Integer[] toSearchArray, Integer[] sourceArrayToBeSearched) {

        HashSet<Integer> searchElements = new HashSet<>();
        searchElements.addAll(Arrays.asList(toSearchArray));
        Map<Integer, List<Integer>> resultMap = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < sourceArrayToBeSearched.length; i++) {
            if (searchElements.contains(sourceArrayToBeSearched[i])) {
                if (resultMap.containsKey(sourceArrayToBeSearched[i])) {
                    resultMap.get(sourceArrayToBeSearched[i]).add(i);
                } else {
                    List<Integer> positionList = new ArrayList<>();
                    positionList.add(i);
                    resultMap.put(sourceArrayToBeSearched[i], positionList);
                }
            }
        }
        return resultMap;
    }
}
