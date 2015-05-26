package com.github.practice.sorting.algorithm;

import com.github.practice.sorting.algorithm.performance.Performance;
import com.github.practice.sorting.algorithm.performance.PerformanceBuilder;

public abstract class SortAlgorithm {

	private long startTime;
	private long endTime;
	private long swaps;
	private long comparisons;

	protected abstract void doSort(int[] array);

	public abstract SortAlgorithmType getType();

	public Performance sort(int[] array) {
		startTime = endTime = swaps = comparisons = 0;
		startTime = System.nanoTime();
		doSort(array);
		endTime = System.nanoTime();

		return calculatePerformance();
	}

	private Performance calculatePerformance() {
		return PerformanceBuilder.newInstance().setSortAlgorithmType(getType())
				.setTime(endTime - startTime).setSwaps(swaps)
				.setComparisons(comparisons).build();
	}

	protected void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
		++swaps;
	}
	
	protected void swapLeft(int[] array1, int i, int[] array2, int j) {
		array1[i] = array2[j];
		++swaps;
	}

	protected boolean less(int a1, int a2) {
		++comparisons;
		return a1 < a2;
	}

}
