package com.ityang.leetcode;

public class Subject91 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(numDecodings("101"));
	}

	public static int numDecodings(String s) {
		if(s==null || s.length()==0)
			return 0;
		int len = s.length();
		char[] chars = s.toCharArray();
		if(chars[0]=='0')
			return 0;
		int dp[] = new int[len+1];
		dp[0] = dp[1] = 1;
		for(int j=2;j<=len;j++){ //123
			int num = Integer.parseInt(s.substring(j-2, j));
			
			if(chars[j-1]=='0'){
				if(num==0 || num>26)
					return 0;
				dp[j] = dp[j-2];
			}else{
				if(num>26 || chars[j-2]=='0')
					dp[j] = dp[j-1];
				else
					dp[j] = dp[j-1]+dp[j-2];
			}
		}
		return dp[len];
	}
}
