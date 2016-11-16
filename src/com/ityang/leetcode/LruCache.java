package com.ityang.leetcode;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LruCache {

	public static void main(String[] args) {
		LruCache lruCache = new LruCache(1);
		lruCache.set(2, 1);
		System.out.println(lruCache.get(2));
		lruCache.set(3, 2);
		System.out.println(lruCache.get(2));
		System.out.println(lruCache.get(3));
		

	}

	
	private LruLinkedHashMap dataMap;

	public LruCache(int capacity) {
		
		this.dataMap = new LruLinkedHashMap(capacity, 0.75f, true,capacity);
	}

	public int get(int key) {

		if (dataMap.containsKey(key)) {
			return dataMap.get(key);
		} else
			return -1;
	}

	public void set(int key, int value) {
		dataMap.put(key, value);
	}

	class LruLinkedHashMap extends LinkedHashMap<Integer, Integer> {
		private int capacity;

		public LruLinkedHashMap(int initialCapacity, float loadFactor, boolean isLRU, int lruCapacity) {
			super(initialCapacity, loadFactor, true);
			this.capacity = lruCapacity;
		}

		@Override
		protected boolean removeEldestEntry(java.util.Map.Entry<Integer, Integer> eldest) {
			if (size() > capacity)
				return true;
			return false;
		}
	}
}
