package com.ityang.leetcode;

public class Subject2 {

	public static void main(String[] args) {
		ListNode l1 = new ListNode(2);
		ListNode l3 = new ListNode(4);
		ListNode l5 = new ListNode(3);
		l1.next = l3;
		l3.next = l5;
		
		ListNode l2 = new ListNode(5);
		ListNode l4 = new ListNode(6);
		ListNode l6 = new ListNode(4);
		l2.next = l4;
		l4.next = l6;
		
		ListNode res = addTwoNumbers(l1, l2);
		while(res!=null){
			System.out.println(res.val);
			res = res.next;
		}
	}
	
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode result = new ListNode(-1);
		result.next = null;
		
		ListNode current = result;
		int c = 0;
		while(l1!=null&&l2!=null){
			int num = l1.val+l2.val+c;
			ListNode newNode = new ListNode(num%10);
			current.next = newNode;
			current = current.next;
			c = num / 10;
			l1 = l1.next;
			l2 = l2.next;
		}
		while(l1!=null){
			int num = l1.val+c;
			ListNode newNode = new ListNode(num%10);
			current.next = newNode;
			current = current.next;
			c = num / 10;
			l1 = l1.next;
		}
		while(l2!=null){
			int num = l2.val+c;
			ListNode newNode = new ListNode(num%10);
			current.next = newNode;
			current = current.next;
			c = num / 10;
			l2 = l2.next;
		}
		if(c!=0){
			ListNode newNode = new ListNode(c);
			newNode.next = null;
			current.next = newNode;
		}
		return result.next;
	}
}

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		val = x;
	}
}

