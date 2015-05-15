package com.github.practice.sorting.algorithm;

public class ThreeWayPartitionQuickSortAlgorithm extends SortAlgorithm {
	
	@Override
    protected void doSort(int[] array) {
        quicksort(array, 0, array.length - 1);
    }

    private void quicksort(int[] array, int left, int right) {
    	if (left < right) {
    		DualPivot dualPivot = partition(array, left, right);
			quicksort(array, left, dualPivot.lPivot - 1);
			quicksort(array, dualPivot.gPivot + 1, right);
    	}
	}
	
	private DualPivot partition(int[] array, int left, int right) {
		int pivotIndex = (right + left) / 2;
		int pivotValue = array[pivotIndex];
		
		swap(array, left, pivotIndex);
		
		int lt = left;
		int gt = right;
		int i = left + 1;
		while (i <= gt) {
			if (less(array[i], pivotValue)) {
				swap(array, i++, lt++);
			} else if (less(pivotValue, array[i])) {
				swap(array, i, gt--);
			} else {
				++i;
			}
		}
		
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
        return SortAlgorithmType.THREE_WAY_PARTITION_QUICK_SORT;
    }

}
