package com.github.practice.sorting.utils.producer;

import java.util.Random;

public class RandomArrayProducer extends AbstractArrayProducer {
    
    private static final Random randomGenerator = new Random();
    
    @Override
    protected int[] generate(int size) {
        int [] array = new int [size];
        
        for (int i = 0; i < size; ++i) {            
            array[i] = randomGenerator.nextInt(size);
        }
        
        return array;
    }

}
