package com.github.practice.sorting.main;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.github.practice.sorting.algorithms.SortAlgorithm;
import com.github.practice.sorting.utils.producer.ArrayBuilder;
import com.github.practice.sorting.utils.producer.ArraySize;
import com.github.practice.sorting.utils.producer.ArrayType;

public class PerformanceCalculator {

    public static void calculate(List<SortAlgorithm> listSortAlgorithm) {
        ArrayBuilder arrayBuilder = new ArrayBuilder();
        SimpleDateFormat format = new SimpleDateFormat("mm:ss");
        for (SortAlgorithm sortAlgorithm : listSortAlgorithm) {
            System.out.print(sortAlgorithm.getName() + ":");
            for (ArraySize size : ArraySize.values()) {
                System.out.print(" ");
                for (ArrayType type : ArrayType.values()) {
                    int [] array = arrayBuilder.buildArrayProducer(type, size).produce();
                    long time = sortAlgorithm.sort(array);
                    System.out.print(format.format(new Date(time)) + "(" + size.toString() + ", " + type.toString() + ")");
                }
            }
            System.out.println();
        }
    }
}
