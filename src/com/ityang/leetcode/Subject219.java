package com.ityang.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Subject219 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(containsNearbyDuplicate(new int[]{1,2,3,7,5,8,2},4));
	}

	public static boolean containsNearbyDuplicate(int[] nums, int k) {
		
		if(nums.length<=1)
			return false;
		
		Map<Integer,Integer> map = new HashMap<>();
		int len = nums.length;
		for(int i=0;i<len;i++){
			if(map.containsKey(nums[i]) && i-map.get(nums[i])<=k)
					return true;
			
			map.put(nums[i], i);
		}
		return false;
	}
	

}