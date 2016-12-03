package com.ityang.leetcode;

public class Subject213 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(rob(new int[]{1,1}));
	}

	public static int rob(int[] nums) {
		 // 1 432 54 3 3 45 34 4
		if(nums.length==0)
			return 0;
		if(nums.length==1)
			return nums[0];
		if(nums.length==2)
			return Math.max(nums[0],nums[1]);
		
		int dp[] = new int[nums.length+1],max = Integer.MIN_VALUE;
		dp[0] = 0;
		dp[1] = nums[0];
		for(int i=2;i<nums.length;i++){
			dp[i] = Math.max(nums[i-1]+dp[i-2], dp[i-1]);
		}
		max = Math.max(max, dp[nums.length-1]);
		
		dp[1] = 0;
		dp[2] = nums[1];
		for(int i=3;i<nums.length-1;i++){
			dp[i] = Math.max(nums[i-1]+dp[i-2], dp[i-1]);
		}
		max = Math.max(max, dp[nums.length-2]+nums[nums.length-1]);
    	return max==Integer.MIN_VALUE?0:max;
	}
}
