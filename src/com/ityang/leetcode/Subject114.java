package com.ityang.leetcode;

import com.ityang.leetcode.Subject112.TreeNode;

public class Subject114 {
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		flatten(root);
		
	}
	public static void flatten(TreeNode root) {

		solve(root);
	}

	private static TreeNode solve(TreeNode root) {
		if (root == null)
			return null;
	
		TreeNode left = solve(root.left);
		TreeNode right = solve(root.right);
		
		if (left == null) {
			root.right = right;
		} else {
			TreeNode node = left;
			while (node.right != null)
				node = node.right;
			root.right = left;
			node.right = right;
		}
		root.left = null;
		return root;
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
