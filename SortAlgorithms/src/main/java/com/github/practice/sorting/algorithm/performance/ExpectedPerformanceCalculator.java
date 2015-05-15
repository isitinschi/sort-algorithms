package com.github.practice.sorting.algorithm.performance;

import java.util.Map;

import com.github.practice.sorting.algorithm.SortAlgorithmType;
import com.github.practice.sorting.utils.producer.ArrayType;

public class ExpectedPerformanceCalculator {
	
	private Map<PerformanceType, Map<ArrayType, Map<SortAlgorithmType, String>>> expectedPerformance;

	public String calculateFor(PerformanceType performanceType, ArrayType arrayType, SortAlgorithmType sortAlgorithmType, int arraySize) {
		String value = expectedPerformance.get(performanceType).get(arrayType).get(sortAlgorithmType);
		if (value == null) {
			value = "—";			
		}
		return value;
	}

	public void setExpectedPerformance(
			Map<PerformanceType, Map<ArrayType, Map<SortAlgorithmType, String>>> expectedPerformance) {
		this.expectedPerformance = expectedPerformance;
	}	
	
}
