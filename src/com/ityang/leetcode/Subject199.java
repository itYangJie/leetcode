package com.ityang.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Subject199 {
	public List<Integer> rightSideView(TreeNode root) {
		
		List<Integer> res = new ArrayList<>();
		if(root==null)
			return res;

		Queue<TreeNode>[] queues = new LinkedList[2];
		queues[0]  = new LinkedList();
		queues[1]  = new LinkedList();
		int curIndex = 0;
		
		TreeNode cur=null ;
		queues[curIndex].offer(root);
		while(!queues[curIndex].isEmpty()){
			
			while(!queues[curIndex].isEmpty()){
				cur = queues[curIndex].poll();
				if(cur.left!=null)
					queues[1-curIndex].offer(cur.left);
				if(cur.right!=null)
					queues[1-curIndex].offer(cur.right);
			}
			res.add(cur.val);
			
			curIndex = 1-curIndex;
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
