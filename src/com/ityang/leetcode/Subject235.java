package com.ityang.leetcode;

public class Subject235 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		
		if(root==null)
			return null;
		if(root==p || root==q)
			return root;
		int max = Math.max(p.val, q.val);
		int min = Math.min(p.val, q.val);
		if(root.val>min && root.val<max)
			return root;
		if(root.val>max)
			return lowestCommonAncestor(root.left, p, q);
		return lowestCommonAncestor(root.right, p, q);
	}

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
}
