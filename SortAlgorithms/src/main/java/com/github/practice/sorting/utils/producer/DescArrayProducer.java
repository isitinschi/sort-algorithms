package com.github.practice.sorting.utils.producer;

public class DescArrayProducer implements ArrayProducer {

    private int size;
    
    public DescArrayProducer(int size) {
        this.size = size;
    }
    
    @Override
    public int[] produce() {
        int [] array = new int [size];
        
        for (int i = 0; i < size; ++i) {
            array[i] = size - 1 - i;
        }        
        
        return array;
    }

}
