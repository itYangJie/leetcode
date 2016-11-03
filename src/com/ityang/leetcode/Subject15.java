package com.ityang.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subject15 {

	public static void main(String[] args) {
		threeSum(new int[]{0,-4,-1,-4,-2,-3,2});

	}

	public static List<List<Integer>> threeSum(int[] nums) {
		
		List<List<Integer>> res = new ArrayList<>();
		if(nums.length<3)
			return res;
		Arrays.sort(nums);
		
		int numCount = nums.length,pre = Integer.MAX_VALUE;
		for(int i=0;i<numCount-2;i++){
			if(nums[i]==pre)
				continue;
			int start = i+1,end = numCount-1;
			int target = 0-nums[i];
			while(start<end){
				int twoSum = nums[start]+nums[end];
				if(twoSum==target){
					List<Integer> temp = new ArrayList<>();
					temp.add(nums[i]);
					temp.add(nums[start]);
					temp.add(nums[end]);
					res.add(temp);
					while(start<end && nums[start+1]==nums[start])
						start++;
					start++;
					while(start<end && nums[end-1]==nums[end])
						end--;
					end--;
					
				}else if(twoSum>target){
					end--;
				}else{
					start++;
				}
			}
			pre = nums[i];
		}
		return res;
	}
}
