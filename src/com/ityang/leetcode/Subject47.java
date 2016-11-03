package com.ityang.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subject47 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		permuteUnique(new int[]{3,2,1});
	}

	public static List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		if(nums.length==0)
			return res;
		Arrays.sort(nums);
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
		//int pre = Integer.MAX_VALUE;
		for(int i=0;i<length;i++){
			
			if(isUsed[i] )
				continue;
			isUsed[i] = true;
			temp.add(nums[i]);
			dfs(res,temp,isUsed,length,nums,have+1);
			temp.remove(temp.size()-1);
			isUsed[i] = false;
			
			while(i<length-1 && nums[i+1]==nums[i])
				i++;
			
			//pre = nums[i];
		}
		
	}
}
