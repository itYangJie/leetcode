package com.ityang.leetcode;

import java.util.ArrayList;
import java.util.List;

import com.ityang.leetcode.Subject94.TreeNode;

public class Subject95 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> res = new ArrayList<Integer>();
		res.add(null);
		System.out.println(res.get(0));
	}

	public static List<TreeNode> generateTrees(int n) {
		if(n<1)
			return new ArrayList<TreeNode>();
		return solve(1,n);
	}

	private static List<TreeNode> solve(int left, int right) {
		List<TreeNode> res = new ArrayList<TreeNode>();
		
		if(left>right){
			res.add(null);
		}
		for(int i=left;i<=right;i++){
			List<TreeNode> lefts = solve(left,i-1);
			List<TreeNode> rights = solve(i+1,right);
			int leftLength = lefts.size();
			int rightLength = rights.size();
			for(int j=0;j<leftLength;j++)
				for(int k=0;k<rightLength;k++){
					TreeNode root = new TreeNode(i);
					root.left = lefts.get(j);
					root.right = rights.get(k);
					res.add(root);
				}
			
		}
		return res;
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
