package com.github.practice.sorting.listener;

import com.github.practice.sorting.algorithm.Performance;
import com.github.practice.sorting.utils.producer.ArrayType;

public interface PerformanceListener {

	void performanceCalculated(Performance performance, int size, ArrayType type);
	
}
