package com.ityang.leetcode;

public class Subject172 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(trailingZeroes(10));
	}

	public static int trailingZeroes(int n) {
		// 1*2*3*4*5*6*7*8*9*10
		
		int res = 0,temp = n/5;
		
		while(temp!=0){
			res += temp;
			temp /= 5;
		}
		return res;
			
	}
}
