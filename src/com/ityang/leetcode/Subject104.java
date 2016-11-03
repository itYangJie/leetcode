package com.ityang.leetcode;

import com.ityang.leetcode.Subject103.TreeNode;

public class Subject104 {
	public static int maxDepth(TreeNode root) {
		if(root==null)
			return 0;
		return 1+Math.max(maxDepth(root.left), maxDepth(root.right));
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
