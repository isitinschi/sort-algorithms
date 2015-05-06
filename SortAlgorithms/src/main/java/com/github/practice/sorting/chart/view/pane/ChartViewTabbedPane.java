package com.github.practice.sorting.chart.view.pane;

import javax.swing.JTabbedPane;

import com.github.practice.sorting.chart.view.panel.PerformancePanel;

@SuppressWarnings("serial")
public class ChartViewTabbedPane extends JTabbedPane {
	
	public ChartViewTabbedPane(PerformancePanel timePanel, PerformancePanel swapsPanel,PerformancePanel comparisonsPanel) {
		addTab("Time", timePanel);
		addTab("Swaps", swapsPanel);
		addTab("Comparisons", comparisonsPanel);
	}
	
}
