package com.github.practice.sorting.chart.view.panel;

import java.awt.GridLayout;

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
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.util.SortOrder;

import com.github.practice.sorting.utils.producer.ArrayType;

@SuppressWarnings("serial")
public class PerformancePanel extends JPanel {
	
	private DefaultCategoryDataset  ascDataset = new DefaultCategoryDataset ();
	private DefaultCategoryDataset  descDataset = new DefaultCategoryDataset ();
	private DefaultCategoryDataset  randomDataset = new DefaultCategoryDataset ();
	private DefaultCategoryDataset  duplicatedDataset = new DefaultCategoryDataset ();

	public PerformancePanel(String name) {
		setLayout(new GridLayout(2, 2));
		
		add(geChart(name, "ASC", ascDataset));
		add(geChart(name, "DESC", descDataset));
		add(geChart(name, "RANDOM", randomDataset));
		add(geChart(name, "DUPLICATED", duplicatedDataset));
	}
	
	private ChartPanel geChart(String valueLabel, String type, CategoryDataset dataset) {
		final JFreeChart chart = ChartFactory.createBarChart3D(
			type,
			"", 
			valueLabel, 
            dataset,
            PlotOrientation.VERTICAL,
            true,
            true,
            false
        );

		final CategoryPlot plot = chart.getCategoryPlot();
		plot.setRowRenderingOrder(SortOrder.DESCENDING);
        final CategoryAxis axis = plot.getDomainAxis();
        axis.setCategoryLabelPositions(
            CategoryLabelPositions.createUpRotationLabelPositions(Math.PI / 8.0)
        );
        
        final CategoryItemRenderer renderer = plot.getRenderer();
        renderer.setBaseItemLabelsVisible(true);
        final BarRenderer r = (BarRenderer) renderer;
        r.setMaximumBarWidth(0.05);
        
        final ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
        
        return chartPanel;
	}

	public void addData(String key, ArrayType type, long value) {
		DefaultCategoryDataset dataset = getDataByType(type);
		dataset.addValue(value, key, "");
	}
	
	private DefaultCategoryDataset getDataByType(ArrayType type) {
		switch(type) {
			case ASC:
				return ascDataset;
			case DESC:
				return descDataset;
			case RANDOM:
				return randomDataset;
			case DUPLICATED:
				return duplicatedDataset;
			default: return null;
		}
	}

}
