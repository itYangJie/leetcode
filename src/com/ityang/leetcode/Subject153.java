package com.ityang.leetcode;

public class Subject153 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findMin(new int[]{-4,-1,1,3}));
	}

	public static int findMin(int[] nums) {
		
		if(nums.length==1 || nums[0]<nums[nums.length-1])
			return nums[0];
		int start = 0,end = nums.length-1;
		int mid = start+(end-start)/2;
		while(!(mid>=1 && nums[mid]<nums[mid-1])){
			if(nums[end]<nums[mid]){
				start = mid+1;
			}else{
				end = mid-1;
			}
			mid = start+(end-start)/2;
		}
		return nums[mid];
	}
}
