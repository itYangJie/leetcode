package com.ityang.leetcode;

import com.ityang.leetcode.Subject141.ListNode;

public class Subject142 {

	public ListNode detectCycle(ListNode head) {
		
		if(head==null || head.next==null)
			return null;
		ListNode fast = head,slow = head;
		while(fast!=null && fast.next!=null){
			fast = fast.next.next;
			slow = slow.next;
			if(fast==slow)
				break;
		}
		if(fast==null || fast.next==null)
			return null;
		slow = head;
		while(slow!=fast){
			slow = slow.next;
			fast = fast.next;
		}
		return slow;
	}

	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}
}
