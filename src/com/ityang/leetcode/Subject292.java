package com.ityang.leetcode;

public class Subject292 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(canWinNim(3));
	}

	public static boolean canWinNim(int n) {
		return !(n%4==0);
	}
}
