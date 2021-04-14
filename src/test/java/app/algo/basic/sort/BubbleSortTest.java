package app.algo.basic.sort;

import junit.framework.TestCase;
import org.junit.Assert;

public class BubbleSortTest extends TestCase {

  BubbleSort bubbleSort;

  public void setUp() throws Exception {
    super.setUp();
    bubbleSort = new BubbleSort();
  }

  public void tearDown() throws Exception {}

  public void testSort() {
    int[] arr = {4, 2, 1, 3, 5, 7, 8, 21, 20};
    bubbleSort.sort(arr);
    Assert.assertTrue(arr[0] == 1);
  }
}
