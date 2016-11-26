package com.ityang.leetcode;

import java.util.Stack;

public class Subject173 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private Stack<TreeNode> stack;
	private TreeNode cur;

	public Subject173(TreeNode root) {

		stack = new Stack<>();
		cur = root;
		while (cur != null) {
			stack.push(cur);
			cur = cur.left;
		}

	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		return !stack.isEmpty();
	}

	/** @return the next smallest number */
	public int next() {
		cur = stack.pop();
		int val = cur.val;
		cur = cur.right;
		if (cur != null || !stack.isEmpty()) {
			while (cur != null) {
				stack.push(cur);
				cur = cur.left;
			}

		}
		return val;
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
