package com.ityang.leetcode;

public class Subject268 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(missingNumber(new int[]{0,1,5,3,4}));
	}
	
	// 0,1,2,3,5
	public static int missingNumber(int[] nums) {
		
		int temp;
		for(int i=0;i<nums.length;i++){
			
			while(nums[i]!=i && nums[i]<nums.length){
				temp = nums[i];
				nums[i] = nums[temp];
				nums[temp] = temp;
			}
			
		}
		for(int i=0;i<nums.length;i++){
			if(nums[i]!=i)
				return i;
		}
		return nums.length;
	}

	
}
