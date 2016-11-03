package com.ityang.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Subject103 {

	public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		if (root == null)
			return res;
		Stack<TreeNode> stacks[] = new Stack[2];

		stacks[0] = new Stack<TreeNode>();
		stacks[1] = new Stack<TreeNode>();
		int curIndex = 0;
		stacks[curIndex].add(root);
		boolean isLeftToRight = false;
		while (!stacks[curIndex].isEmpty()) {
			List<Integer> list = new ArrayList<>();
			while (!stacks[curIndex].isEmpty()) {

				TreeNode curNode = stacks[curIndex].pop();
				list.add(curNode.val);
				if (isLeftToRight) {

					if (curNode.right != null)
						stacks[1 - curIndex].add(curNode.right);
					if (curNode.left != null)
						stacks[1 - curIndex].add(curNode.left);
				} else {
					
					if (curNode.left != null)
						stacks[1 - curIndex].add(curNode.left);
					if (curNode.right != null)
						stacks[1 - curIndex].add(curNode.right);
				}

			}
			res.add(list);
			curIndex = 1 - curIndex;
			isLeftToRight = !isLeftToRight;
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
