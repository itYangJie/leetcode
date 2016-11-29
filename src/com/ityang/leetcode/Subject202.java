package com.ityang.leetcode;

import java.util.HashSet;

public class Subject202 {
	public static void main(String[] args) {
		System.out.println(isHappy(643545438));
	}

	public static boolean isHappy(int n) {
		if(n==1)
			return true;
		HashSet<Integer> set = new HashSet<>();
		set.add(n);
		int sum;
		while(n!=1){
			sum = 0;
			while(n!=0){
				sum += (n%10)*(n%10);
				n = n/10;
			}
			if(set.contains(sum))
				return false;
			set.add(sum);
			n = sum;
		}
		return true;
		
	}

}
