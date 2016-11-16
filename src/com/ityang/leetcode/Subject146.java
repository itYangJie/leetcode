package com.ityang.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Subject146 {
	
	
	public static void main(String[] args) {
		Subject146 lruCache = new Subject146(1);
		lruCache.set(2, 1);
		System.out.println(lruCache.get(2));
		lruCache.set(3, 2);
		System.out.println(lruCache.get(2));
		System.out.println(lruCache.get(3));
		System.out.println("size "+lruCache.size);
	}
	private int capacity;
	private int size = 0;
	private Map<Integer, Integer> dataMap;
	private ListNode font = new ListNode(-1), tail = font;

	public Subject146(int capacity) {
		this.capacity = capacity;
		this.dataMap = new HashMap<>();
	}

	public int get(int key) {

		if (dataMap.containsKey(key)) {
			haveVisit(key);
			return dataMap.get(key);
		} else
			return -1;
	}

	public void set(int key, int value) {

		if (dataMap.containsKey(key)) {
			dataMap.put(key, value);
			haveVisit(key);
		} else {
			if (size >= capacity) {
				int removeKey = removeLru();
				dataMap.remove(removeKey);
				size--;
			}
			
			haveVisit(key);
			dataMap.put(key, value);
			size++;
		}

	}

	private int removeLru() {
		int key = font.next.key;
		if(font.next == tail)
			tail = font;
		font.next = font.next.next;
		
		return key;
	}

	private void haveVisit(int key) {

		if (dataMap.containsKey(key)) {
			ListNode cur = font;
			while (cur.next.key != key)
				cur = cur.next;
			if(cur.next!=tail){
				ListNode temp = cur.next;
				cur.next = cur.next.next;
				tail.next = temp;
				temp.next = null;
				tail = temp;
			}
			
		} else {
			tail.next = new ListNode(key);
			tail = tail.next;
		}

	}

	class ListNode {
		int key;
		ListNode next;

		ListNode(int key) {
			this.key = key;
		}
	}
}
