package com.ityang.leetcode;

public class NumArrayMuTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NumArrayMuTable numArray = new NumArrayMuTable(new int[] { -2, 0, 3, -5, 2, -1 });
		System.out.println(numArray.sumRange(0, 2));
		numArray.update(1, 5);

		System.out.println(numArray.sumRange(0, 2));

	}

	private int[] nums;
	private SegmentTreeNode root;
	public NumArrayMuTable(int[] nums) {
		if (nums == null || nums.length == 0)
			return;
		root = buildTree(nums,0,nums.length-1);
	}

	private SegmentTreeNode buildTree(int[] nums, int start, int end) {
		if(start>end)
			return null;
		SegmentTreeNode node = new SegmentTreeNode(start, end);
		if(start==end){
			node.sum = nums[start];
			return node;
		}
			
		int mid = start+(end-start)/2;
		// start--mid mid+1--end
		node.left = buildTree(nums, start, mid);
		node.right = buildTree(nums, mid+1, end);
		node.sum = node.left.sum+node.right.sum;
		return node;
	}

	public int sumRange(int i, int j) {
		return sumRange(root,i,j);
	}
	private int sumRange(SegmentTreeNode root,int start, int end) {
		if(root.start==start && root.end==end)
			return root.sum;
		int mid = root.start+(root.end-root.start)/2;
		if(mid>=end)
			return sumRange(root.left,start, end);
		else if(start>mid)
			return sumRange(root.right,start,end);
		else
			return sumRange(root.left,start,mid)+sumRange(root.right,mid+1,end);
	}
	public void update(int i, int val) {
		update(root,i,val);
	}
	private void update(SegmentTreeNode root,int pos,int val){
		if(root.start==root.end){
			root.sum = val;
			return;
		}
		int mid = root.start + (root.end - root.start) / 2;
		if(pos<=mid)
			update(root.left,pos,val);
		else
			update(root.right,pos,val);
		root.sum = root.left.sum+root.right.sum;
		
	}
	private class SegmentTreeNode{
		int start,end,sum;
		SegmentTreeNode left,right;
		public SegmentTreeNode(int start,int end) {
			this.start = start;
			this.end = end;
		}
	}
}
