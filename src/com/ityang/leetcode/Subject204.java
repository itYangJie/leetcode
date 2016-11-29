package com.ityang.leetcode;

public class Subject204 {

	public static void main(String[] args) {
		System.out.println(countPrimes(3));
	}

	public static int countPrimes(int n) {
		if(n==0 || n==1 || n==2)
			return 0;
		boolean[] isComposite = new boolean[n]; //0,1--n-1
		int fact = 2,count = 0;
		for(int i=2;i<<1 <n;i++){
			if(!isComposite[i]){
				while(fact*i<n){
					if(!isComposite[fact*i]){
						isComposite[fact*i] = true;
						count++;
					}
					fact++;
				}
				fact = 2;
			}
			
		}
		return n-2-count;
		
		
	}
}
