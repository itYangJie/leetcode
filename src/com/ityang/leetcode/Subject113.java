package com.ityang.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Subject113 {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode left = new TreeNode(2);
		TreeNode leftRight = new TreeNode(4);
		TreeNode right = new TreeNode(7);
		
		root.left = left;
		root.right = right;
		left.right = leftRight;
		pathSum(root, 7);

	}

	public static List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> res = new ArrayList<>();
		if(root==null)
			return res;
		List<Integer> temp = new ArrayList<>();
		dfs(root,sum,res,temp);
		return res;
	}

	private static void dfs(TreeNode root, int sum, List<List<Integer>> res, List<Integer> temp) {
		
		if(root==null)
			return ;
		if(root.val==sum && root.left==null && root.right==null){
			temp.add(root.val);
			res.add(new ArrayList<>(temp));
			temp.remove(temp.size()-1);
			return;
		}
		temp.add(root.val);
		dfs(root.left,sum-root.val,res,temp);
		
		dfs(root.right,sum-root.val,res,temp);
		temp.remove(temp.size()-1);
	}

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

}
