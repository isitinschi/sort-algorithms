package com.github.practice.sorting.algorithm;

public class QuickSortAlgorithm extends SortAlgorithm {
	
    @Override
    protected void doSort(int[] array) {
        quicksort(array, 0, array.length - 1);
    }

    private void quicksort(int[] array, int left, int right) {
    	if (left < right) {
			int pivot = partition(array, left, right);
			if (left < pivot - 1) {
				quicksort(array, left, pivot - 1);
			}
			if (pivot + 1 < right) {
				quicksort(array, pivot + 1, right);
			}
    	}
	}

	private int partition(int[] array, int left, int right) {
		int pivotIndex = (right + left) / 2;
		int pivotValue = array[pivotIndex];
		
		swap(array, right, pivotIndex);
		int storeIndex = left;
		
		for (int i = left; i < right; ++i) {
			if (less(array[i], pivotValue)) {
				swap(array, i, storeIndex);
				++storeIndex;
			}
 		}
		
		swap(array, right, storeIndex);
		
		return storeIndex;
	}

	@Override
    public SortAlgorithmType getType() {
        return SortAlgorithmType.QUICK_SORT;
    }

}
