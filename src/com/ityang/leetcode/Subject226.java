package com.ityang.leetcode;

public class Subject226 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public TreeNode invertTree(TreeNode root) {
		if(root==null)
			return null;
		root.left = invertTree(root.left);
		root.right = invertTree(root.right);
		return root;
	}

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
}
