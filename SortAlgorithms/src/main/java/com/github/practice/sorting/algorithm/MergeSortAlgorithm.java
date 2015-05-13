package com.github.practice.sorting.algorithm;

public class MergeSortAlgorithm extends SortAlgorithm {
	
    @Override
    protected void doSort(int[] array) {
        mergeSort(array, 0, array.length);
    }

    private void mergeSort(int[] array, int left, int right) {
    	if (right - left > 1) {
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
			} else if (less(buffer[startIndex], buffer[middleIndex])) {
				array[i] = buffer[startIndex++];
			} else {
				array[i] = buffer[middleIndex++];
			}
		}
	}

	@Override
    public SortAlgorithmType getType() {
        return SortAlgorithmType.MERGE_SORT_ALGORITHM;
    }

}
