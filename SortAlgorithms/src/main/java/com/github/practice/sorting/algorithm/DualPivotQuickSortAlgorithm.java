package com.github.practice.sorting.algorithm;

public class DualPivotQuickSortAlgorithm extends SortAlgorithm {
	
	@Override
    protected void doSort(int[] array) {
        quicksort(array, 0, array.length - 1);
    }
	
	protected void quicksort(int[] array, int left, int right) {
		if (left < right) {
    		DualPivot dualPivot = partition(array, left, right);
    		if (dualPivot != null) {
    			quicksort(array, left, dualPivot.lPivot - 1);
				quicksort(array, dualPivot.gPivot + 1, right);
				if (less(array[dualPivot.lPivot], array[dualPivot.gPivot])) {
					quicksort(array, dualPivot.lPivot + 1, dualPivot.gPivot - 1);		
				}
    		}
    	}
	}
	
	protected DualPivot partition(int[] array, int left, int right) {
		int length = right - left;
		int third = length / 3;
		int lPivotIndex = left + third;
		int gPivotIndex = right - third;
		
		if (less(array[gPivotIndex], array[lPivotIndex])) {
			swap(array, lPivotIndex, gPivotIndex);
		}		
		
		swap(array, left, lPivotIndex);
		swap(array, right, gPivotIndex);
		
		int lPivotValue = array[left];
		int gPivotValue = array[right];

		int lt = left + 1;
		int gt = right - 1;
		int i = lt;
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

}
