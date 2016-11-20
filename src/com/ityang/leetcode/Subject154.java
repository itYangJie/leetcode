package com.ityang.leetcode;

public class Subject154 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findMin(new int[]{1,1,1,2,3,4,1,1}));
	}

	public static int findMin(int[] nums) {
		if(nums.length==1 || nums[0]<nums[nums.length-1])
			return nums[0];
		int start = 0,end = nums.length-1,mid;
		while(start<end-1){
			mid = start+(end-start)/2;
			if( nums[mid]<nums[mid-1]){
				return nums[mid];
			}else{
				if(nums[end]<nums[mid]){
					start = mid+1;
				}else if(nums[end]>nums[mid]){
					end = mid-1;
				}else{
					end--;
				}
			}
		}
		return Math.min(nums[start],nums[end]);
	}
}
