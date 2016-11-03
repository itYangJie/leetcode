package com.ityang.leetcode;

public class Subject69 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(mySqrt(3));
	}

	public static int mySqrt(int x) {
		if (x <= 0)
			return 0;
		//return (int) Math.sqrt(x);
		double res = x;
		while(Math.abs(res*res-x)>0.5){
			
			res = (res+x/res)/2;
		}
		return (int) res;
	}
}
