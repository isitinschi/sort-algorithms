package com.github.practice.sorting.main;

import java.util.ArrayList;
import java.util.List;

import com.github.practice.sorting.algorithms.BubbleSortAlgorithm;
import com.github.practice.sorting.algorithms.DualPivotQuickSortAlgorithm;
import com.github.practice.sorting.algorithms.InsertionSortAlgorithm;
import com.github.practice.sorting.algorithms.MergeSortAlgorithm;
import com.github.practice.sorting.algorithms.QuickSortAlgorithm;
import com.github.practice.sorting.algorithms.SelectSortAlgorithm;
import com.github.practice.sorting.algorithms.SortAlgorithm;
import com.github.practice.sorting.algorithms.ThreeWayPartitionQuickSortAlgorithm;

public class SortAlgorithms {
    
    private List<SortAlgorithm> listSortAlgorithm;
    
    public SortAlgorithms() {
        listSortAlgorithm = new ArrayList<SortAlgorithm>();
        listSortAlgorithm.add(new DualPivotQuickSortAlgorithm());
        listSortAlgorithm.add(new ThreeWayPartitionQuickSortAlgorithm());
        listSortAlgorithm.add(new QuickSortAlgorithm());
        listSortAlgorithm.add(new MergeSortAlgorithm());
        listSortAlgorithm.add(new InsertionSortAlgorithm());
        listSortAlgorithm.add(new SelectSortAlgorithm());
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
