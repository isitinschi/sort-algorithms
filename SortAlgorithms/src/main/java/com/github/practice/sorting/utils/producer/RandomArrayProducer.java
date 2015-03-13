package com.github.practice.sorting.utils.producer;

import java.util.Random;

public class RandomArrayProducer implements ArrayProducer {

    private int size;
    
    public RandomArrayProducer(int size) {
        this.size = size;
    }
    
    @Override
    public int[] produce() {
        int [] array = new int [size];
        
        for (int i = 0; i < size; ++i) {
            Random randomGenerator = new Random();
            array[i] = randomGenerator.nextInt(size);
        }
        
        return array;
    }

}
