package com.ityang.leetcode;

import com.ityang.leetcode.Subject24.ListNode;

public class Subject25 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static ListNode reverseKGroup(ListNode head, int k) {
		if (k <= 1 || head == null || head.next == null)
			return head;
		ListNode front = head, tail = head;

		for (int i = 0; i < k - 1; i++) {
			if (tail == null) {
				break;
			}
			tail = tail.next;
		}
		if (tail == null)
			return head;
		ListNode pre = front,mid = front.next,next = mid.next;
		while(mid!=tail){
			mid.next = pre;
			pre = mid;
			mid = next;
			next = next.next;
		}
		mid.next = pre;
		front.next = reverseKGroup(next, k);
		return tail;
	}

	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
}
