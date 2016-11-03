package com.ityang.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Subject102 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		if(root==null)
			return res;
		Queue<TreeNode> queues[] = new LinkedList[2];
		
		queues[0] = new LinkedList<TreeNode>();
		queues[1] = new LinkedList<TreeNode>();
		int curIndex = 0;
		queues[curIndex].add(root);
		while(!queues[curIndex].isEmpty()){
			List<Integer> list = new ArrayList<>();
			while(!queues[curIndex].isEmpty()){
				
				TreeNode curNode = queues[curIndex].poll();
				list.add(curNode.val);
				if(curNode.left!=null)
					queues[1-curIndex].add(curNode.left);
				if(curNode.right!=null)
					queues[1-curIndex].add(curNode.right);
			}
			res.add(list);
			curIndex = 1-curIndex;
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
