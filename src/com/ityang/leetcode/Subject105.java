package com.ityang.leetcode;

public class Subject105 {
	
	public static TreeNode buildTree(int[] preorder, int[] inorder) {
		int len = preorder.length;
		if(len<=0)
			return null;
		if(len==1)
			return new TreeNode(preorder[0]);
		return solve(preorder,0,len-1,inorder,0,len-1);
	}
	
	public static TreeNode solve(int[] preorder, int preOrderLeftIndex, int preOrderRightIndex,
			int[] inorder, int inOrderLeftIndex, int inOrderRightIndex){
			
			if(preOrderRightIndex-preOrderLeftIndex<0)
				return null;
			
			int rootVal = preorder[preOrderLeftIndex];
			TreeNode node = new TreeNode(rootVal);
			int rootInOrderIndex = findIndex(inorder,inOrderLeftIndex,inOrderRightIndex,rootVal);
			
			int leftChildNum = rootInOrderIndex-inOrderLeftIndex;
			
			node.left = solve(preorder, preOrderLeftIndex+1,preOrderLeftIndex+leftChildNum, inorder, inOrderLeftIndex,inOrderLeftIndex+leftChildNum-1);
			node.right = solve(preorder, preOrderLeftIndex+leftChildNum+1, preOrderRightIndex, inorder, leftChildNum+inOrderLeftIndex+1, inOrderRightIndex);
			
			return node;
	}
	private static int findIndex(int[] inorder, int inOrderLeftIndex, int inOrderRightIndex, int rootVal) {
		
		for(int i=inOrderLeftIndex;i<=inOrderRightIndex;i++)
			if(inorder[i]==rootVal)
				return i;
		return -1;
		
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
