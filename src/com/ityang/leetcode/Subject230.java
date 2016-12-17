package com.ityang.leetcode;

public class Subject230 {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(4);
		TreeNode left = new TreeNode(2);
		TreeNode right = new TreeNode(6);
		root.left = left;
		root.right = right;
		System.out.println(kthSmallest(root, 3));
	}

	public static int kthSmallest(TreeNode root, int k) {
		
		int leftChildNum = getNodeNum(root.left);
		if(leftChildNum>=k)
			return kthSmallest(root.left, k);
		else if(leftChildNum==k-1){
			return root.val;
		}else{
			return kthSmallest(root.right, k-leftChildNum-1);
		}
	}

	private static int getNodeNum(TreeNode root) {
		if(root==null)
			return 0;
		return 1+getNodeNum(root.left)+getNodeNum(root.right);
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
