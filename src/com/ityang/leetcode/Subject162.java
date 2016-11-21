package com.ityang.leetcode;

public class Subject162 {

	public static void main(String[] args) {
		System.out.println(findPeakElement(new int[]{1,2,3,1}));
	}

	public static int findPeakElement(int[] nums) {
		
		/*if(nums.length==1)
			return 0;
		for(int i=nums.length-1;i>=0;i--){
			if((i==nums.length-1 || nums[i]>nums[i+1]) && (i==0 || nums[i]>nums[i-1])){
				return i;
			}
		}
		return -1;*/
		int low = 0,high = nums.length-1;
		while(low<high){
			int mid1 = (low+high)/2;
			int mid2 = mid1+1;
			if(nums[mid1]>nums[mid2])
				high = mid1;
			else
				low = mid2;
		}
		return low;
	}
}
