package com.ityang.leetcode;

import com.ityang.leetcode.Subject83.ListNode;

public class Subject86 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static ListNode partition(ListNode head, int x) {
		if(head==null || head.next==null)
			return head;
		ListNode cur = head,less = new ListNode(-1),greater=new ListNode(-1),curLess = less,curGreater = greater;
		
		while(cur != null){
			ListNode node = new ListNode(cur.val);
			if(cur.val<x){
				curLess.next = node;
				curLess = curLess.next;
			}else{
				curGreater.next = node;
				curGreater = curGreater.next;
			}
			cur = cur.next;
		}
		curGreater.next = null;
		if(less.next==null)
			return greater.next;
		curLess.next = greater.next;
		return less.next;
		
	}
	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
}
