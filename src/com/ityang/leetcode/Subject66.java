package com.ityang.leetcode;

public class Subject66 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int[] plusOne(int[] digits) {
		if (digits.length <= 0)
			return digits;
		int len = digits.length;
		int carray = 1, sum = 0;
		int[] res = new int[len + 1];
		for (int i = len - 1; i >= 0; i--) {
			sum = digits[i] + carray;
			digits[i] = sum % 10;
			res[i + 1] = digits[i];
			carray = sum / 10;
		}
		if (carray == 1) {
			res[0] = 1;
			return res;
		} else {

			return digits;
		}
	}
}
