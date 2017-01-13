package com.ityang.leetcode;

public class Subject287 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int findDuplicate(int[] nums) {
		
		int low = 1;
		int high = nums.length-1;
		
		while(low<high){
			int mid = low+(high-low)/2,count = 0;
			for(int i=0;i<nums.length;i++)
				if(nums[i]<=mid)
					count++;
			if(count > mid)
				high = mid;
			else
				low = mid+1;
				
		}
		return low;
	}
}
