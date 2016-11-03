package com.ityang.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subject16 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 public static int threeSumClosest(int[] nums, int target) {
			Arrays.sort(nums);
			int numCount = nums.length,pre = Integer.MAX_VALUE,res = Integer.MAX_VALUE/2;
			for(int i=0;i<numCount-2;i++){
				if(nums[i]==pre)
					continue;
				int start = i+1,end = numCount-1;
				int need = target-nums[i];
				while(start<end){
					int twoSum = nums[start]+nums[end];
					if(twoSum==need){
						return target;
						
					}else {
						if(Math.abs(target-twoSum-nums[i])<Math.abs(target-res))
							res = twoSum+nums[i];
						if(twoSum>need){
							end--;
						}else{
							start++;
						}
					}
				}
				pre = nums[i];
			}
			return res;
	 }
}
