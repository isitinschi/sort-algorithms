package com.github.practice.sorting.algorithm;

public class Performance {

	private String name;
	private long time;
	private long swaps;
	private long comparisons;
	
	public Performance(String name, long time, long swaps, long comparisons) {
		super();
		this.name = name;
		this.time = time;
		this.swaps = swaps;
		this.comparisons = comparisons;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
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
