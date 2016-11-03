package com.ityang.leetcode;

import com.ityang.leetcode.Subject105.TreeNode;

public class Subject106 {
	 public static TreeNode buildTree(int[] inorder, int[] postorder) {
		int len = inorder.length;
		if(len<=0)
			return null;
		if(len==1)
			return new TreeNode(inorder[0]);
		return solve(inorder,0,len-1,postorder,0,len-1);
	}
	
	public static TreeNode solve(int[] inorder, int inOrderLeftIndex, int inOrderRightIndex,
			int[] postorder, int postOrderLeftIndex, int postOrderRightIndex){
			
			if(inOrderRightIndex-inOrderLeftIndex<0)
				return null;
			
			int rootVal = postorder[postOrderRightIndex];
			TreeNode node = new TreeNode(rootVal);
			int rootInOrderIndex = findIndex(inorder,inOrderLeftIndex,inOrderRightIndex,rootVal);
			
			int leftChildNum = rootInOrderIndex-inOrderLeftIndex;
			
			node.left = solve(inorder,inOrderLeftIndex ,inOrderLeftIndex+leftChildNum-1 , postorder, postOrderLeftIndex,postOrderLeftIndex+leftChildNum-1);
			node.right = solve(inorder,inOrderLeftIndex+leftChildNum+1 , inOrderRightIndex, postorder,postOrderLeftIndex+leftChildNum , postOrderRightIndex-1);
			
			return node;
	}
	private static int findIndex(int[] inorder, int inOrderLeftIndex, int inOrderRightIndex, int rootVal) {
		
		for(int i=inOrderLeftIndex;i<=inOrderRightIndex;i++)
			if(inorder[i]==rootVal)
				return i;
		return -1;
		
	}
}
