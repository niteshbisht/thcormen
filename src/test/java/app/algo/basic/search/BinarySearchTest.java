package app.algo.basic.search;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class BinarySearchTest {

	private static BinarySearch binarySearch;

	@BeforeClass
	public static void setUp() {
		binarySearch = new BinarySearch();
	}

	@Test
	public void testBinarySearch() {

		int[] arr = { 1, 4, 6, 7, 9, 8, 10, 25 };
		int l = 0;
		int r = arr.length;
		int search = 10;
		int searchIndx = binarySearch.binarySearch(arr, l, r, search);
		Assert.assertTrue(searchIndx == 6);
	}

}
