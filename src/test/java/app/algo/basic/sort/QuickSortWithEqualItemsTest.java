package app.algo.basic.sort;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class QuickSortWithEqualItemsTest extends TestCase {
    QuickSortWithEqualItems quickSortWithEqualItems;

    @Before
    public void setUp() throws Exception {
        quickSortWithEqualItems = new QuickSortWithEqualItems();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testSort() {
        int[] arr = {23, 23, 6, 23, 5, 9, 12, 8, 10};
        quickSortWithEqualItems.sort(arr, 0, arr.length);
        Assert.assertTrue(arr[0] == 6);
    }
}