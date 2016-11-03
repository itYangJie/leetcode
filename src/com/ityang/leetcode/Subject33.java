package com.ityang.leetcode;

import java.util.Arrays;

public class Subject33 {

	public static void main(String[] args) {
		System.out.println(search(new int[]{1,3,5},5));

	}

	public static int search(int[] nums, int target) {
		/*for(int i=0;i<nums.length;i++){
			if(nums[i]==target)
				return i;
		}
		return -1;*/
		if(nums.length==0)
			return -1;
		
		int start = 0,end = nums.length-1,mid;
		if(nums[start]<nums[end]){
			int res = Arrays.binarySearch(nums, target);
			if(res<0)
				return -1;
			return res;
		}
			
		while(start<=end){
			mid = start+(end-start)/2;
			if(nums[mid]==target)
				return mid;
			else if(nums[mid]>=nums[start]){
				if(target<nums[start] || target>nums[mid])
					start = mid+1;
				else
					end = mid-1;
			}else{
				if(target<nums[mid])
					end = mid-1;
				else{
					if(target>=nums[start])
						end = mid-1;
					else
						start = mid+1;
				}
					
			}
		}
		return -1;
	}
}
