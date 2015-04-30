package com.github.practice.sorting.algorithms;

public class ThreeWayPartitionQuickSortAlgorithm extends QuickSortAlgorithm {

	@Override
	protected int partition(int[] array, int start, int end) {
		int pivotIndex = (end + start) / 2;
		int pivotValue = array[pivotIndex];
		
		swap(array, start, pivotIndex);
		
		int lt = start;
		int gt = end;
		int i = start + 1;
		while (i <= gt) {
			if (array[i] < pivotValue) {
				swap(array, lt++, i++);
			} else if (array[i] > pivotValue) {
				swap(array, i, gt--);
			} else {
				++i;
			}
		}
		
		return lt;
	}

	@Override
    public String getName() {
        return "3-way partition Quick sort";
    }

}
