package com.github.practice.sorting.chart.view;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import com.github.practice.sorting.chart.view.pane.ChartViewTabbedPane;

@SuppressWarnings("serial")
public class PerformanceView extends JFrame {

	public PerformanceView(ChartViewTabbedPane tabbedPane) {
		super("Sorting algorithms performance");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setDefaultLookAndFeelDecorated(true);
		setExtendedState(JFrame.MAXIMIZED_BOTH); 
		
        add(tabbedPane);
        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize.width, screenSize.height);
		pack();
		setLocationRelativeTo(null);

		setVisible(true);
	}
	
}
