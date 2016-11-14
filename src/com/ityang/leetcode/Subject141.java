package com.ityang.leetcode;

public class Subject141 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean hasCycle(ListNode head) {
		if(head==null)
			return false;
		ListNode fast = head.next,slow = head;
		while(fast!=null && fast.next!=null){
			if(fast==slow)
				return true;
			fast = fast.next.next;
			slow = slow.next;
		}
		
		return false;
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
