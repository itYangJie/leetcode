package com.ityang.leetcode;

public class Subject63 {

	public static void main(String[] args) {
		System.out.println(uniquePathsWithObstacles(new int[][] { 
			{ 0, 0, 0 },
			{ 1, 1, 0 }, 
			{ 0, 0, 1 } }));

	}

	public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int m = obstacleGrid.length;
		if (m == 0)
			return 0;
		int n = obstacleGrid[0].length;
		if (n == 0)
			return 0;
		int[][] dp = new int[m][n];

		for (int i = m - 1; i >= 0; i--)
			for (int j = n - 1; j >= 0; j--) {
				dp[i][j] = 0;
			}

		if(obstacleGrid[m-1][n-1]==0)
		    dp[m-1][n-1] = 1;
		
		for (int i = m - 1; i >= 0; i--)
			for (int j = n - 1; j >= 0; j--) {
				if (obstacleGrid[i][j] == 0) {

					if (i + 1 < m) {
						dp[i][j] += dp[i + 1][j];
					}
					if (j + 1 < n) {
						dp[i][j] += dp[i][j + 1];
					}
				}
			}
		return dp[0][0];
	}
}
