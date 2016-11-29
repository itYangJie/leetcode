package com.ityang.leetcode;

public class Subject206 {

	public ListNode reverseList(ListNode head) {
		
		if(head==null || head.next==null)
			return head;
		ListNode pre = head,cur = pre.next,next = cur.next;
		head.next = null;
		while(cur!=null){
			cur.next = pre;
			pre = cur;
			cur = next;
			if(next!=null)
				next =  next.next;
		}
		return pre;
		
	}

	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
}
