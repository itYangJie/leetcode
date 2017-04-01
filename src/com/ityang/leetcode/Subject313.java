package com.ityang.leetcode;

public class Subject313 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(nthSuperUglyNumber(1000, new int[]{2, 7, 13, 19}));
	}
	
	// 1, 2, 4, 7, 8, 13, 14, 16, 19, 26, 28, 32
	public static int nthSuperUglyNumber(int n, int[] primes) {
		if(n==1)
			return 1;
		int[] ugly = new int[n];
		int[] idx = new int[primes.length];
		ugly[0] = 1;
		
		for(int i=1;i<n;i++){
			ugly[i] = Integer.MAX_VALUE;
			for(int j=0;j<primes.length;j++)
				ugly[i] = Math.min(ugly[i], primes[j]*ugly[idx[j]]);
			for(int j=0;j<primes.length;j++)
				while(primes[j]*ugly[idx[j]]<=ugly[i])
					idx[j]++;
		}
		return ugly[n-1];
	}
}
