package com.ityang.leetcode;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFinder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MedianFinder medianFinder = new MedianFinder();
		medianFinder.addNum(-1);
		medianFinder.addNum(-2);
		medianFinder.addNum(-3);

		System.out.println(medianFinder.findMedian());
		medianFinder.addNum(3);
		System.out.println(medianFinder.findMedian());
		
		
	}

	private PriorityQueue<Integer> min = new PriorityQueue();
    private PriorityQueue<Integer> max = new PriorityQueue(1000, Collections.reverseOrder());
    // Adds a number into the data structure.
    public void addNum(int num) {
        max.offer(num);
        min.offer(max.poll());
        if (max.size() < min.size()){
            max.offer(min.poll());
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        if (max.size() == min.size()) return (max.peek() + min.peek()) /  2.0;
        else return max.peek();
    }
}
