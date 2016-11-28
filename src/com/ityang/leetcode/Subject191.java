package com.ityang.leetcode;

public class Subject191 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(hammingWeight(11));
	}

	public static int hammingWeight(int n) {
		
		int count = 0;
		while(n!=0){
			count++;
			n = (n-1)&n;
		}
		return count;
	}
}
