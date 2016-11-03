package com.ityang.leetcode;

public class Subject117 {
	
	public void connect(TreeLinkNode root) {
		
		if(root==null)
			return;
		
		solve(root);
	}

	private TreeLinkNode solve(TreeLinkNode root) {
		if(root==null)
			return null;
		
		TreeLinkNode leftChilds = solve(root.left);
		TreeLinkNode rightChilds = solve(root.right);
		
		TreeLinkNode leftCur = leftChilds;
		TreeLinkNode rightCur = rightChilds;
		
		while(leftCur!=null && rightChilds!=null){
			leftCur.next = rightCur;
			leftCur = (leftCur.right==null?leftCur.left:leftCur.right);
			rightCur = (rightCur.left==null?rightCur.right:rightCur.left);
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
