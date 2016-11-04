package com.ityang.leetcode;

import java.util.List;

public class Subject120 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int minimumTotal(List<List<Integer>> triangle) {
		int length = triangle.size();
		if(length==0)
			return 0;
		if(length==1)
			return triangle.get(0).get(0);
		
		int dp[][] = new int[length][length];
		dp[0][0] = triangle.get(0).get(0);
		for(int i=1;i<length;i++)
			for(int j=0;j<=i;j++){
				
				if(j==0){
					dp[i][j] = dp[i-1][0]+triangle.get(i).get(j);
				}else if(j==i){
					dp[i][j] = dp[i-1][i-1]+triangle.get(i).get(j);
				}else{
					dp[i][j] = Math.min(dp[i-1][j],dp[i-1][j-1])+triangle.get(i).get(j);
				}
			}
		int min = Integer.MIN_VALUE;
		for(int i=0;i<length;i++){
			min = Math.min(dp[length-1][i],min);
		}
		return min;
	}
}
