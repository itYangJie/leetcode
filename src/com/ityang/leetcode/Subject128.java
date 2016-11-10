package com.ityang.leetcode;

import java.util.HashMap;
import java.util.HashSet;


public class Subject128 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
	}

	public static int longestConsecutive(int[] nums) {
		if(nums.length==0 || nums.length==1)
			return nums.length;
		
		HashSet<Integer> set = new HashSet<>(); 
		int len = nums.length;
		for(int i=0;i<len;i++)
			set.add(nums[i]);
		
		int max = 0;
		for(int i=0;i<len;i++){
			if(!set.contains(nums[i]))
				continue;
			int length = 1,j=1;
			while(set.contains(nums[i]+j)){
				length++;
				set.remove(nums[i]+j);
				j++;
			}
			j = 1;
			while(set.contains(nums[i]-j)){
				length++;
				set.remove(nums[i]-j);
				j++;
			}
			max = Math.max(max, length);
		}
		
		return max;
	}
}
