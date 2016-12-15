package com.ityang.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Subject228 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(summaryRanges(new int[]{1,2,3,4,5,6,8}));
	}

	public static List<String> summaryRanges(int[] nums) {
		List<String> res = new ArrayList<>();
		if(nums.length==0)
			return res;
		if(nums.length==1){
			res.add(nums[0]+"");
			return res;
		}
		solve(res,nums,0,nums.length-1);
		return res;
	}
	
	private static void solve(List<String> res, int[] nums, int left, int right) {
		if(left>right)
			return;
		if(left==right){
			res.add(nums[left]+"");
			return;
		}
		
		int mid = left+(right-left)/2;
		int minIndex = findRangeMinIndex(nums,left,mid);
		int maxIndex = findRangeMaxIndex(nums,mid,right);
		solve(res,nums,left,minIndex-1);
		if(minIndex==maxIndex)
			res.add(nums[minIndex]+"");
		else
			res.add(nums[minIndex]+"->"+nums[maxIndex]);
		solve(res,nums,maxIndex+1,right);
	}

	private static int findRangeMaxIndex(int[] nums, int left, int right) {
		int Left = left;
		int mid ;
		while(left<right){
			if(right-left==1){
				if(nums[right]-nums[left]==1)
					return right;
				else
					return left;
			}
			mid = left+(right-left)/2;
			if(nums[mid]-nums[Left]==mid-Left){
				left = mid;
			}else{
				right = mid-1;
			}
		}
		return left;
	}

	private static int findRangeMinIndex(int[] nums, int left, int right) {
		int Right = right;
		int mid ;
		while(left<right){
			mid = left+(right-left)/2;
			if(nums[Right]-nums[mid]==Right-mid){
				right = mid;
			}else{
				left = mid+1;
			}
		}
		return left;
	}
}
