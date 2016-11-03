package com.ityang.leetcode;

import com.ityang.leetcode.Subject108.TreeNode;

public class Subject110 {
	
	private static int height = 0;
	public static boolean isBalanced(TreeNode root) {
		if(root==null)
			return true;
		return solve(root);
	}

	private static boolean solve(TreeNode root) {
		
		if(root==null){
			height=0;
			return true;
		}
		
		boolean isLeftBalance = solve(root.left);
		int leftHeight = height;
		boolean isRightBalance = solve(root.right);
		int rightHeight = height;
		
		height = 1+Math.max(leftHeight, rightHeight);
		return Math.abs(leftHeight-rightHeight)<=1 && isLeftBalance && isRightBalance;
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
