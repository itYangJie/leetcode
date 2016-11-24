package com.ityang.leetcode;

public class Subject169 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(majorityElement(new int[]{0,2,2,5,0,2,2}));
	}

	public static int majorityElement(int[] nums) {
		int res = nums[0],count = 1;
		
		for(int i=1;i<nums.length;i++){
			if(res==nums[i])
				count++;
			else{
				count--;
				if(count==0){
					res = nums[i];
					count = 1;
				}
			}
		}
		return res;
	}
}
