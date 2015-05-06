package com.github.practice.sorting.chart.controller;

import com.github.practice.sorting.algorithm.Performance;
import com.github.practice.sorting.chart.view.panel.PerformancePanel;
import com.github.practice.sorting.listener.PerformanceListener;
import com.github.practice.sorting.utils.producer.ArraySize;
import com.github.practice.sorting.utils.producer.ArrayType;

public class ChartController implements PerformanceListener {
	
	private PerformancePanel timePanel = null;
	private PerformancePanel swapsPanel = null;
	private PerformancePanel comparisonsPanel = null;

	@Override
	public void performanceCalculated(Performance performance, ArraySize size, ArrayType type) {
		timePanel.addData(type, performance.getName(), size.getValue(), performance.getTime());
		swapsPanel.addData(type, performance.getName(), size.getValue(), performance.getSwaps());
		comparisonsPanel.addData(type, performance.getName(), size.getValue(), performance.getComparisons());
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
