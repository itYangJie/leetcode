package com.ityang.leetcode;

public class Subject75 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public void sortColors(int[] nums) {
		
		int length = nums.length;
		if(length<=1)
			return;
		int zeroCount = 0,oneCount = 0,twoCount = 0;
		for(int i=0;i<length;i++){
			if(nums[i] == 0)
				zeroCount++;
			else if(nums[i] == 1)
				oneCount++;
			else
				twoCount++;
		}
		for(int i=0;i<zeroCount;i++)
			nums[i] = 0;
		int zeronAndOneCount = zeroCount+oneCount;
		for(int i=zeroCount;i<zeronAndOneCount;i++)
			nums[i] = 1;
		for(int i=zeroCount+oneCount;i<length;i++)
			nums[i] = 2;
		
	}
}
