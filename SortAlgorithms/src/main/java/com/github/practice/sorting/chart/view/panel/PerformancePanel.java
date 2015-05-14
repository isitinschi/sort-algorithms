package com.github.practice.sorting.chart.view.panel;

import java.awt.GridLayout;

import javax.swing.JPanel;

import com.github.practice.sorting.algorithm.SortAlgorithmType;
import com.github.practice.sorting.chart.view.chart.panel.PerformanceChartPanel;
import com.github.practice.sorting.chart.view.table.PerformanceTable;
import com.github.practice.sorting.utils.producer.ArrayType;

@SuppressWarnings("serial")
public class PerformancePanel extends JPanel {
	
	private PerformanceChartPanel performanceChartPanel;
	private PerformanceTable performanceTable;

	public PerformancePanel(PerformanceChartPanel performanceChartPanel, PerformanceTable performanceTable) {
		this.performanceChartPanel = performanceChartPanel;
		this.performanceTable = performanceTable;
		
		setLayout(new GridLayout(2, 1));
		
		add(performanceChartPanel);
		add(performanceTable);
	}	

	public void addData(SortAlgorithmType sortAlgorithmType, ArrayType arrayType, long value) {
		performanceChartPanel.addValue(value, sortAlgorithmType, arrayType);
		performanceTable.addData(sortAlgorithmType, arrayType, value);
	}

}
