package app.algo.basic.sort;

import junit.framework.TestCase;
import org.junit.Assert;

public class SelectionSortTest extends TestCase {
    SelectionSort selectionSort = new SelectionSort();

    public void testSort() {
        int[] arr = {4, 2, 1, 3, 5, 7, 8, 21, 20};
        selectionSort.sort(arr);
        Assert.assertTrue(arr[0] == 1);
    }
}
