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
import com.github.practice.sorting.utils.producer.ArraySize;
import com.github.practice.sorting.utils.producer.ArrayType;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:cfg-ApplicationContext.xml")
public class TestSortAlgorithms {

	@Resource
	private List<SortAlgorithm> sortAlgorithms;
	
    @Test
    public void test() {
        ArrayBuilder arrayBuilder = new ArrayBuilder();
        ArraySize size = ArraySize.THOUSAND;
        for (SortAlgorithm sortAlgorithm : sortAlgorithms) {
            for (ArrayType type : ArrayType.values()) {
                int [] array = arrayBuilder.buildArrayProducer(type, size).produce();
                sortAlgorithm.sort(array);
                Assert.assertTrue("Algorithm " + sortAlgorithm.getType().getValue() + "(" + size.toString() + ", " + type.toString() + ") is failed!", isSorted(array));
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
