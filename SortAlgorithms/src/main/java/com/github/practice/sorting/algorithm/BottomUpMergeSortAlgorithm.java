package com.github.practice.sorting.algorithm;

public class BottomUpMergeSortAlgorithm extends MergeSortAlgorithm {

	@Override
	protected void doSort(int[] array) {
		int N = array.length;
		int[] aux = new int[N];
		for (int sz = 2; sz < N; sz = sz + sz) {
			for (int lo = 0; lo < N - sz; lo += sz + sz) {
				merge(array, aux, lo, lo + sz - 1,
						Math.min(lo + sz + sz - 1, N - 1));
			}
		}
	}

	@Override
	public SortAlgorithmType getType() {
		return SortAlgorithmType.BOTTOM_UP_MERGE_SORT_ALGORITHM;
	}

}
