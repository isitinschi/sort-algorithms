package com.github.practice.sorting.algorithms;

public abstract class SortAlgorithm {

	protected abstract void doSort(int[] array);

	public abstract String getName();

	public void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	public long sort(int[] array) {
		long startTime = System.currentTimeMillis();
		doSort(array);
		long endTime = System.currentTimeMillis();
		return endTime - startTime;
	}

}
