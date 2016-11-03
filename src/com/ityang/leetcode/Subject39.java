package com.ityang.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Subject39 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> temp = new ArrayList<>();
		if (candidates.length == 0)
			return res;
		dfs(0, 0, target, temp, res, candidates);
		return res;
	}

	public void dfs(int index, int sum, int target, List<Integer> temp, 
			List<List<Integer>> res, int[] candidates) {
		if (sum == target) {
			res.add(new ArrayList<>(temp));
			return;
		} else if (sum < target) {

			for (int i = index; i < candidates.length; i++) {
				temp.add(candidates[i]);
				dfs(i, sum + candidates[i], target, temp, res, candidates);
				temp.remove(temp.size() - 1);
			}

		}

	}
}
