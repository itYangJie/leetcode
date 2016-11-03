package com.ityang.leetcode;

public class Subject115 {

	public static void main(String[] args) {
		System.out.println(numDistinct2("rabbbit", "rabbit"));

	}

	private static int count = 0;

	public static int numDistinct(String s, String t) {

		if (s.length() == 0 || t.length() == 0 || s.length() < t.length())
			return 0;

		dfs(s, t, 0, 0);
		return count;
	}

	private static void dfs(String s, String t, int index, int haveMatchNum) {

		if (haveMatchNum == t.length()) {
			count++;
			return;
		}
		for (int i = index; i < s.length(); i++) {
			if (s.charAt(i) == t.charAt(haveMatchNum)) {
				dfs(s, t, i + 1, haveMatchNum + 1);
			}
		}

	}

	public static int numDistinct2(String s, String t) {

		if (s.length() == 0 || t.length() == 0 || s.length() < t.length())
			return 0;
		int sLength = s.length();
		int tLength = t.length();
		int[][] dp = new int[sLength][tLength];
		if(s.charAt(0)==t.charAt(0))
			dp[0][0] = 1;
		else
			dp[0][0] = 0;
		for(int i=1;i<tLength;i++){
			dp[0][i] = 0;
		}
		for(int i=1;i<sLength;i++){
			if(s.charAt(i)==t.charAt(0))
				dp[i][0] = dp[i-1][0]+1;
			else
				dp[i][0] = dp[i-1][0];
		}
		for(int i=1;i<sLength;i++)
			for(int j=1;j<tLength;j++){
				if(s.charAt(i)==t.charAt(j))
					dp[i][j] = dp[i-1][j-1]+dp[i-1][j];
				else
					dp[i][j] = dp[i-1][j];
			}
		return dp[sLength-1][tLength-1];
		
	}
}
