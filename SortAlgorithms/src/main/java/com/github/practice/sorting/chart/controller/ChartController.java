package com.github.practice.sorting.chart.controller;

import com.github.practice.sorting.algorithm.Performance;
import com.github.practice.sorting.chart.view.panel.PerformancePanel;
import com.github.practice.sorting.listener.PerformanceListener;
import com.github.practice.sorting.utils.producer.ArrayType;

public class ChartController implements PerformanceListener {
	
	private PerformancePanel timePanel = null;
	private PerformancePanel swapsPanel = null;
	private PerformancePanel comparisonsPanel = null;

	@Override
	public void performanceCalculated(Performance performance, int size, ArrayType type) {
		String key = performance.getType().getValue();
		timePanel.addData(key, type, size, performance.getTime());
		swapsPanel.addData(key, type, size, performance.getSwaps());
		comparisonsPanel.addData(key, type, size, performance.getComparisons());
	}

	public void setTimePanel(PerformancePanel timePanel) {
		this.timePanel = timePanel;
	}

	public void setSwapsPanel(PerformancePanel swapsPanel) {
		this.swapsPanel = swapsPanel;
	}

	public void setComparisonsPanel(PerformancePanel comparisonsPanel) {
		this.comparisonsPanel = comparisonsPanel;
	}
	
}
