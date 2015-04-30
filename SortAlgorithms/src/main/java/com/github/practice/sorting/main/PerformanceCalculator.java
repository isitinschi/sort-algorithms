package com.github.practice.sorting.main;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.practice.sorting.algorithms.SortAlgorithm;
import com.github.practice.sorting.utils.producer.ArrayBuilder;
import com.github.practice.sorting.utils.producer.ArraySize;
import com.github.practice.sorting.utils.producer.ArrayType;

public class PerformanceCalculator {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PerformanceCalculator.class);

    public static void calculate(List<SortAlgorithm> listSortAlgorithm) {
        ArrayBuilder arrayBuilder = new ArrayBuilder();
        SimpleDateFormat format = new SimpleDateFormat("mm:ss");
        
        for (SortAlgorithm sortAlgorithm : listSortAlgorithm) {
        	LOGGER.info("Calculating performance for " + sortAlgorithm.getName() + ":");
            for (ArraySize size : ArraySize.values()) {
                for (ArrayType type : ArrayType.values()) {
                    int [] array = arrayBuilder.buildArrayProducer(type, size).produce();
                    long time = sortAlgorithm.sort(array);
                    LOGGER.info(format.format(new Date(time)) + "(" + size.toString() + ", " + type.toString() + ")");
                }
            }
        }
    }
}
