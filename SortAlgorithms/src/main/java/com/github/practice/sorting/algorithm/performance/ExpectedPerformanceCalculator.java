package com.github.practice.sorting.algorithm.performance;

import java.util.Map;

import com.github.practice.sorting.algorithm.SortAlgorithmType;
import com.github.practice.sorting.utils.producer.ArrayType;

public class ExpectedPerformanceCalculator {
	
	private Map<PerformanceType, Map<ArrayType, Map<SortAlgorithmType, String>>> expectedPerformance;

	public String calculateFor(PerformanceType performanceType, ArrayType arrayType, SortAlgorithmType sortAlgorithmType, int arraySize) {
		Map<SortAlgorithmType, String> sortAlgorithmPerformanceMap = expectedPerformance.get(performanceType).get(arrayType);
		String value = "—";
		if (sortAlgorithmPerformanceMap != null) {
			value = expectedPerformance.get(performanceType).get(arrayType).get(sortAlgorithmType);			
		}
		return value;
	}

	public void setExpectedPerformance(
			Map<PerformanceType, Map<ArrayType, Map<SortAlgorithmType, String>>> expectedPerformance) {
		this.expectedPerformance = expectedPerformance;
	}	
	
}
