package com.ityang.leetcode;

public class Subject297 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// Encodes a tree to a single string.
	// [1,2,3,null,null,4,5]
	public String serialize(TreeNode root) {
		if(root==null)
			return "[]";
		
		return "";
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		
		return null;
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
