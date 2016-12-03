package com.ityang.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Subject216 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(combinationSum3(4, 23));
	}

	public static List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> res = new ArrayList<>();
		
		List<Integer> temp = new ArrayList<>();
		dfs(res,temp,n,k,1);
		return res;
	}

	private static void dfs(List<List<Integer>> res, List<Integer> temp, int n, int k,int cur) {
		
		if(k==0 && n==0){
			res.add(new ArrayList<>(temp));
			return;
		}else if(k==0 || n==0){
			return;
		}
		
		for(int i=cur;i<=9;i++){
			temp.add(i);
			dfs(res,temp,n-i,k-1,i+1);
			temp.remove(temp.size()-1);
		}
		
	}
}
