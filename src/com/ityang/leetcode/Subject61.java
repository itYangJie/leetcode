package com.ityang.leetcode;

public class Subject61 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ListNode rotateRight(ListNode head, int k) {

		if (head == null || head.next == null)
			return head;
		ListNode helper = new ListNode(0);
		helper.next = head;
		ListNode cur = head;
		int len = 1;
		while (cur.next != null) {
			cur = cur.next;
			len++;
		}
		ListNode tail = cur;
		k %= len;
		int position = len - k;
		cur = head;
		while (position-- > 1)
			cur = cur.next;
		if (cur.next == null)
			return head;
		helper.next = cur.next;
		cur.next = null;
		tail.next = head;
		return helper.next;
	}

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
}
