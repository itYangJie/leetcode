package com.ityang.leetcode;

public class Subject264 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(nthUglyNumber(10));
	}

	public static int nthUglyNumber(int n) {
		
		int ugly[] = new int[n];
		ugly[0] = 1;
		int factory2 = 2,factory3 = 3,factory5 = 5;
		int index2 = 0,index3 = 0,index5 = 0;
		for(int i=1;i<n;i++){
			ugly[i] = Math.min(Math.min(factory2, factory3), factory5);
			if(ugly[i]==factory2)
				factory2 = 2*ugly[++index2];
			if(ugly[i]==factory3)
				factory3 = 3*ugly[++index3];
			if(ugly[i]==factory5)
				factory5 = 5*ugly[++index5];
		}
		return ugly[n-1];
	}
}
