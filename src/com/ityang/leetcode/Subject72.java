package com.ityang.leetcode;

public class Subject72 {

	public static void main(String[] args) {
		System.out.println(minDistance("abcf", "a"));

	}

	public static int minDistance(String word1, String word2) {
		int len1 = word1.length();
		int len2 = word2.length();
		if(len1 == 0)
			return len2;
		if(len2 == 0)
			return len1;
		int[][] dp = new int[len1][len2];
		char[] chars1 = word1.toCharArray();
		char[] chars2 = word2.toCharArray();
		
		if(chars1[len1-1] == chars2[len2-1])
			dp[len1-1][len2-1] = 0;
		else
			dp[len1-1][len2-1] = 1;
		
		for(int i=len1-2;i>=0;i--){
			if(chars2[len2-1]==chars1[i]){
				dp[i][len2-1] = len1-1-i;
			}else{
				dp[i][len2-1] = 1+dp[i+1][len2-1];
			}
		}
		
		for(int i=len2-2;i>=0;i--){
			if(chars1[len1-1]==chars2[i]){
				dp[len1-1][i] = len2-1-i;
			}else{
				dp[len1-1][i] = 1+dp[len1-1][i+1];
			}
		}
		
		
		for(int i=len1-2;i>=0;i--)
			for(int j=len2-2;j>=0;j--){
				
				if(chars1[i] == chars2[j]){
					dp[i][j] = dp[i+1][j+1];
				}else{
					dp[i][j] = Math.min(Math.min(dp[i+1][j],dp[i][j+1] ),
							dp[i+1][j+1])+1;
				}
				
			}
		return dp[0][0];
	}
}
