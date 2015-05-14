package com.github.practice.sorting.algorithm.performance;

public enum PerformanceType {

	TIME("Time"), SWAPS("Swaps"), COMPARISONS("Comparisons");
	
	private String value;
	
	private PerformanceType(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
	
}
