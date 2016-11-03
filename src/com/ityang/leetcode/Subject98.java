package com.ityang.leetcode;

import com.ityang.leetcode.Subject95.TreeNode;

public class Subject98 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static boolean isValidBST(TreeNode root) {
		
		if(root==null)
			return true;
		return dfs(root,Long.MAX_VALUE,Long.MIN_VALUE);	
	}

	private static boolean dfs(TreeNode root, long maxValue, long minValue) {
		if(root==null)
			return true;
		if(root.val>=maxValue || root.val<=minValue)
			return false;
		return dfs(root.left,root.val,minValue) && dfs(root.right,maxValue,root.val);
		
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
