package com.ityang.leetcode;

public class Subject50 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(myPow(34.00515,-3));
	}

	public static double myPow(double x, int n) {
		
		if(n==0)
			return 1;
		boolean isNegtive = false;
		if(n<0){
			isNegtive = true;
			n = -n;
		}
		double res = 1;
		int i = 0,tempN = n;
		while(i<=31 && tempN!=0){
			if( ( (tempN=(n>>i++)) & 1 )==1 )
				res *=x;
			x *=x;
		}
		if(isNegtive){
			return 1.0/res;
		}
		return res;
	}
}
