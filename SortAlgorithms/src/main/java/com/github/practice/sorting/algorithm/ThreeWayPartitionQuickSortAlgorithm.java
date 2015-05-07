package com.github.practice.sorting.algorithm;

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
			if (less(array[i], pivotValue)) {
				swap(array, lt++, i++);
			} else if (less(pivotValue, array[i])) {
				swap(array, i, gt--);
			} else {
				++i;
			}
		}
		
		return lt;
	}

	@Override
    public SortAlgorithmType getType() {
        return SortAlgorithmType.THREE_WAY_PARTITION_QUICK_SORT;
    }

}
