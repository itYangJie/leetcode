package com.ityang.leetcode;

public class Subject64 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int minPathSum(int[][] grid) {
		int m = grid.length;
		if (m == 0)
			return 0;
		int n = grid[0].length;
		if (n == 0)
			return 0;
		int[][] dp = new int[m][n];

		/*for (int i = m - 1; i >= 0; i--)
			for (int j = n - 1; j >= 0; j--) {
				dp[i][j] = 0;
			}*/

		
		    dp[m-1][n-1] = grid[m-1][n-1];
		
		for (int i = m - 1; i >= 0; i--)
			for (int j = n - 1; j >= 0; j--) {
					if(i==m-1 && j==n-1)
						continue;
					int min = Integer.MAX_VALUE;
					if (i + 1 < m) {
						min = Math.min(min, dp[i + 1][j]);
					}
					if (j + 1 < n) {
						min = Math.min(min, dp[i][j+1]);
					}
					dp[i][j] = min+grid[i][j];
			}
		return dp[0][0];
	}
}
