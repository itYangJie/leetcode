package com.ityang.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Subject46 {

	public static void main(String[] args) {
		permute(new int[]{1,2,3});

	}

	public static List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		if(nums.length==0)
			return res;
		List<Integer> temp = new ArrayList<>();
		boolean[] isUsed = new boolean[nums.length];
		for(int i=isUsed.length-1;i>=0;i--)
			isUsed[i] = false;
		dfs(res,temp,isUsed,nums.length,nums,0);
		return res;
	}

	private static void dfs(List<List<Integer>> res, List<Integer> temp, 
			boolean[] isUsed, int length, int[] nums,
			int have) {
		if(have == length){
			res.add(new ArrayList(temp));
			return;
		}
		for(int i=0;i<length;i++){
			if(isUsed[i])
				continue;
			isUsed[i] = true;
			temp.add(nums[i]);
			dfs(res,temp,isUsed,length,nums,have+1);
			temp.remove(temp.size()-1);
			isUsed[i] = false;
		}
		
	}
}
