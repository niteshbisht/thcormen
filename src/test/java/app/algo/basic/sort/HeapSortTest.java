package app.algo.basic.sort;


import org.junit.BeforeClass;
import org.junit.Test;

public class HeapSortTest {

    private static HeapSort heapSort;

    @BeforeClass
    public static void setUp() {
        heapSort = new HeapSort();
    }

    @Test
    public void testMaxHeapify() {
        int[] data = new int[10000000];
        for (int i = 9999999; i >= 0; i--) {
            data[i] = i;
        }
        long t1 = System.currentTimeMillis();
        heapSort.heapSort(data);
        System.out.println(System.currentTimeMillis() - t1);
    }
}
