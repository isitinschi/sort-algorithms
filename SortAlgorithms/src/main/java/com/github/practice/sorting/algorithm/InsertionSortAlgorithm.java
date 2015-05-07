package com.github.practice.sorting.algorithm;

public class InsertionSortAlgorithm extends SortAlgorithm {

    @Override
    protected void doSort(int[] array) {
    	insertionSort(array, 0, array.length - 1);
    }
    
    public void insertionSort(int[] array, int left, int right) {
    	for (int i = left + 1; i <= right; ++i) {
        	int j = i;
        	while (j > left && less(array[j], array[j - 1])) {
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
