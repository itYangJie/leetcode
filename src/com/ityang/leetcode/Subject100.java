package com.ityang.leetcode;

import com.ityang.leetcode.Subject99.TreeNode;

public class Subject100 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static boolean isSameTree(TreeNode p, TreeNode q) {
		
		if(p==null && q==null)
			return true;
		else if(p==null || q==null)
			return false;
		
		return p.val==q.val&&isSameTree(p.left, q.left)&&isSameTree(p.right, q.right);
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
