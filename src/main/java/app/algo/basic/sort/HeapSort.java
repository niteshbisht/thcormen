package app.algo.basic.sort;

public class HeapSort {


	int getParent(int idx) {
		return Math.floorDiv(idx, 2);
	}

	int getLeftChild(int idx) {
		return (2 * idx)+1;
	}

	int getRightChild(int idx) {
		return (2 * idx) + 2;
	}

	void maxHeapify(int[] arr, int size ,int i) {
		
		int left = getLeftChild(i);
		int right = getRightChild(i);
		int largest = i;
		
		if ((left < size) && (arr[left] > arr[i])) {
			largest = left;
		} else
			largest = i;

		if ((right < size) && (arr[right] > arr[largest])) {
			largest = right;
		}

		if (largest != i) {
			exchange(arr, i, largest);
			maxHeapify(arr,size,largest);
		}
		
	}

	public void buildMaxHeap(int[] arr) {
		int size = arr.length-1;
		for (int j = (size / 2)-1; j >= 0; j--) {
			maxHeapify(arr,size,j);
		}
	}

	public void heapSort(int[] arr) {
		buildMaxHeap(arr);
		//printArray(arr);
		for (int j = arr.length-1; j > 0; j--) {
			exchange(arr, 0, j);
			maxHeapify(arr, j ,0);
			//printArray(arr);
		}
	}

	void exchange(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	void printArray(int[] arr) {
		for(int p:arr) {
			System.out.print(p+",");
		}
		System.out.println();
	}
}
