package com.github.practice.sorting.utils.producer;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractArrayProducer {
    
	private Map<Integer, int []> arrayCache;
	
	public AbstractArrayProducer() {
		arrayCache = new HashMap<Integer, int []>();
	}
	
    public int [] produce(int size) {
    	int [] array = arrayCache.get(size);
    	if (array == null) {
    		array = generate(size);
    		arrayCache.put(size, array);
    	}
    	
    	return array;
    }
    
    protected abstract int [] generate(int size);
    
}
