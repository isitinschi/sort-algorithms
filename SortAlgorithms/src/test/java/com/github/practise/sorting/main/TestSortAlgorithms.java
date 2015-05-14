package com.github.practise.sorting.main;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.github.practice.sorting.algorithm.SortAlgorithm;
import com.github.practice.sorting.utils.producer.ArrayBuilder;
import com.github.practice.sorting.utils.producer.ArrayType;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:cfg-ApplicationContext.xml")
public class TestSortAlgorithms {
	
	private static final int ARRAY_SIZE = 100;

	@Resource
	private List<SortAlgorithm> sortAlgorithms;
	
    @Test
    public void test() {
        ArrayBuilder arrayBuilder = new ArrayBuilder();
        for (SortAlgorithm sortAlgorithm : sortAlgorithms) {
            for (ArrayType type : ArrayType.values()) {
                int [] array = arrayBuilder.build(type, ARRAY_SIZE);
                sortAlgorithm.sort(array);
                String errorMsg = "Algorithm " + sortAlgorithm.getType() + " for array with " + ARRAY_SIZE + " " + type + " elements is failed!";
                Assert.assertTrue(errorMsg, isSorted(array));
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

	public void setSortAlgorithms(List<SortAlgorithm> sortAlgorithms) {
		this.sortAlgorithms = sortAlgorithms;
	}

}
