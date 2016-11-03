package com.ityang.leetcode;

public class Subject27 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int removeElement(int[] nums, int val) {
		if(nums.length==0)
			return 0;
		int length = nums.length;
		int curIndex = 0,removeIndex = 0;
		while(curIndex<length){
			if(nums[curIndex]!=val)
				nums[removeIndex++] = nums[curIndex];
			curIndex++;
		}
		return removeIndex;
	}

}
