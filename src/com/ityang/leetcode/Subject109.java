package com.ityang.leetcode;

import java.util.ArrayList;

import com.ityang.leetcode.Subject108.TreeNode;

public class Subject109 {

	public static TreeNode sortedListToBST(ListNode head) {
		if (head == null)
			return null;
		if (head.next == null)
			return new TreeNode(head.val);

		ArrayList<ListNode> list = new ArrayList<>();
		while (head != null) {
			list.add(head);
			head = head.next;
		}
		return solve(list, 0, list.size()-1);

	}

	private static TreeNode solve(ArrayList<ListNode> list, int left, int right) {

		if (left > right)
			return null;
		int mid = left + (right - left) / 2;
		TreeNode node = new TreeNode(list.get(mid).val);
		node.left = solve(list, left, mid - 1);
		node.right = solve(list, mid + 1, right);
		return node;
	}

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
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
