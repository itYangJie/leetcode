package com.ityang.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Subject144 {
	
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if(root==null)
			return res;
		Stack<TreeNode> stack = new Stack<>();
		TreeNode cur = root;
		while(cur!=null || !stack.isEmpty()){
			if(cur!=null){
				res.add(cur.val);
				stack.push(cur);
				cur = cur.left;
			}else{
				cur = stack.pop().right;
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
