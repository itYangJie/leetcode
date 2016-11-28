package com.ityang.leetcode;

public class Subject198 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(rob(new int[]{0,300,1,400,33,2}));
	}

	public static int rob(int[] nums) {
		// 1 43 42 4324 4 454 54 34 34
		if(nums.length==0)
			return 0;
		if(nums.length==1)
			return nums[0];
		int[] dp = new int[nums.length+1];
		dp[0] = 0;
		dp[1] = nums[0];
		int len = dp.length;
		for(int i=2;i<len;i++)
			dp[i] = Math.max(dp[i-1], nums[i-1]+dp[i-2]);
			
		return dp[len-1];
	}
}
