package com.github.practice.sorting.chart.view;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import org.jfree.data.UnknownKeyException;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import com.github.practice.sorting.chart.view.pane.ChartViewTabbedPane;

@SuppressWarnings("serial")
public class ChartView extends JFrame {
	
	private XYSeriesCollection data = null;

	public ChartView(ChartViewTabbedPane tabbedPane) {
		super("Sorting algorithms performance");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setDefaultLookAndFeelDecorated(true);
        
        add(tabbedPane);
        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize.width / 2, screenSize.height / 2);
		pack();
		setLocationRelativeTo(null);

		setVisible(true);
	}

	public void addSeriesData(Comparable<String> key, int arraySize, long time) {
		XYSeries series;
		try {
			series = data.getSeries(key);
		} catch (UnknownKeyException e) {
			series = new XYSeries(key);
			data.addSeries(series);
		}
		series.add(arraySize, time);
	}
}
