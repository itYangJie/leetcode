package com.ityang.leetcode;

public class Subject34 {

	public static void main(String[] args) {
		System.out.println(binHigherSearch(new int[]{1, 2,2,3,3,3,4},3));

	}
	 public static int[] searchRange(int[] nums, int target) {
		
		 int lowerIndex = binLowerSerach(nums,target);
		 if(lowerIndex==-1)
			 return new int[]{-1,-1};
		 int higherIndex = binHigherSearch(nums,target);
		 return new int[]{lowerIndex,higherIndex};
	 }
	private static int binHigherSearch(int[] nums, int target) {
		if(nums.length<=0)
			 return -1;
		int low = 0,high = nums.length-1;
		while(low<=high){
			int mid = low+(high-low)/2;
			if(nums[mid]==target &&(mid==nums.length-1 || nums[mid+1]!=target))
				return mid;
			else if(nums[mid]>target){
				high = mid-1;
			}else{
				low = mid+1;
			}
				
		}
		return -1;
	}
	private static int binLowerSerach(int[] nums, int target) {
		 if(nums.length<=0)
			 return -1;
		int low = 0,high = nums.length-1;
		while(low<=high){
			int mid = low+(high-low)/2;
			if(nums[mid]==target &&(mid==0 || nums[mid-1]!=target))
				return mid;
			else if(nums[mid]<target){
				low = mid+1;
			}else{
				high = mid-1;
			}
				
		}
		return -1;
	}
	 
	 
}
