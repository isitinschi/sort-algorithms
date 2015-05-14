package com.github.practice.sorting.algorithm.performance;

import com.github.practice.sorting.algorithm.SortAlgorithmType;

public class Performance {

	private SortAlgorithmType sortAlgorithmType;
	private long time;
	private long swaps;
	private long comparisons;
	
	public Performance(SortAlgorithmType sortAlgorithmType, long time, long swaps, long comparisons) {
		super();
		this.sortAlgorithmType = sortAlgorithmType;
		this.time = time;
		this.swaps = swaps;
		this.comparisons = comparisons;
	}

	public SortAlgorithmType getSortAlgorithmType() {
		return sortAlgorithmType;
	}

	public void setSortAlgorithmType(SortAlgorithmType sortAlgorithmType) {
		this.sortAlgorithmType = sortAlgorithmType;
	}

	public long getTime() {
		return time;
	}
	
	public void setTime(long time) {
		this.time = time;
	}
	
	public long getSwaps() {
		return swaps;
	}
	
	public void setSwaps(long swaps) {
		this.swaps = swaps;
	}
	
	public long getComparisons() {
		return comparisons;
	}
	
	public void setComparisons(long comparisons) {
		this.comparisons = comparisons;
	}
		
}
