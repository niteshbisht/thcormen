package app.algo.basic.sort;

import junit.framework.TestCase;

public class RandomizedQuickSortTest extends TestCase {
    RandomizedQuickSort quickSort = new RandomizedQuickSort();

    public void setUp() throws Exception {
        super.setUp();
    }

    public void tearDown() throws Exception {
    }

    public void testRandomQuickSort() {
        int[] arr = new int[5];
        arr[0] = 2;
        arr[1] = 3;
        arr[2] = 1;
        arr[3] = 9;
        arr[4] = 5;
        //		for(int i=0;i<4;i++) {
        //			arr[i]=i;
        //		}
        int r = arr.length - 1;
        long start = System.nanoTime();
        quickSort.randomQuickSort(arr, 0, r);
        System.out.println(System.nanoTime() - start);
    }
}
