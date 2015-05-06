package com.github.practice.sorting.listener;

import com.github.practice.sorting.algorithm.Performance;
import com.github.practice.sorting.utils.producer.ArraySize;
import com.github.practice.sorting.utils.producer.ArrayType;

public interface PerformanceListener {

	void performanceCalculated(Performance performance, ArraySize size, ArrayType type);
	
}
