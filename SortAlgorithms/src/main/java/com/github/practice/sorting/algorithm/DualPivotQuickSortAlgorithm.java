package com.github.practice.sorting.algorithm;

public class DualPivotQuickSortAlgorithm extends SortAlgorithm {

	private static final int INSERTION_SORT_THRESHOLD = 47;
	
	private InsertionSortAlgorithm insertionSortAlgorithm = new InsertionSortAlgorithm();
	
	@Override
    protected void doSort(int[] array) {
        quicksort(array, 0, array.length - 1);
    }
	
	protected void quicksort(int[] array, int left, int right) {
		int length = right - left + 1;
		if (length < INSERTION_SORT_THRESHOLD) {
			insertionSortAlgorithm.insertionSort(array, left, right);
		} else {
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
		
		if (lPivotValue > gPivotValue) {
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
			if (array[i] < lPivotValue) {
				swap(array, lt++, i++);
			} else if (gPivotValue < array[i]) {
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
	public String getName() {
		return "Dual pivot partition Quick sort";
	}

}
