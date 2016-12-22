package com.ityang.leetcode;

public class Subject237 {
	public void deleteNode(ListNode node) {
		
		if(node==null)
			return;
		ListNode pre = node;
		ListNode cur = node.next;
		while(true){
			pre.val = cur.val;
			cur = cur.next;
			if(cur==null){
				pre.next = null;
				break;
			}
			pre = pre.next;
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
