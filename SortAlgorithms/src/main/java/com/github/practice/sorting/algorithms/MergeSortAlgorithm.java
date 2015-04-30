package com.github.practice.sorting.algorithms;

public class MergeSortAlgorithm extends SortAlgorithm {

    @Override
    protected void doSort(int[] array) {
        mergeSort(array, 0, array.length);
    }

    private void mergeSort(int[] array, int start, int end) {
		if (end - start > 1) {
			int middle = (end + start) / 2;
			mergeSort(array, start, middle);
			mergeSort(array, middle, end);
			merge(array, start, middle, end);
		}
	}

	private void merge(int[] array, int start, int middle, int end) {
		int [] buffer = new int[end];
		for (int i = 0; i < end; ++i) {
			buffer[i] = array[i];
		}
		
		int startIndex = start;
		int middleIndex = middle;
		for (int i = start; i < end; ++i) {
			if (startIndex == middle) {
				array[i] = buffer[middleIndex++];
			} else if (middleIndex == end) {
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
