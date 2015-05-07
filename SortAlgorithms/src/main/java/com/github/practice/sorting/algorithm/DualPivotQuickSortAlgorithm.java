package com.github.practice.sorting.algorithm;

import org.springframework.beans.factory.annotation.Autowired;

public class DualPivotQuickSortAlgorithm extends SortAlgorithm {
	
	@Autowired
	private InsertionSortAlgorithm insertionSortAlgorithm;
	
	@Override
    protected void doSort(int[] array) {
        quicksort(array, 0, array.length - 1);
    }
	
	protected void quicksort(int[] array, int left, int right) {
		if (left - right >= 5) {
    		DualPivot dualPivot = partition(array, left, right);
			quicksort(array, left, dualPivot.lPivot - 1);
			quicksort(array, dualPivot.lPivot + 1, dualPivot.gPivot - 1);
			quicksort(array, dualPivot.gPivot + 1, right);
    	}
	}
	
	protected DualPivot partition(int[] array, int left, int right) {
		int lPivotIndex = left + (right - left) / 3;
		int lPivotValue = array[lPivotIndex];
		int gPivotIndex = lPivotIndex + (right - left) / 3;
		int gPivotValue = array[gPivotIndex];
		
		if (less(gPivotValue, lPivotValue)) {
			swap(array, lPivotIndex, gPivotIndex);
			lPivotValue = array[lPivotIndex];
			gPivotValue = array[gPivotIndex];
		}
		
		swap(array, left, lPivotIndex);
		swap(array, right, gPivotIndex);

		int lt = left + 1;
		int gt = right - 1;
		int i = left + 1;
		while (i <= gt) {
			if (less(array[i], lPivotValue)) {
				swap(array, lt++, i++);
			} else if (less(gPivotValue, array[i])) {
				swap(array, i, gt--);
			} else {
				i++;
			}
		}
		swap(array, left, --lt);
		swap(array, right, ++gt);

		return new DualPivot(lt, gt);
	}
	
	private class DualPivot {
		private int lPivot;
		private int gPivot;
		
		public DualPivot(int lPivot, int gPivot) {
			super();
			this.lPivot = lPivot;
			this.gPivot = gPivot;
		}		
	}

	@Override
	public SortAlgorithmType getType() {
		return SortAlgorithmType.DUAL_PIVOT_QUICK_SORT;
	}

	public void setInsertionSortAlgorithm(
			InsertionSortAlgorithm insertionSortAlgorithm) {
		this.insertionSortAlgorithm = insertionSortAlgorithm;
	}

}
