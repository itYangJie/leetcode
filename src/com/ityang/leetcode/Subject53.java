package com.ityang.leetcode;

public class Subject53 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
	}

	public static int maxSubArray(int[] nums) {
		if(nums.length == 0)
			return 0;
		if(nums.length == 1)
			return nums[0];
		int len = nums.length;
		int maxSum = nums[0],tempSum = maxSum;
		for(int i=1;i<len;i++){
			
			if(tempSum > 0){
				tempSum += nums[i];
			}else{
				tempSum = nums[i];
			}
			maxSum = Math.max(maxSum, tempSum);
		}
		return maxSum;
	}
}
