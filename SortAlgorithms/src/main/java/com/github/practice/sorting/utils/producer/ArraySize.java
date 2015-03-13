package com.github.practice.sorting.utils.producer;

public enum ArraySize {
    HUNDRED_THOUSANDS(100000), MILLION(1000000);//, TEN_MILLIONS(10000000), HUNDRED_MILLIONS(100000000), BILLION(1000000000);
    
    private int value;
    
    ArraySize(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
