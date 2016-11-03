package com.ityang.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Subject94 {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode right = new TreeNode(2);
		TreeNode rightLeft = new TreeNode(3);
		root.right = right;
		right.left = rightLeft;
		inorderTraversal(root);

	}

	public static List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if(root==null)
			return res;
		Stack<TreeNode> stack = new Stack<>();
		TreeNode cur = root;
		while(cur!=null || !stack.isEmpty()){
			while(cur!=null){
				stack.push(cur);
				cur = cur.left;
			}
			TreeNode t = stack.pop();
			res.add(t.val);
			cur = t.right;
		}
		return res;
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
