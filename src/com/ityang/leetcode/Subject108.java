package com.ityang.leetcode;

import com.ityang.leetcode.Subject105.TreeNode;

public class Subject108 {
	public static TreeNode sortedArrayToBST(int[] nums) {
		
		if(nums==null || nums.length==0)
			return null;
		return solve(nums,0,nums.length);
	}

	private static TreeNode solve(int[] nums, int left, int right) {
		
		if(left>right)
			return null;
		int mid = left+(right-left)/2;
		TreeNode node = new TreeNode(nums[mid]);
		node.left = solve(nums, left, mid-1);
		node.right = solve(nums,mid+1,right);
		return node;
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
