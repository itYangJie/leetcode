package com.ityang.leetcode;

public class Subject26 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int removeDuplicates(int[] nums) {
		if(nums==null)
			return 0;
		if(nums.length==0 || nums.length==1)
			return nums.length;
		int duplicateIndex = 0,curIndex = 1,arrayLength = nums.length;
		while(curIndex<arrayLength){
			if(nums[curIndex] != nums[duplicateIndex])
				nums[++duplicateIndex] = nums[curIndex];
			curIndex++;
		}
		return duplicateIndex+1;
	}
}
