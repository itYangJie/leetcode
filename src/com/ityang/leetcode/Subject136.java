package com.ityang.leetcode;

public class Subject136 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(singleNumber(new int[]{1,1,3,4,4,5,6,5,6}));
	}

	public static int singleNumber(int[] nums) {
		
		int res = 0;
		for(int i=0;i<nums.length;i++)
			res = res^nums[i];
		return res;
	}
}
