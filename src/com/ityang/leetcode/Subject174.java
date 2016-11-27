package com.ityang.leetcode;

public class Subject174 {

	public int calculateMinimumHP(int[][] dungeon) {
		
		int rows = dungeon.length;
		int columns = dungeon[0].length;
		int dp[][] = new int[rows][columns];
		dp[rows-1][columns-1] = Math.max(1, 1-dungeon[rows-1][columns-1]);
		for(int i=columns-2;i>=0;i--){
			dp[rows-1][i] = Math.max(dp[rows-1][i+1]-dungeon[rows-1][i],1);
		}
		
		for(int i=rows-2;i>=0;i--){
			dp[i][columns-1] = Math.max(dp[i+1][columns-1]-dungeon[i][columns-1],1);
		}
		
		for(int i=rows-2;i>=0;i--)
			for(int j=columns-2;j>=0;j--){
				dp[i][j] = Math.max( Math.min(dp[i+1][j], dp[i][j+1])-dungeon[i][j],1);
			}
		return dp[0][0];
	}
}
