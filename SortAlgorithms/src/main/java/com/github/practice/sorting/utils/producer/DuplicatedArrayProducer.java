package com.github.practice.sorting.utils.producer;

import java.util.Random;

public class DuplicatedArrayProducer implements ArrayProducer {

    private int size;
    
    private static final Random randomGenerator = new Random();
    
    public DuplicatedArrayProducer(int size) {
        this.size = size;
    }
    
    @Override
    public int[] produce() {
        int [] array = new int [size];
        
        for (int i = 0; i < size; ++i) {
        	int value = randomGenerator.nextInt(size);
        	int num = randomGenerator.nextInt(size / 100) + 10; // 10 <= num < size / 100
        	for (int j = i; j <= i + num; ++j) {
        		array[i] = value;        		
        	}
        	i = i + num;
        }
        
        softShuffle(array);
        
        return array;
    }

	private void softShuffle(int[] array) {
		for (int i = 0; i < size; ++i) {
			int a1 = randomGenerator.nextInt(size);
			int a2 = randomGenerator.nextInt(size);
			swap(array, a1, a2);
		}
	}

	private void swap(int[] array, int a1, int a2) {
		if (a1 != a2) {
			int temp = array[a1];
			array[a1] = array[a2];
			array[a2] = temp;
		}
	}

}
