package com.ityang.leetcode;

import com.ityang.leetcode.Subject235.TreeNode;

public class Subject236 {
	
	/**
	 *        1
	 *       / \
	 *      2   3  2,3
	 * @param root
	 * @param p
	 * @param q
	 * @return
	 */
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if(root==null)
			return null;
		if(root==p || root==q)
			return root;
		
		TreeNode left = lowestCommonAncestor(root.left,p,q);
		TreeNode right = lowestCommonAncestor(root.right,p,q);
		if(left!=null && right!=null)
			return root;
		if(left!=null)
			return left;
		return right;
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
