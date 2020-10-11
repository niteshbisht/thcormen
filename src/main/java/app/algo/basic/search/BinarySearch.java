package app.algo.basic.search;

public class BinarySearch {

	int binarySearch(int arr[], int l, int r, int search) {

		if (r >= 1) {
			int mid = (l + r) / 2;
			if (arr[mid] == search) {
				return mid;
			} else if (arr[mid] > search) {
				return binarySearch(arr, l, mid-1, search);
			} else {
				return binarySearch(arr, mid, r, search);
			}
		}

		return -1;
	}
}
