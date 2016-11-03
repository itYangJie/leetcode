package com.ityang.leetcode;

public class Subject70 {

	public static void main(String[] args) {

	}

	public int climbStairs(int n) {
		
		if(n<=2)
			return n;
		
		int[] count = new int[n];
		count[0] = 1;
		count[1] = 2;
		for(int i=2;i<n;i++){
			count[i] = count[i-1]+count[i-2];
		}
		return count[n-1];
	}
}
