package com.ityang.leetcode;

public class Subject231 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isPowerOfTwo(4));
	}
	// 1,2,4,8,16,32....
	/**
	 * 2���� ���ص��Ƕ�����������ֻ��һλ1
	 * @param n
	 * @return
	 */
	public static boolean isPowerOfTwo(int n) {
		return n>0 && (n&(n-1))==0;
	}
}
