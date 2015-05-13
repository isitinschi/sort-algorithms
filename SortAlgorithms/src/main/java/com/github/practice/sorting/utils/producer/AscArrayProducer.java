package com.github.practice.sorting.utils.producer;

public class AscArrayProducer extends AbstractArrayProducer {
    
    @Override
    public int[] generate(int size) {
        int [] array = new int [size];
        
        for (int i = 0; i < size; ++i) {
            array[i] = i;
        }        
        
        return array;
    }

}
