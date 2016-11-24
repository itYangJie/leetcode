package com.ityang.leetcode;

public class Subject171 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(titleToNumber("AB"));
	}
	//AB 28
	public static int titleToNumber(String s) {
		
		int num = 0,fact = 1;
		for(int i=s.length()-1;i>=0;i--){
			num = num +fact*(s.charAt(i)-'A'+1);
			fact = fact*26;
		}
		return num;
	}
}
