package com.github.practice.sorting.algorithm;

public class HeapSortAlgorithm extends SortAlgorithm {

    @Override
    protected void doSort(int[] array) {
    	heapify(array);
    	heapsort(array);
    }

	private void heapify(int[] array) {
    	for (int k = array.length / 2; k >= 1; k--)
            sink(array, k, array.length);
	}
    
    private void sink(int[] array, int k, int N) {
        while (2*k <= N) {
            int j = 2*k;
            if (j < N && less(array[j - 1], array[j])) {
            	j++;
            }
            if (!less(array[k - 1], array[j - 1])) {
            	break;
            }
            swap(array, k - 1, j - 1);
            k = j;
        }
    }

    private void heapsort(int[] array) {
    	int length = array.length;
    	while (length > 1) {
            swap(array, 0, --length);
            sink(array, 1, length);
        }
    }
    
	@Override
    public SortAlgorithmType getType() {
        return SortAlgorithmType.HEAP_SORT;
    }

}
