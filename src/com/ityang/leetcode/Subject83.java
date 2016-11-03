package com.ityang.leetcode;

import com.ityang.leetcode.Subject82.ListNode;

public class Subject83 {

	public static void main(String[] args) {

	}

	public static ListNode deleteDuplicates(ListNode head) {
		
		if(head==null || head.next==null)
			return head;
		ListNode tail = head,cur = head.next;
		while( cur!=null){
			
			if(cur.val!=tail.val){
				tail.next = cur;
				tail = tail.next;
			}
			
			cur = cur.next;
			
		}
		tail.next = null;
		return head;
	}

	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
}
