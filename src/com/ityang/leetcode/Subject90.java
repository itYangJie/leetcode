package com.ityang.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subject90 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		subsetsWithDup(new int[]{1,2,2});
	}

	public static List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		res.add(new ArrayList<>());
		List<Integer> temp = new ArrayList<>();
		int len = nums.length;
		Arrays.sort(nums);
		dfs(res,temp,nums,len,0);
		return res;
 	}

	public static void dfs(List<List<Integer>> res, List<Integer> temp, int[] nums, int len, int cur) {
		if(cur>=len)
			return;
		for(int i=cur;i<len;i++){
			temp.add(nums[i]);
			res.add(new ArrayList<>(temp));
			dfs(res,temp,nums,len,i+1);
			temp.remove(temp.size()-1);
			
			while(i<len-1 && nums[i+1]==nums[i]) i++;
		}
		
	}
}
