package com.github.practice.sorting.utils.producer;

import java.util.HashMap;
import java.util.Map;


public class ArrayBuilder {
    
    private Map<ArrayType, Map<ArraySize, ArrayProducer>> arrayProducerCache;

    public ArrayBuilder() {
        arrayProducerCache = new HashMap<ArrayType, Map<ArraySize, ArrayProducer>>();
        for (ArrayType type : ArrayType.values()) {
            arrayProducerCache.put(type, new HashMap<ArraySize, ArrayProducer>());
            for (ArraySize size : ArraySize.values()) {
                ArrayProducer arrayProducer = null;
                if (type == ArrayType.RANDOM) {
                    arrayProducer = new RandomArrayProducer(size.getValue());            
                } else if (type == ArrayType.ASC) {
                    arrayProducer = new AscArrayProducer(size.getValue());
                } else if (type == ArrayType.DESC) {
                    arrayProducer = new DescArrayProducer(size.getValue());
                }
                arrayProducerCache.get(type).put(size, arrayProducer);
            }
        }
    }
    
    public ArrayProducer buildArrayProducer(ArrayType type, ArraySize size) {
        return arrayProducerCache.get(type).get(size);
    }
}
