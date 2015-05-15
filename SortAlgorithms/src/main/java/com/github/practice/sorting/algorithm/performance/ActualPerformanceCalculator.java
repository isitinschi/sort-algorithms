package com.github.practice.sorting.algorithm.performance;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.practice.sorting.algorithm.SortAlgorithm;
import com.github.practice.sorting.algorithm.SortAlgorithmType;
import com.github.practice.sorting.listener.PerformanceListener;
import com.github.practice.sorting.utils.producer.ArrayBuilder;
import com.github.practice.sorting.utils.producer.ArrayType;

public class ActualPerformanceCalculator {
	
	public static final int ARRAY_SIZE = 100000;
	private static final int SORTS_COUNT = 100;
	
	private List<SortAlgorithm> sortAlgorithms;
	private List<PerformanceListener> listeners;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ActualPerformanceCalculator.class);

	@PostConstruct
    public void calculate() {
        ArrayBuilder arrayBuilder = new ArrayBuilder();
        
		for (SortAlgorithm sortAlgorithm : sortAlgorithms) {
			for (ArrayType type : ArrayType.values()) {
				int[] array = arrayBuilder.build(type, ARRAY_SIZE);
				Performance performance = performSort(sortAlgorithm, array);
				printLog(sortAlgorithm, type);
				notifyListeners(performance, type);
			}
		}
    }
	
	private Performance performSort(SortAlgorithm sortAlgorithm, int [] array) {
		List<Performance> performanceList = new ArrayList<Performance>();
		for (int i = 0; i < SORTS_COUNT; ++i) {
			int [] arrayToSort = array.clone();
			Performance performance = sortAlgorithm.sort(arrayToSort);
			performanceList.add(performance);
		}
		Performance avgPerformance = calculateAveragePerformance(performanceList);
		return avgPerformance;
	}
    
    private Performance calculateAveragePerformance(List<Performance> performanceList) {
    	long time = 0;
    	long swaps = 0;
    	long comparisons = 0;
    	
    	for (Performance performance : performanceList) {
    		time += performance.getTime();
    		swaps += performance.getSwaps();
    		comparisons += performance.getComparisons();
    	}
    	
    	time /= performanceList.size();
    	swaps /= performanceList.size();
    	comparisons /= performanceList.size();
    	SortAlgorithmType type = performanceList.get(0).getSortAlgorithmType();
    	return PerformanceBuilder.newInstance().setSortAlgorithmType(type).setTime(time).setSwaps(swaps).setComparisons(comparisons).build();
	}

	private void printLog(SortAlgorithm sortAlgorithm, ArrayType type) {
    	StringBuilder logMsg = new StringBuilder("Calculated performance for ");
    	logMsg.append(sortAlgorithm.getType().getValue());
    	logMsg.append("for array with " + type.toString() + " elements");
    	LOGGER.info(logMsg.toString());
	}

	private void notifyListeners(Performance performance, ArrayType type) {
		for (PerformanceListener listener : listeners) {
			listener.performanceCalculated(performance,type);
		}
	}

	public void setSortAlgorithms(List<SortAlgorithm> sortAlgorithms) {
		this.sortAlgorithms = sortAlgorithms;
	}

	public void setListeners(List<PerformanceListener> listeners) {
		this.listeners = listeners;
	}
    
}
