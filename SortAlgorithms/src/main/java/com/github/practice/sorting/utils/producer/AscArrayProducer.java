package com.github.practice.sorting.utils.producer;

public class AscArrayProducer implements ArrayProducer {

    private int size;
    
    public AscArrayProducer(int size) {
        this.size = size;
    }
    
    @Override
    public int[] produce() {
        int [] array = new int [size];
        
        for (int i = 0; i < size; ++i) {
            array[i] = i;
        }        
        
        return array;
    }

}
