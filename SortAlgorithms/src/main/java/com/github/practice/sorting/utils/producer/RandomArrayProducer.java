package com.github.practice.sorting.utils.producer;

import java.util.Random;

public class RandomArrayProducer implements ArrayProducer {

    private int size;
    
    private static final Random randomGenerator = new Random();
    
    public RandomArrayProducer(int size) {
        this.size = size;
    }
    
    @Override
    public int[] produce() {
        int [] array = new int [size];
        
        for (int i = 0; i < size; ++i) {            
            array[i] = randomGenerator.nextInt(size);
        }
        
        return array;
    }

}
