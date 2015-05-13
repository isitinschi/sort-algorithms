package com.github.practice.sorting.main;

import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.practice.sorting.algorithm.Performance;
import com.github.practice.sorting.algorithm.SortAlgorithm;
import com.github.practice.sorting.listener.PerformanceListener;
import com.github.practice.sorting.utils.producer.ArrayBuilder;
import com.github.practice.sorting.utils.producer.ArrayType;

public class PerformanceCalculator {
	
	private static final int INITIAL_ARRAY_SIZE = 1000;
	private static final int FINAL_ARRAY_SIZE = 100000;
	private static final int ARRAY_SIZE_STEP = 1000;
	
	private List<SortAlgorithm> sortAlgorithms;	
	private List<PerformanceListener> listeners;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PerformanceCalculator.class);

	@PostConstruct
    public void calculate() {
        ArrayBuilder arrayBuilder = new ArrayBuilder();
        
        for (int size = INITIAL_ARRAY_SIZE; size <= FINAL_ARRAY_SIZE; size += ARRAY_SIZE_STEP) {
        	for (SortAlgorithm sortAlgorithm : sortAlgorithms) {
                for (ArrayType type : ArrayType.values()) {
                    int [] array = arrayBuilder.build(type, size);
                    Performance performance = sortAlgorithm.sort(array);
                    notifyListeners(performance, size, type);
                    printLog(sortAlgorithm, size, type);
                }
            }
        }
    }
    
    private void printLog(SortAlgorithm sortAlgorithm, int size, ArrayType type) {
    	StringBuilder logMsg = new StringBuilder("Calculated performance for ");
    	logMsg.append(sortAlgorithm.getType().getValue());
    	logMsg.append("for array with " + size + " " + type.toString() + " elements");
    	LOGGER.info(logMsg.toString());
	}

	private void notifyListeners(Performance performance, int size, ArrayType type) {
		for (PerformanceListener listener : listeners) {
			listener.performanceCalculated(performance, size, type);
		}
	}

	public void setSortAlgorithms(List<SortAlgorithm> sortAlgorithms) {
		this.sortAlgorithms = sortAlgorithms;
	}

	public void setListeners(List<PerformanceListener> listeners) {
		this.listeners = listeners;
	}
    
}
