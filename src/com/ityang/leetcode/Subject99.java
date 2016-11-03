package com.ityang.leetcode;

import java.util.Deque;
import java.util.LinkedList;

import com.ityang.leetcode.Subject96.TreeNode;

public class Subject99 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static void recoverTree(TreeNode root) {
		/*if(root==null||(root.left==null&&root.right==null))
			return ;
		
		solve(root,Long.MIN_VALUE,Long.MAX_VALUE);	*/
		Deque<TreeNode> stack = new LinkedList<>();
	    boolean firstTime = true;
	    TreeNode m = null, n = null, pre = null;
	    while (true) {
	        while (root != null) {
	            stack.push(root);
	            root = root.left;
	        }
	        if (stack.isEmpty()) {
	            break;
	        }
	        TreeNode node = stack.pop();
	        if (pre != null && pre.val > node.val) {
	            if (firstTime) {
	                m = pre;
	                firstTime = false;
	            }
	            n = node;
	        }
	        pre = node;
	        root = node.right;
	    }
	    int tmp = m.val;
	    m.val = n.val;
	    n.val = tmp;
	}

	private static TreeNode solve(TreeNode root, long minValue, long maxValue) {
		if(root==null)
			return null;
		if(root.val>=maxValue || root.val<=minValue)
			return root;
		TreeNode left = solve(root.left,minValue,root.val);
		TreeNode right = solve(root.right,root.val,maxValue);
		if(left!=null && right!=null){
			int temp = left.val;
			left.val = right.val;
			right.val = temp;
			return null;
		}else if(left!=null){
			if(left.val<root.val)
				return left;
			else{
				int temp = left.val;
				left.val = root.val;
				root.val = temp;
				return null;
			}
		}else if(right!=null){
			if(right.val>root.val)
				return right;
			else{
				int temp = root.val;
				root.val = right.val;
				right.val = temp;
				return null;
			}
			
		}else{
			return null;
		}
		
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
