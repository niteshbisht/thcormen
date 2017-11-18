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
		int[] arr = {4,1,3,2,16,9,10,14,8,7};
		//{16,14,10,9,8,7,4,3,2,1}; 
			//{1 2 3 4 7 8 9 10 14 16};
		for(int p:arr) {
			System.out.print(p+",");
		}
		System.out.println();
		heapSort.heapSort(arr);
		for(int p:arr) {
			System.out.print(p+",");
		}
	}
}
