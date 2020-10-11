package app.algo.basic.sort;

public class QuickSort {

	public void quickSort(int arr[],int p,int r) {
		if(p<r) {
			int q=partition(arr, p, r);
			quickSort(arr, p, q-1);
			quickSort(arr, q+1, r);
		}
	}
	
	public int partition(int arr[], int p, int r) {
		int x = arr[r];
		int i = p - 1;
		for (int j = p; j < r ; j++) {
			if (arr[j] < x ) {
				i++;
				if(i!=j)
					exchange(arr, i, j);
			}
		}
		exchange(arr, i + 1, r);
		return i + 1;
	}

	void exchange(int arr[], int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
