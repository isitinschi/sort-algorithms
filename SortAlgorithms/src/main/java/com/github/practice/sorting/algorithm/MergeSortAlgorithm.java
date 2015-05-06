package com.github.practice.sorting.algorithm;

public class MergeSortAlgorithm extends SortAlgorithm {

	private static final int INSERTION_SORT_THRESHOLD = 47;
	
	private InsertionSortAlgorithm insertionSortAlgorithm = new InsertionSortAlgorithm();
	
    @Override
    protected void doSort(int[] array) {
        mergeSort(array, 0, array.length);
    }

    private void mergeSort(int[] array, int left, int right) {
    	int length = right - left + 1;
		if (length < INSERTION_SORT_THRESHOLD) {
			insertionSortAlgorithm.insertionSort(array, left, right - 1);
		} else {
			int middle = (right + left) / 2;
			mergeSort(array, left, middle);
			mergeSort(array, middle, right);
			merge(array, left, middle, right);
		}
	}

	private void merge(int[] array, int left, int middle, int right) {
		int [] buffer = new int[right];
		for (int i = 0; i < right; ++i) {
			buffer[i] = array[i];
		}
		
		int startIndex = left;
		int middleIndex = middle;
		for (int i = left; i < right; ++i) {
			if (startIndex == middle) {
				array[i] = buffer[middleIndex++];
			} else if (middleIndex == right) {
				array[i] = buffer[startIndex++];
			} else if (buffer[startIndex] < buffer[middleIndex]) {
				array[i] = buffer[startIndex++];
			} else {
				array[i] = buffer[middleIndex++];
			}
		}
	}

	@Override
    public String getName() {
        return "Merge sort";
    }

}
