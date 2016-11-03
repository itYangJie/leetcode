package com.ityang.leetcode;

public class Subject111 {
	
	public static int minDepth(TreeNode root) {
		
		if(root==null )
			return 0;
		 if(root.left==null)
			return 1+minDepth(root.right);
		 if(root.right==null)
			return 1+minDepth(root.left);
		return 1+Math.min(minDepth(root.right), minDepth(root.left));
		
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
