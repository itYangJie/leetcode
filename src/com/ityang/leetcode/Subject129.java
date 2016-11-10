package com.ityang.leetcode;

public class Subject129 {


	private static int res = 0;
	public static int sumNumbers(TreeNode root) {
		if(root==null)
			return 0;
		 solve(root,root.val);
		 return res;
	}

	private static void solve(TreeNode root,int cur) {
		if(root==null)
			return ;
		if(root.left==null && root.right==null){
			res += cur;
			return;
		}
		if(root.left!=null)
		 solve(root.left,cur*10+root.left.val);
		
		if(root.right!=null)
		 solve(root.right,cur*10+root.right.val);
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
