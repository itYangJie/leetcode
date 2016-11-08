package com.ityang.leetcode;

public class Subject124 {
	
	private static int res = Integer.MIN_VALUE;
	public static int maxPathSum(TreeNode root) {
		
		if(root==null)
			return 0;
		solve(root);
		return res;
	}

	private static int solve(TreeNode root) {
		if(root == null)
			return 0;
		int left = Math.max(solve(root.left),0);
		int right = Math.max(solve(root.right),0);
		
		int resTemp = left+right+root.val;
		res = Math.max(res, resTemp);
		
		return root.val+(left>right?left:right);
	}

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
}
