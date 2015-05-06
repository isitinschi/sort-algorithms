package com.github.practice.sorting.algorithm;

public class QuickSortAlgorithm extends SortAlgorithm {

	private static final int INSERTION_SORT_THRESHOLD = 47;
	
	private InsertionSortAlgorithm insertionSortAlgorithm = new InsertionSortAlgorithm();
	
    @Override
    protected void doSort(int[] array) {
        quicksort(array, 0, array.length - 1);
    }

    protected void quicksort(int[] array, int left, int right) {
    	int length = right - left + 1;
		if (length < INSERTION_SORT_THRESHOLD) {
			insertionSortAlgorithm.insertionSort(array, left, right);
		} else {    	
			int pivot = partition(array, left, right);
			quicksort(array, left, pivot - 1);
			quicksort(array, pivot + 1, right);
    	}
	}

	protected int partition(int[] array, int left, int right) {
		int pivotIndex = (right + left) / 2;
		int pivotValue = array[pivotIndex];
		
		swap(array, right, pivotIndex);
		int storeIndex = left;
		
		for (int i = left; i < right; ++i) {
			if (array[i] <= pivotValue) {
				swap(array, i, storeIndex);
				++storeIndex;
			}
 		}
		
		swap(array, right, storeIndex);
		
		return storeIndex;
	}

	@Override
    public String getName() {
        return "Quick sort";
    }

}
