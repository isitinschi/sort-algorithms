package com.github.practice.sorting.algorithms;

public class QuickSortAlgorithm extends SortAlgorithm {

    @Override
    protected void doSort(int[] array) {
        quicksort(array, 0, array.length - 1);
    }

    private void quicksort(int[] array, int start, int end) {
    	if (start < end) {    	
			int pivot = partition(array, start, end);
			quicksort(array, start, pivot - 1);
			quicksort(array, pivot + 1, end);
    	}
	}

	protected int partition(int[] array, int start, int end) {
		int pivotIndex = (end + start) / 2;
		int pivotValue = array[pivotIndex];
		
		swap(array, end, pivotIndex);
		int storeIndex = start;
		
		for (int i = start; i < end; ++i) {
			if (array[i] <= pivotValue) {
				swap(array, i, storeIndex);
				++storeIndex;
			}
 		}
		
		swap(array, end, storeIndex);
		
		return storeIndex;
	}

	@Override
    public String getName() {
        return "Quick sort";
    }

}
