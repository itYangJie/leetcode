package com.ityang.leetcode;

import com.ityang.leetcode.Subject95.TreeNode;

public class Subject96 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int numTrees(int n) {
		if(n<=0)
			return 0;
		if(n==1)
			return 1;
		
		int dp[] = new int[n+1];
		dp[0] = 1;
		for(int i=1;i<=n;i++){
			for(int j=1;j<=i;j++){
				dp[i] += (dp[j-1]*dp[i-j]);
			}
		}
		return dp[n];
	}

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
}
