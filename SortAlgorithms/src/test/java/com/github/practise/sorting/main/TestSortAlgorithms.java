package com.github.practise.sorting.main;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.practice.sorting.algorithm.SortAlgorithm;
import com.github.practice.sorting.utils.producer.ArrayBuilder;
import com.github.practice.sorting.utils.producer.ArraySize;
import com.github.practice.sorting.utils.producer.ArrayType;

public class TestSortAlgorithms {

	@Autowired
	private List<SortAlgorithm> sortAlgorithmsList;
	
    @Test
    public void test() {
        ArrayBuilder arrayBuilder = new ArrayBuilder();
        ArraySize size = ArraySize.THOUSAND;
        for (SortAlgorithm sortAlgorithm : sortAlgorithmsList) {
            for (ArrayType type : ArrayType.values()) {
                int [] array = arrayBuilder.buildArrayProducer(type, size).produce();
                sortAlgorithm.sort(array);
                Assert.assertTrue("Algorithm " + sortAlgorithm.getName() + "(" + size.toString() + ", " + type.toString() + ") is failed!", isSorted(array));
            }
        }
    }

    private boolean isSorted(int[] array) {
        for (int i = 0; i < array.length - 1; ++i) {
            if (array[i] > array[i + 1]) {
                return false;
            }
        }
        
        return true;
    }

	public void setSortAlgorithmsList(List<SortAlgorithm> sortAlgorithmsList) {
		this.sortAlgorithmsList = sortAlgorithmsList;
	}

}
