package com.github.practice.sorting.main;

import java.util.ArrayList;
import java.util.List;

import com.github.practice.sorting.algorithms.BubbleSortAlgorithm;
import com.github.practice.sorting.algorithms.SortAlgorithm;

public class SortAlgorithms {
    
    private List<SortAlgorithm> listSortAlgorithm;
    
    public SortAlgorithms() {
        listSortAlgorithm = new ArrayList<SortAlgorithm>();
        listSortAlgorithm.add(new BubbleSortAlgorithm());
    }

    public static void main(String[] args) {
        SortAlgorithms sortAlgorithms = new SortAlgorithms();
        PerformanceCalculator.calculate(sortAlgorithms.getSortAlgorithms());
    }
    
    public List<SortAlgorithm> getSortAlgorithms() {
        return listSortAlgorithm;
    }

}
