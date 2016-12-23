package com.ityang.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Subject257 {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		TreeNode left = new TreeNode(2);
		TreeNode right = new TreeNode(1);

		root.left = left;
		root.right = right;

		System.out.println(binaryTreePaths(root));

	}

	public static List<String> binaryTreePaths(TreeNode root) {
		List<String> res = new ArrayList<>();
		if (root == null)
			return res;
		List<String> leftPaths = binaryTreePaths(root.left);
		List<String> rightPaths = binaryTreePaths(root.right);
		for (int i = 0; i < leftPaths.size(); i++) {
			res.add(root.val + "->" + leftPaths.get(i));
		}
		for (int i = 0; i < rightPaths.size(); i++) {
			res.add(root.val + "->" + rightPaths.get(i));
		}
		if (leftPaths.size() == 0 && rightPaths.size() == 0)
			res.add(root.val + "");
		return res;
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
