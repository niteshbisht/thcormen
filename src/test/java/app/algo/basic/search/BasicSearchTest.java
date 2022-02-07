package app.algo.basic.search;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class BasicSearchTest {

    private static BasicSearch basicSearch;

    @BeforeClass
    public static void setUp() {
        basicSearch = new BasicSearch();
    }

    @Test
    public void testBasicSearch() {
        int[] searchArray = {1, 2, 4, 1, 2, 5, 4, 9, 4};
        Integer[] idxOfElements = basicSearch.getIdxOfElements(searchArray, 4);
        Assert.assertTrue(idxOfElements[0] == 2);
    }
}
