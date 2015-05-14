package com.github.practice.sorting.chart.view.chart.panel;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

import com.github.practice.sorting.algorithm.SortAlgorithmType;
import com.github.practice.sorting.algorithm.performance.PerformanceType;
import com.github.practice.sorting.utils.producer.ArrayType;

@SuppressWarnings("serial")
public class PerformanceChartPanel extends JPanel {
	
	private DefaultCategoryDataset dataset;

	public PerformanceChartPanel(PerformanceType performanceType, DefaultCategoryDataset dataset) {
		this.dataset = dataset;
		
		final JFreeChart chart = ChartFactory.createBarChart3D(
				"",
				"", 
				performanceType.getValue(), 
	            dataset,
	            PlotOrientation.VERTICAL,
	            true,
	            true,
	            false
	        );

			final CategoryPlot plot = chart.getCategoryPlot();
	        final CategoryAxis axis = plot.getDomainAxis();
	        axis.setCategoryLabelPositions(
	            CategoryLabelPositions.createUpRotationLabelPositions(Math.PI / 8.0)
	        );
	        
	        final CategoryItemRenderer renderer = plot.getRenderer();
	        renderer.setBaseItemLabelsVisible(true);
	        final BarRenderer r = (BarRenderer) renderer;
	        r.setMaximumBarWidth(0.05);
	        
	        final ChartPanel chartPanel = new ChartPanel(chart);
	        setLayout(new BorderLayout());
	        add(chartPanel, BorderLayout.CENTER);
	}

	public void addValue(long value, SortAlgorithmType sortAlgorithmType, ArrayType arrayType) {
		dataset.addValue(value, sortAlgorithmType, arrayType); 
	}

}
