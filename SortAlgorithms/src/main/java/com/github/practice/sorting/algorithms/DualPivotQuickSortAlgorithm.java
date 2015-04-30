package com.github.practice.sorting.algorithms;

public class DualPivotQuickSortAlgorithm extends QuickSortAlgorithm {

	@Override
	protected int partition(int[] array, int start, int end) {
		if (array[start] > array[end]) {
			swap(array, start, end);
		}

		int lt = start + 1, gt = end - 1;
		int i = start + 1;
		while (i <= gt) {
			if (array[i] < array[start]) {
				swap(array, lt++, i++);
			} else if (array[end] < array[i]) {
				swap(array, i, gt--);
			} else {
				i++;
			}
		}
		swap(array, start, --lt);
		swap(array, end, ++gt);

		return lt;
	}

	@Override
	public String getName() {
		return "3-way partition Quick sort";
	}

}
