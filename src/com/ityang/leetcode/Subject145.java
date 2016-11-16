package com.ityang.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.ityang.leetcode.Subject144.TreeNode;

public class Subject145 {

	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if (root == null)
			return res;
		Stack<TreeNode> stack = new Stack<>();
		TreeNode cur = root, pre = null;
		while (cur != null || !stack.isEmpty()) {

			while (cur != null) {
				stack.push(cur);
				cur = cur.left;
			}

			cur = stack.peek();
			if (cur.right == null || cur.right==pre) {
				res.add(stack.pop().val);
				pre = cur;
				cur = null;
			} else{
				cur = cur.right;
			}
				
		}
		return res;
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
