package com.ityang.leetcode;

public class Subject7 {

	public static void main(String[] args) {
		System.out.println(reverse(21473648));

	}

	public static int reverse(long x) {
		if(x==0)
			return 0;
		
		boolean isPositive = true;
		if(x<0){
			isPositive = false;
			x = Math.abs(x);
		}
		
		StringBuilder sb = new StringBuilder();
		while(x!=0){
			sb.append(x%10);
			x = x/10;
		}
		char[] array = sb.toString().toCharArray();
		int len = array.length;
		long res = 0;
		long bei = 1;
		for(int i=len-1;i>=0;i--){
			res += (bei*(array[i]-'0'));
			bei *= 10;
		}
		if(res > Integer.MAX_VALUE)
			return 0;
		if(!isPositive)
			return (int) (-1*res);
		return (int) res;
			
	}
}
