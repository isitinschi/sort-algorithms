package com.github.practice.sorting.chart.view.table;

import java.awt.BorderLayout;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;

import com.github.practice.sorting.algorithm.SortAlgorithm;
import com.github.practice.sorting.algorithm.SortAlgorithmType;
import com.github.practice.sorting.algorithm.performance.ActualPerformanceCalculator;
import com.github.practice.sorting.algorithm.performance.ExpectedPerformanceCalculator;
import com.github.practice.sorting.algorithm.performance.PerformanceType;
import com.github.practice.sorting.utils.producer.ArrayType;

@SuppressWarnings("serial")
public class PerformanceTable extends JPanel {	

	private List<SortAlgorithm> sortAlgorithms;	
	private ExpectedPerformanceCalculator expectedPerformanceCalculator;
	
	private PerformanceType performanceType;
	private boolean hasExpectedColumn = true;
	private JTable table;
	
	public PerformanceTable(PerformanceType performanceType) {
		this.performanceType = performanceType;
		if (performanceType.equals(PerformanceType.TIME)) {
			hasExpectedColumn = false;
		}
	}
	
	@PostConstruct
	void populateTable() {
		String[] columnNames = populateColumnNames();
		Object[][] data = populateData();		
		table = new JTable(data, columnNames);
		
		JScrollPane scrollPane = new JScrollPane(table);
		table.setFillsViewportHeight(true);
		table.setEnabled(false);
		table.getColumnModel().getColumn(0).setCellRenderer(new CustomRenderer());
		
		setLayout(new BorderLayout());
		add(scrollPane, BorderLayout.CENTER);
	}

	private String[] populateColumnNames() {		
		String[] columnNames = new String[getColumnSize()];
		columnNames[0] = "";
		int index = 1;
		for (ArrayType arrayType : ArrayType.values()) {
			if (hasExpectedColumn) {
				columnNames[index++] = arrayType + " expected";
			}
			columnNames[index++] = arrayType + " actual";
		}
		return columnNames;
	}

	private Object[][] populateData() {
		Object[][] data = new Object[sortAlgorithms.size()][getColumnSize()];
		
		// populate sort algorithm types
		for (int i = 0; i < sortAlgorithms.size(); ++i) {
			data[i][0] = sortAlgorithms.get(i).getType().getValue();
		}
		
		if (hasExpectedColumn) {
			// populate expected performance
			for (int i = 0; i < sortAlgorithms.size(); ++i) {
				int columnIndex = 1;
				for (ArrayType arrayType : ArrayType.values()) {
					SortAlgorithmType sortAlgorithmType = sortAlgorithms.get(i).getType();
					data[i][columnIndex] = expectedPerformanceCalculator.calculateFor(performanceType, arrayType, sortAlgorithmType, ActualPerformanceCalculator.ARRAY_SIZE);
					columnIndex += 2;
				}
			}
		}
		
		return data;
	}
	
	private int getColumnSize() {
		int size;
		if (hasExpectedColumn) {
			size = 2 * ArrayType.values().length + 1;
		} else {
			size = ArrayType.values().length + 1;
		}
		return size;
	}
	
	public void addData(SortAlgorithmType sortAlgorithmType, ArrayType arrayType, long value) {
		for (int i = 0; i < sortAlgorithms.size(); ++i) {
			if (sortAlgorithms.get(i).getType().equals(sortAlgorithmType)) {
				int columnIndex = hasExpectedColumn ? 2 : 1;
				for (ArrayType type : ArrayType.values()) {
					if (type.equals(arrayType)) {
						table.getModel().setValueAt(value, i, columnIndex);
					}
					columnIndex += hasExpectedColumn ? 2 : 1;
				}
			}
		}
	}
	
    public void setSortAlgorithms(List<SortAlgorithm> sortAlgorithms) {
		this.sortAlgorithms = sortAlgorithms;
	}

	public void setExpectedPerformanceCalculator(
			ExpectedPerformanceCalculator expectedPerformanceCalculator) {
		this.expectedPerformanceCalculator = expectedPerformanceCalculator;
	}

	private static class CustomRenderer extends DefaultTableCellRenderer {

        public CustomRenderer(){
            super();
            setBackground(UIManager.getColor("TableHeader.background"));
        }
    }
	
}
