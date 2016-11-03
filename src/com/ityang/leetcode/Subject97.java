package com.ityang.leetcode;

public class Subject97 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

	public static boolean isInterleaveByDp(String s1, String s2, String s3) {
		if (s1.isEmpty())
			return s2.equals(s3);
		if (s2.isEmpty())
			return s1.equals(s3);
		if (s1.length() + s2.length() != s3.length())
			return false;
		boolean[][] matched = new boolean[s1.length() + 1][s2.length() + 1];
		char[] ch1 = s1.toCharArray();
		char[] ch2 = s2.toCharArray();
		char[] ch3 = s3.toCharArray();

		for (int i = 0; i <= ch1.length; i++) {
			for (int j = 0; j <= ch2.length; j++) {
				if (i == 0 && j == 0) {
					matched[i][j] = true;
				} else if (i == 0) {
					matched[i][j] = matched[i][j - 1] && ch2[j - 1] == ch3[i + j - 1];
				} else if (j == 0) {
					matched[i][j] = matched[i - 1][j] && ch1[i - 1] == ch3[i + j - 1];
				} else {
					matched[i][j] = (matched[i][j - 1] && ch2[j - 1] == ch3[i + j - 1]
							|| matched[i - 1][j] && ch1[i - 1] == ch3[i + j - 1]);
				}
			}
		}

		return matched[ch1.length][ch2.length];

	}

	public static boolean isInterleave(String s1, String s2, String s3) {
		if (s1.isEmpty())
			return s2.equals(s3);
		if (s2.isEmpty())
			return s1.equals(s3);
		if (s1.length() + s2.length() != s3.length())
			return false;
		return dfs(s1, s2, s3, 0, 0);
	}

	private static boolean dfs(String s1, String s2, String s3, int index1, int index2) {

		if (index1 == s1.length() && index2 == s2.length())
			return true;
		char needMatchChar = s3.charAt(index1 + index2);
		boolean isMatch = false;
		if (index1 < s1.length() && s1.charAt(index1) == needMatchChar)
			isMatch = dfs(s1, s2, s3, index1 + 1, index2);
		if (isMatch)
			return true;
		if (index2 < s2.length() && s2.charAt(index2) == needMatchChar)
			isMatch = dfs(s1, s2, s3, index1, index2 + 1);
		return isMatch;
	}
}
