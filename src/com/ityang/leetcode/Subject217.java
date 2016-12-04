package com.ityang.leetcode;

import java.util.HashSet;
import java.util.Set;

public class Subject217 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(containsDuplicate(new int[]{1,4,3,4}));
	}

	public static boolean containsDuplicate(int[] nums) {
		
		if(nums.length<=1)
			return false;
		
		Set<Integer> set = new HashSet<>();
		
		for(int i=nums.length-1;i>=0;i--){
			if(set.contains(nums[i]))
				return true;
			set.add(nums[i]);
		}
		return false;
	}
}
