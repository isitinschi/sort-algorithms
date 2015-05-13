package com.github.practice.sorting.utils.producer;

import java.util.HashMap;
import java.util.Map;

public class ArrayBuilder {
    
    private Map<ArrayType, AbstractArrayProducer> arrayProducerCache;

    public ArrayBuilder() {
        arrayProducerCache = new HashMap<ArrayType, AbstractArrayProducer>();
        for (ArrayType type : ArrayType.values()) {
        	AbstractArrayProducer arrayProducer = null;
			if (type == ArrayType.RANDOM) {
				arrayProducer = new RandomArrayProducer();
			} else if (type == ArrayType.ASC) {
				arrayProducer = new AscArrayProducer();
			} else if (type == ArrayType.DESC) {
				arrayProducer = new DescArrayProducer();
			} else if (type == ArrayType.DUPLICATED) {
				arrayProducer = new DuplicatedArrayProducer();
			}
			arrayProducerCache.put(type, arrayProducer);
        }
    }
    
    public int [] build(ArrayType type, int size) {
        return arrayProducerCache.get(type).produce(size);
    }
}
