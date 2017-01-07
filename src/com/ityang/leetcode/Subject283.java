package com.ityang.leetcode;

public class Subject283 {

	

	public static void moveZeroes(int[] nums) {
		if(nums==null || nums.length==0 || nums.length==1)
			return;
		int index = 0;
		for(int i=0;i<nums.length;i++)
			if(nums[i]!=0)
				nums[index++] = nums[i];
		for(int i=index;i<nums.length;i++)
			nums[i] = 0;
		return;
	}
}
