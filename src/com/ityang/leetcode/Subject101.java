package com.ityang.leetcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import com.ityang.leetcode.Subject100.TreeNode;

public class Subject101 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static boolean isSymmetric(TreeNode root) {
		if(root==null)
			return true;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root.left);
		queue.add(root.right);
		while(!queue.isEmpty()){
			TreeNode left = queue.poll();
			TreeNode right = queue.poll();
			if(left==null && right==null)
				continue;
			else if(left==null || right==null || left.val!=right.val)
				return false;
			
			queue.add(left.left);
			queue.add(right.right);
			queue.add(left.right);
			queue.add(right.left);
		}
		return true;
		
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
