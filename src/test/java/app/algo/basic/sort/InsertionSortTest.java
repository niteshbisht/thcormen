package app.algo.basic.sort;

import junit.framework.TestCase;
import org.junit.Assert;

public class InsertionSortTest extends TestCase {
  InsertionSort insertionSort = new InsertionSort();

  public void testSort() {
    int[] arr = {4, 2, 1, 3, 5, 7, 8, 21, 20};
    insertionSort.sort(arr);
    Assert.assertEquals(1, arr[0]);
  }
}
