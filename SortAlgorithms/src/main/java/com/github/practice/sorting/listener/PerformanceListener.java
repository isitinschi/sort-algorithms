package com.github.practice.sorting.listener;

import com.github.practice.sorting.algorithm.performance.Performance;
import com.github.practice.sorting.utils.producer.ArrayType;

public interface PerformanceListener {

	void performanceCalculated(Performance performance, ArrayType type);
	
}
