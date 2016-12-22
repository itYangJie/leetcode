package com.ityang.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class Subject239 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 4)));
	}

	public static int[] maxSlidingWindow(int[] nums, int k) {
		
		if(nums.length==0 || k>nums.length ||k==0)
			return new int[0];
		int[] res = new int[nums.length-k+1];
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		for(int i=0;i<k;i++){
			queue.add(-1*nums[i]);
		}
		res[0] = -1*queue.peek();
		for(int i=k;i<nums.length;i++){
			queue.remove(-1*nums[i-k]);
			queue.add(-1*nums[i]);
			res[i-k+1] = -1*queue.peek();
		}
		return res;
		
	}
}
