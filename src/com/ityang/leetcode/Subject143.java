package com.ityang.leetcode;

import java.util.Stack;

public class Subject143 {
	
	public void reorderList(ListNode head) {
		if(head==null || head.next==null || head.next.next==null)
			return;
		ListNode fast = head,slow = head;
		while(true){
			if(fast==null || fast.next==null || fast.next.next==null)
				break;
			slow = slow.next;
			fast = fast.next.next;
		}
		fast = slow.next;
		slow.next = null;
		Stack<ListNode> stack = new Stack<>();
		while(fast!=null){
			stack.push(fast);
			fast = fast.next;
		}
		slow = head;
		while(!stack.isEmpty()){
			ListNode node = stack.pop();
			node.next = slow.next;
			slow.next = node;
			slow = node.next;
		}
	}

	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
}
