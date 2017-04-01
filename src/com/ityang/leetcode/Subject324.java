package com.ityang.leetcode;

import java.util.Arrays;

public class Subject324 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		wiggleSort(new int[]{1,3,432,1,32,434,32,43});
		//swap(new int[]{1,3,432,1,32,434,32,43,324},0,5);

	}

	public static void wiggleSort(int[] nums) {
		if(nums==null || nums.length<=1)
			return;
		int start = nums.length-nums.length/2;
		findKth(nums,0,nums.length-1,start);
		//System.out.println(Arrays.toString(nums));
		for(int i=start;i<nums.length;i++){
			swap(nums,i,2*(i-start)+1);
		}
		System.out.println(Arrays.toString(nums));

	}
	private static void swap(int[] nums,int i, int j) {
		//nums[i] = nums[i]^nums[j];
		//nums[j] = nums[j]^nums[i];
		//nums[i] = nums[i]^nums[j];
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	private static void findKth(int[] nums, int left, int right, int k) {
		if (left < right) {
			int index = partration(nums, left, right);
			if (index == k - 1)
				return;
			else if (index > k - 1)
				findKth(nums, left, index - 1, k);
			else
				findKth(nums, index + 1, right, k);
		}
	}

	private static int partration(int[] nums, int left, int right) {
		int mainEle = nums[left];
		while (left < right) {
			while (left < right && nums[right] > mainEle)
				right--;
			nums[left] = nums[right];
			while (left < right && nums[left] <= mainEle)
				left++;
			nums[right] = nums[left];
		}
		nums[left] = mainEle;
		return left;
	}
}
