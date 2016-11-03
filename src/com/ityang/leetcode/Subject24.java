package com.ityang.leetcode;

public class Subject24 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static ListNode swapPairs(ListNode head) {
		if(head==null || head.next==null)
			return head;
		ListNode first = head,second = head.next;
		ListNode remain = swapPairs(second.next);
		second.next = first;
		first.next = remain;
		return second;
	}

	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
}
