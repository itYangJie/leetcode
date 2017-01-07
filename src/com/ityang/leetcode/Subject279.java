package com.ityang.leetcode;

public class Subject279 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(numSquares(12));
	}

	public static int numSquares(int n) {
		
		int dp[] = new int[n+1];
		dp[1] = 1;
		for(int data=2;data<=n;data++){
			int i = (int) Math.sqrt(data);
			int min = Integer.MAX_VALUE;
			for(int j=i;j>=1;j--){
				min = Math.min(min,dp[data-j*j]);
			}
			dp[data] = min+1;
		}
		return dp[n];
	}
}
