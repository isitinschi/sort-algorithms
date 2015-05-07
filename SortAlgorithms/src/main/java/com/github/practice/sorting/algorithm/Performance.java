package com.github.practice.sorting.algorithm;

public class Performance {

	private SortAlgorithmType type;
	private long time;
	private long swaps;
	private long comparisons;
	
	public Performance(SortAlgorithmType type, long time, long swaps, long comparisons) {
		super();
		this.type = type;
		this.time = time;
		this.swaps = swaps;
		this.comparisons = comparisons;
	}
	
	public SortAlgorithmType getType() {
		return type;
	}

	public void setType(SortAlgorithmType type) {
		this.type = type;
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
