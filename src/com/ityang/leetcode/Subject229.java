package com.ityang.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Subject229 {
	
	public static void main(String[] args) {
		System.out.println(majorityElement(new int[]{2,2}));
	}
	public static List<Integer> majorityElement(int[] nums) {
		List<Integer> res = new ArrayList<>();
		Map<Integer,Integer> map = new HashMap<>();
		int bound = (int) Math.floor(nums.length/3.0);
		for(int i=0;i<nums.length;i++){
			if(map.containsKey(nums[i])){
				if(map.get(nums[i])>=bound){
					res.add(nums[i]);
					map.put(nums[i], Integer.MIN_VALUE);
				}
				else
					map.put(nums[i],1+map.get(nums[i]));
			}else{
				map.put(nums[i], 1);
				if(1>bound){
					res.add(nums[i]);
					map.put(nums[i], Integer.MIN_VALUE);
				}
			}
		}
		return res;
	}
}
