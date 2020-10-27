package app.algo.basic.sort;

import org.junit.BeforeClass;
import org.junit.Test;

import app.algo.util.ArrayPrinter;

import java.util.Arrays;

public class QuickSortTest {

	private static QuickSort quickSort;

	@BeforeClass
	public static void setUp() {
		quickSort = new QuickSort();
	}

	@Test
	public void testQuickSort() {
		int p = 0;
		int[] arr = new int[5];
		arr[0] = 2;
		arr[1] = 3;
		arr[2] = 1;
		arr[3] = 9;
		arr[4] = 5;
		long start = System.nanoTime();
		quickSort.quickSort(arr, p, arr.length-1);
		System.out.println(System.nanoTime() - start);
		// ArrayPrinter.printArray(arr);
	}

	@Test
	public void testTailRecQuickSort() {
		int p = 0;
		int[] arr = new int[5];
		arr[0] = 2;
		arr[1] = 3;
		arr[2] = 1;
		arr[3] = 9;
		arr[4] = 5;
		long start = System.nanoTime();
		quickSort.tailrecQuickSort(arr, p, arr.length-1);
		System.out.println(Arrays.toString(arr));
		// ArrayPrinter.printArray(arr);
	}
}
