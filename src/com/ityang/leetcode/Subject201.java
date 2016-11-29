package com.ityang.leetcode;

public class Subject201 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(rangeBitwiseAnd(7, 10));
	}

	public static int rangeBitwiseAnd(int m, int n) {
		// 101,110,111(5,6,7)
		// xx....x(m)0x...x(n)[m+n=31]=(0--2^n-1)+(0--2^m-1)*2^(n+1)
		// 10100(20)=101*2^2
		/*
		 * if (m == 0) { return 0; } int moveFactor = 1; while (m != n) { m >>=
		 * 1; n >>= 1; moveFactor <<= 1; } return m * moveFactor;
		 */
		if (m == 0)
			return 0;
		if (m == n)
			return m;
		int num = n - m;

	
		int max = 2, start = ((m & 1) == 1 ? 1 : 0), res = 0;
		
		for (int i = 1; i < 32; i++) {
			if ((m >> i & 1) == 1) {
				if (start + num <= max - 1)
					res += max;
				start = start + max;
			}
			max = max * 2;
		}
		return res;
	}
}
