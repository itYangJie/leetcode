package com.ityang.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Subject137 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(singleNumber(new int[]{1,2,1,2,1,2,4}));
	}
	
	//1 1 1 2 2 2 3
	public static int singleNumber(int[] nums) {
		if(nums.length==1)
			return nums[0];
		
		Map<Integer,Integer> map = new HashMap<>();
		
		for(int i=0;i<nums.length;i++){
			if(map.containsKey(nums[i])){
				map.put(nums[i], 3);
			}else{
				map.put(nums[i], 1);
			}
		}
		for (int i : map.keySet()) {
			if(map.get(i)==1)
				return i;
		}
		return -1;
	}
}
