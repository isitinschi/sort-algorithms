package com.github.practice.sorting.algorithm;

public class BottomUpMergeSortAlgorithm extends MergeSortAlgorithm {

	@Override
	protected void doSort(int[] array) {
		int [] aux = new int[array.length];
		for (int i = 0; i < array.length; ++i) {
			swapLeft(aux, i, array, i);
		}
		mergeSort(array, aux, array.length);
	}
	
	private void mergeSort(int[] array, int[] aux, int N) {
		for (int sz = 1; sz < N; sz = sz + sz) {
			for (int lo = 0; lo < N - sz; lo += sz + sz) {
				merge(array, aux, lo, lo + sz,
						Math.min(lo + sz + sz, N));
			}
			copyToBuffer(array, aux);
		}
	}

	private void copyToBuffer(int[] array, int[] aux) {
		for (int i = 0; i < array.length; ++i) {
			swapLeft(aux, i, array, i);
		}
	}

	@Override
	public SortAlgorithmType getType() {
		return SortAlgorithmType.BOTTOM_UP_MERGE_SORT;
	}

}
