package com.github.practice.sorting.algorithm;

import com.github.practice.sorting.algorithm.performance.PerformanceBuilder;

public abstract class SortAlgorithm {

	private long startTime;
	private long endTime;
	private long swaps;
	private long comparisons;

	protected abstract void doSort(int[] array);

	public abstract String getName();

	public Performance sort(int[] array) {
		startTime = System.currentTimeMillis();
		doSort(array);
		endTime = System.currentTimeMillis();

		return calculatePerformance();
	}

	private Performance calculatePerformance() {
		return PerformanceBuilder.newInstance().setName(getName())
				.setTime(endTime - startTime).setSwaps(swaps)
				.setComparisons(comparisons).build();
	}

	protected void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
		++swaps;
	}

	protected boolean less(int a1, int a2) {
		++comparisons;
		return a1 < a2;
	}

}
