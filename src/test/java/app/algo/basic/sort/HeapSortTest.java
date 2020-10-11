package app.algo.basic.sort;

import java.util.Arrays;

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
		int[] data=new int[10000000];
		for(int i=9999999;i>=0;i--) {
			data[i]=i;
		}
		int[] copyOf = Arrays.copyOf(data, data.length);
		
		long t1 = System.currentTimeMillis();
		heapSort.heapSort(data);
		System.out.println(System.currentTimeMillis()-t1);
		long t2 = System.currentTimeMillis();
		Arrays.sort(copyOf);
		System.out.println(System.currentTimeMillis()-t2);
	}
}
