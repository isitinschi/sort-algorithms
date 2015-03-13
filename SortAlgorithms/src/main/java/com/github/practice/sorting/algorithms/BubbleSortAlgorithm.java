package com.github.practice.sorting.algorithms;

public class BubbleSortAlgorithm extends SortAlgorithm {

    @Override
    protected void doSort(int[] array) {
        for (int i = 0; i < array.length; ++i) {
            boolean swapFlag = false;
            for (int j = 0; j < array.length - i - 1; ++j) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                    swapFlag = true;
                }
            }
            if (!swapFlag) {
                break; // nothing was changed, so we have sorted array
            }
        }
    }

    @Override
    public String getName() {
        return "Bubble sort";
    }

}
