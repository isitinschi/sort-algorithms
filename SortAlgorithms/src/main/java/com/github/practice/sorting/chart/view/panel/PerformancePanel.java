package com.github.practice.sorting.chart.view.panel;

import java.awt.GridLayout;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.UnknownKeyException;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import com.github.practice.sorting.algorithm.SortAlgorithmType;
import com.github.practice.sorting.utils.producer.ArrayType;

@SuppressWarnings("serial")
public class PerformancePanel extends JPanel {
	
	private XYSeriesCollection ascData = new XYSeriesCollection();
	private XYSeriesCollection descData = new XYSeriesCollection();
	private XYSeriesCollection randomData = new XYSeriesCollection();
	private XYSeriesCollection duplicatedData = new XYSeriesCollection();

	public PerformancePanel(String name) {
		setLayout(new GridLayout(2, 2));
		
		add(geChart(name, "ASC", ascData));
		add(geChart(name, "DESC", descData));
		add(geChart(name, "RANDOM", randomData));
		add(geChart(name, "DUPLICATED", duplicatedData));
	}
	
	private ChartPanel geChart(String name, String type, XYSeriesCollection data) {
		final JFreeChart chart = ChartFactory.createXYLineChart(
			type,
            "Array size", 
            name, 
            data,
            PlotOrientation.VERTICAL,
            true,
            true,
            false
        );

        final XYPlot plot = (XYPlot) chart.getPlot();
        final NumberAxis axis = (NumberAxis) plot.getRangeAxis();
        axis.setAutoRangeIncludesZero(false);
        axis.setAutoRangeMinimumSize(1.0);
        final ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
        
        return chartPanel;
	}

	public void addData(String key, ArrayType type, int x, long y) {
		XYSeriesCollection data = getDataByType(type);
		XYSeries series;
		try {
			series = data.getSeries(key);
		} catch (UnknownKeyException e) {
			series = new XYSeries(key);
			data.addSeries(series);
		}
		series.add(x, y);
	}
	
	private XYSeriesCollection getDataByType(ArrayType type) {
		switch(type) {
			case ASC:
				return ascData;
			case DESC:
				return descData;
			case RANDOM:
				return randomData;
			case DUPLICATED:
				return duplicatedData;
			default: return null;
		}
	}

}
