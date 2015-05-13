package com.github.practice.sorting.algorithm.performance;

import com.github.practice.sorting.algorithm.SortAlgorithmType;

public class PerformanceBuilder {

	private SortAlgorithmType type;
	private long time;
	private long swaps;
	private long comparisons;
	
	private PerformanceBuilder(){}
	
	public static PerformanceBuilder newInstance() {
		return new PerformanceBuilder();
	}
	
	public PerformanceBuilder setType(SortAlgorithmType type) {
		this.type = type;
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
		return new Performance(type, time, swaps, comparisons);
	}
}
