package com.github.practice.sorting.algorithm;

public class InsertionSortAlgorithm extends SortAlgorithm {

    @Override
    public void doSort(int[] array) {
    	for (int i = 1; i < array.length; ++i) {
        	int j = i;
        	while (j > 0 && less(array[j], array[j - 1])) {
        		swap(array, j, j - 1);
        		--j;
        	}
        }
    }

    @Override
    public SortAlgorithmType getType() {
        return SortAlgorithmType.INSERTION_SORT;
    }

}
