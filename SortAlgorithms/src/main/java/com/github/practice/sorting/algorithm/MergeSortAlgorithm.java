package com.github.practice.sorting.algorithm;

public class MergeSortAlgorithm extends SortAlgorithm {
	
    @Override
    protected void doSort(int[] array) {
    	int [] aux = new int[array.length];
		for (int i = 0; i < array.length; ++i) {
			aux[i] = array[i];
		}
        mergeSort(array, aux, 0, array.length);
    }

    private void mergeSort(int[] array, int[] aux, int left, int right) {
    	if (right - left > 1) {
			int middle = (right + left) / 2;
			mergeSort(aux, array, left, middle);
			mergeSort(aux, array, middle, right);
			if (!less(array[middle], array[middle - 1])) {
				return; // biggest item in first half <= smallest item in second half
			}
			merge(array, aux, left, middle, right);
		}
	}

	protected void merge(int[] array, int[] aux, int left, int middle, int right) {		
		int startIndex = left;
		int middleIndex = middle;
		for (int i = left; i < right; ++i) {
			if (startIndex == middle) {
				array[i] = aux[middleIndex++];
			} else if (middleIndex == right) {
				array[i] = aux[startIndex++];
			} else if (less(aux[startIndex], aux[middleIndex])) {
				array[i] = aux[startIndex++];
			} else {
				array[i] = aux[middleIndex++];
			}
		}
	}

	@Override
    public SortAlgorithmType getType() {
        return SortAlgorithmType.MERGE_SORT_ALGORITHM;
    }

}
