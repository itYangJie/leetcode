package com.ityang.leetcode;

public class Subject116 {
	
	public void connect(TreeLinkNode root) {
		
		if(root==null)
			return;
		if(root.left==null){
			root.next = null;
			return ;
		}
		
		solve(root);
	}

	private TreeLinkNode solve(TreeLinkNode root) {
		if(root==null)
			return null;
		
		TreeLinkNode leftChilds = solve(root.left);
		TreeLinkNode rightChilds = solve(root.right);
		
		TreeLinkNode leftCur = leftChilds;
		TreeLinkNode rightCur = rightChilds;
		
		while(leftCur!=null){
			leftCur.next = rightCur;
			leftCur = leftCur.right;
			rightCur = rightCur.left;
		}
		root.next = null;
		return root;
	}

	public class TreeLinkNode {
		int val;
		TreeLinkNode left, right, next;
		TreeLinkNode(int x) {
			val = x;
		}
	}
	
	
}
