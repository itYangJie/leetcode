package com.ityang.leetcode;

public class Subject160 {
	
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if(headA==null || headB==null)
			return null;
		int lenA = 0,lenB = 0;
		ListNode curA = headA,curB = headB;
		while(curA!=null){
			lenA++;
			curA = curA.next;
		}
		while(curB!=null){
			lenB++;
			curB = curB.next;
		}
		
		if(lenA<=lenB){
			curA = headA;
			curB = headB;
		}else{
			curA = headB;
			curB = headA;
		}
		
		for(int i=Math.abs(lenA-lenB);i>0;i--){
			curB = curB.next;
		}
		while(curA!=null){
			if(curA==curB)
				return curA;
			curA = curA.next;
			curB = curB.next;
		}
		return null;
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
