package com.ityang.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Subject78 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		subsets(new int[]{1,2,3});
	}

	public static List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		int len;
		if(nums == null || (len=nums.length) <= 0)
			return res;
		int totalCount = 1<<len;
		for(int i=0;i<totalCount;i++){
			List<Integer> list = new ArrayList();
			for(int j=0;j<len;j++){
				if( ((i>>j)&1)==1 ){
					list.add(nums[j]);
				}
			}
			
			res.add(list);
		}
		
		return res;
	}
}
