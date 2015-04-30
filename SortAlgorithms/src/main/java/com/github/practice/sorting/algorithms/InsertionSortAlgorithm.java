package com.github.practice.sorting.algorithms;

public class InsertionSortAlgorithm extends SortAlgorithm {

    @Override
    protected void doSort(int[] array) {
        for (int i = 1; i < array.length; ++i) {
        	int j = i;
        	while (j > 0 && array[j] < array[j - 1]) {
        		swap(array, j, j - 1);
        		--j;
        	}
        }
    }

    @Override
    public String getName() {
        return "Insertion sort";
    }

}
