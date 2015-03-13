package com.github.practise.sorting.main;
import org.junit.Assert;
import org.junit.Test;

import com.github.practice.sorting.algorithms.SortAlgorithm;
import com.github.practice.sorting.main.SortAlgorithms;
import com.github.practice.sorting.utils.producer.ArrayBuilder;
import com.github.practice.sorting.utils.producer.ArraySize;
import com.github.practice.sorting.utils.producer.ArrayType;


public class TestSortAlgorithms {

    @Test
    public void test() {
        ArrayBuilder arrayBuilder = new ArrayBuilder();
        for (SortAlgorithm sortAlgorithm : (new SortAlgorithms()).getSortAlgorithms()) {
            for (ArrayType type : ArrayType.values()) {
                int [] array = arrayBuilder.buildArrayProducer(type, ArraySize.HUNDRED_THOUSANDS).produce();
                sortAlgorithm.sort(array);
                Assert.assertTrue("Algorithm " + sortAlgorithm.getName() + "is failed!", isSorted(array));
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

}
