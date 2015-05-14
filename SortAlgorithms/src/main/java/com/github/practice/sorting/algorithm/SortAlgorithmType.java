package com.github.practice.sorting.algorithm;

public enum SortAlgorithmType {
	BUBBLE_SORT("Bubble sort"), 
	DUAL_PIVOT_QUICK_SORT("Dual pivot partition quick sort"), 
	HEAP_SORT("Heap sort"), 
	INSERTION_SORT("Insertion sort"), 
	MERGE_SORT_ALGORITHM("Merge sort"),
	BOTTOM_UP_MERGE_SORT_ALGORITHM("Bottom-up merge sort"),
	QUICK_SORT("Quick sort"), 
	SELECT_SORT("Select sort"), 
	THREE_WAY_PARTITION_QUICK_SORT("3-way partition quick sort");
	
	private String name;
	
	private SortAlgorithmType(String name) {
		this.name = name;
	}
	
	public String getValue() {
		return name;
	}
}
