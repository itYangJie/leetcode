package com.ityang.leetcode;

import com.ityang.leetcode.Subject110.TreeNode;

public class Subject112 {
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		System.out.println(hasPathSum(root, 0));
		System.out.println();
	}
	public static boolean hasPathSum(TreeNode root, int sum) {
		if(root==null)
			return false;
		return sum==root.val && root.left==null && root.right==null || hasPathSum(root.left, sum-root.val) || hasPathSum(root.right, sum-root.val);
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
