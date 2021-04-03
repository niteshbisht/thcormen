package app.algo.basic.search;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class ArrayToArraySearchTest {
    private static ArrayToArraySearch arrayToArraySearch;

    @BeforeClass
    public static void setUp() {
        arrayToArraySearch = new ArrayToArraySearch();
    }

    @Test
    public void testGetPositionsOfElements() {
        Integer[] sourceArrayToBeSearched = {1, 2, 3, 9, 8, 5, 2};
        Integer[] toSearchArray = {1, 2, 5, 6, 2};
        Map<Integer, List<Integer>> positionsOfElements =
                arrayToArraySearch.getPositionsOfElements(toSearchArray, sourceArrayToBeSearched);
        System.out.println(positionsOfElements);
    }
}
