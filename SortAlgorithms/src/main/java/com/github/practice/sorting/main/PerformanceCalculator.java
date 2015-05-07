package com.github.practice.sorting.main;

import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.practice.sorting.algorithm.Performance;
import com.github.practice.sorting.algorithm.SortAlgorithm;
import com.github.practice.sorting.listener.PerformanceListener;
import com.github.practice.sorting.utils.producer.ArrayBuilder;
import com.github.practice.sorting.utils.producer.ArraySize;
import com.github.practice.sorting.utils.producer.ArrayType;

public class PerformanceCalculator {
	
	private List<SortAlgorithm> sortAlgorithms;	
	private List<PerformanceListener> listeners;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PerformanceCalculator.class);

	@PostConstruct
    public void calculate() {
        ArrayBuilder arrayBuilder = new ArrayBuilder();
        
        for (SortAlgorithm sortAlgorithm : sortAlgorithms) {
        	printLog(sortAlgorithm);        	
            for (ArraySize size : ArraySize.values()) {
                for (ArrayType type : ArrayType.values()) {
                    int [] array = arrayBuilder.buildArrayProducer(type, size).produce();
                    Performance performance = sortAlgorithm.sort(array);
                    notifyListeners(performance, size, type);
                }
            }
        }
    }
    
    private void printLog(SortAlgorithm sortAlgorithm) {
    	StringBuilder logMsg = new StringBuilder("Calculating performance for ");
    	logMsg.append(sortAlgorithm.getType().getValue());
    	LOGGER.info(logMsg.toString());
	}

	private void notifyListeners(Performance performance, ArraySize size, ArrayType type) {
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
