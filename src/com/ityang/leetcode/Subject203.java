package com.ityang.leetcode;

public class Subject203 {

	public ListNode removeElements(ListNode head, int val) {
		
		if(head==null)
			return head;
		ListNode font = new ListNode(-1),cur = font;
		font.next = head;
		while(cur.next!=null){
			if(cur.next.val==val)
				cur.next = cur.next.next;
			else
				cur = cur.next;
				
		}
		return font.next;
	}

	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
}
