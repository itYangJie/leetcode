package com.ityang.leetcode;

import java.util.Arrays;

public class Subject238 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Arrays.toString(productExceptSelf(new int[]{1,2,3,4})));
	}

	public static int[] productExceptSelf(int[] nums) {
		
		int leftProduct[] = new int[nums.length];
		int rightProduct[] = new int[nums.length];
		leftProduct[0] = rightProduct[0] = 1;
		for(int i=1;i<nums.length;i++){
			leftProduct[i] = leftProduct[i-1]*nums[i-1];
			rightProduct[i] = rightProduct[i-1]*nums[nums.length-i];
		}
		int[] res = new int[nums.length];
		for(int i=0;i<nums.length;i++){
			res[i] = leftProduct[i]*rightProduct[nums.length-i-1];
		}
		return res;
	}
}
