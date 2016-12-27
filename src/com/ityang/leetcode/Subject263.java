package com.ityang.leetcode;

public class Subject263 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isUgly(14));
	}

	public static boolean isUgly(int num) {
		if(num==0)
			return false;
		while(num%2==0)
			num /= 2;
		while(num%3==0)
			num /= 3;
		while(num%5==0)
			num /= 5;
		return num==1;
	}
}
