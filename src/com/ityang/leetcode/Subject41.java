package com.ityang.leetcode;

public class Subject41 {

	public static void main(String[] args) {
		System.out.println(firstMissingPositive(new int[]{3,4,-1,1}));

	}

	public static int firstMissingPositive(int[] nums) {
		if(nums.length==0)
			return 1;
		
		int len = nums.length,temp = 0;
		for(int i=0;i<len;i++){
			if(nums[i]==i+1 || nums[i]<=0 || nums[i]>len)
				continue;
			if(nums[nums[i]-1]!=nums[i]){
				
				temp = nums[i];
				nums[i] = nums[temp-1];
				nums[temp-1] = temp;
				i--;
			}	
		}
		int index = 0;
		for(;index<len;index++){
			if(nums[index]!=index+1)
				break;
		}
		return index+1;
	}
}
