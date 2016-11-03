package com.ityang.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Subject77 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		combine(5, 3);
	}

	public static List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> res = new ArrayList<>();
		if(n<1 || k>n)
			return res;
		List<Integer> temp = new ArrayList<>();
		dfs(res,temp,n,k,1);
		return res;
	}

	private static void dfs(List<List<Integer>> res, List<Integer> temp, 
			int n, int need, int index) {
		if(need == 0){
			res.add(new ArrayList(temp));
		}
			
		for(int i=index;i<=n;i++){
			temp.add(i);
			dfs(res,temp,n,need-1,i+1);
			temp.remove(temp.size()-1);
		}
		
	}
	
}
