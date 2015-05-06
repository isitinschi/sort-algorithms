package com.github.practice.sorting.algorithm;

public class SelectSortAlgorithm extends SortAlgorithm {

    @Override
    protected void doSort(int[] array) {
        for (int i = 0; i < array.length; ++i) {
        	int min = i;
            for (int j = i + 1 ; j < array.length; ++j) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            if (i != min) {
            	swap(array, i, min);
            }
        }
    }

    @Override
    public String getName() {
        return "Select sort";
    }

}
