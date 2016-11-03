package com.ityang.leetcode;

import java.util.Arrays;

public class Subject31 {

	public static void main(String[] args) {
		

	}

	public static void nextPermutation(int[] nums) {
		if(nums.length<=1)
			return ;
		
		int index1 = nums.length-2;
		while(index1>=0 && nums[index1]>=nums[index1+1]){
			index1--;
		}
		if(index1<0){
			reverse(nums,0,nums.length-1);
			return ;
		}
		int index2 = nums.length-1;
		while(nums[index2]<=nums[index1])
			index2--;
		int temp = nums[index1];
		nums[index1] = nums[index2];
		nums[index2] = temp;
		reverse(nums,index1+1,nums.length-1);
		
	}

	private static void reverse(int[] nums, int start, int end) {
		if(start<0 || end>=nums.length || start>=end)
			return;
		int temp = 0;
		while(start<end){
			temp = nums[start];
			nums[start] = nums[end];
			nums[end] = temp;
			start++;
			end--;
		}
		
	}
}
