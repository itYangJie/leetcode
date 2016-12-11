package com.ityang.leetcode;

public class Subject222 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		TreeNode left = new TreeNode(2);
		TreeNode right = new TreeNode(3);
		root.left = left;
		root.right = right;
		System.out.println(countNodes(root));
	}
	/**
	 *              1
	 *             / \
	 *            2   3
	 *           / \  / \
	 *          4   5 6  7
	 *         / \
	 *         8 9
	 * @param root
	 * @return
	 */
	public static int countNodes(TreeNode root) {
		if(root==null)
			return 0;
		int level = 1;
		TreeNode cur = root.left;
		while(cur!=null){
			level++;
			cur = cur.left;
		}
		cur = root.left;
		int leftFarRightLevel = 1;
		while(cur!=null){
			cur = cur.right;
			leftFarRightLevel++;
		}
		int leftCount = 0,rightCount = 0;
		if(leftFarRightLevel<level){
			leftCount = countNodes(root.left);
			rightCount = (int) (Math.pow(2, level-2)-1);
		}else{
			leftCount = (int) (Math.pow(2, level-1)-1);
			rightCount = countNodes(root.right);
		}
		return 1+leftCount+rightCount;
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
