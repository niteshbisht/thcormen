package app.algo.basic.sort;

import org.junit.BeforeClass;
import org.junit.Test;

import app.algo.util.ArrayPrinter;

public class QuickSortTest {

	private static QuickSort quickSort;

	@BeforeClass
	public static void setUp() {
		quickSort = new QuickSort();
	}

	@Test
	public void testQuickSort() {
		int p = 0;
		int[] arr = new int[4];
		arr[0] = 4;
		arr[1] = 3;
		arr[2] = 2;
		arr[3] = 1;
//		for(int i=0;i<4;i++) {
//			arr[i]=i;
//		}
		int r = arr.length-1;
		quickSort.quickSort(arr, p, r);
		ArrayPrinter.printArray(arr);
	}
}
