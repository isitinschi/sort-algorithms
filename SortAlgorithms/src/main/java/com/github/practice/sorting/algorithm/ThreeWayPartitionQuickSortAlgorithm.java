package com.github.practice.sorting.algorithm;

public class ThreeWayPartitionQuickSortAlgorithm extends QuickSortAlgorithm {
	
	@Override
	protected int partition(int[] array, int left, int right) {
		int pivotIndex = (right + left) / 2;
		int pivotValue = array[pivotIndex];
		
		swap(array, left, pivotIndex);
		
		int lt = left;
		int gt = right;
		int i = left + 1;
		while (i <= gt) {
			if (less(array[i], pivotValue)) {
				swap(array, lt++, i++);
			} else if (less(pivotValue, array[i])) {
				swap(array, i, gt--);
			} else {
				++i;
			}
		}
		
		return gt;
	}

	@Override
    public SortAlgorithmType getType() {
        return SortAlgorithmType.THREE_WAY_PARTITION_QUICK_SORT;
    }

}
