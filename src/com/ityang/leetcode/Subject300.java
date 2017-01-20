package com.ityang.leetcode;

public class Subject300 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
	}
	//   [10, 9, 2, 5, 3, 7, 101, 18],
	public static int lengthOfLIS(int[] nums) {
		if(nums.length<=1)
			return nums.length;
		int dp[] = new int[nums.length],res = 0;
		dp[0] = 1;
		for(int i=1;i<nums.length;i++){
			int max = 0;
			for(int j=0;j<i;j++){
				if(nums[j]<nums[i] && dp[j]>max)
					max = dp[j];
			}
			dp[i] = max+1;
			res = Math.max(res, dp[i]);
		}
		
		return res;
		
		
	}
}
