package com.github.practice.sorting.algorithm.performance;

import com.github.practice.sorting.algorithm.Performance;

public class PerformanceBuilder {

	private String name;
	private long time;
	private long swaps;
	private long comparisons;
	
	private PerformanceBuilder(){}
	
	public static PerformanceBuilder newInstance() {
		return new PerformanceBuilder();
	}
	
	public PerformanceBuilder setName(String name) {
		this.name = name;
		return this;
	}
	
	public PerformanceBuilder setTime(long time) {
		this.time = time;
		return this;
	}
	
	public PerformanceBuilder setSwaps(long swaps) {
		this.swaps = swaps;
		return this;
	}
	
	public PerformanceBuilder setComparisons(long comparisons) {
		this.comparisons = comparisons;
		return this;
	}
	
	public Performance build() {
		return new Performance(name, time, swaps, comparisons);
	}
}
